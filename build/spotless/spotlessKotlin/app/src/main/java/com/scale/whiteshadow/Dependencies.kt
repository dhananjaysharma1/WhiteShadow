package com.scale.whiteshadow

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.scale.whiteshadow.data.MainViewModel
import com.scale.whiteshadow.data.PokemonApiService
import com.scale.whiteshadow.data.PokemonRepository
import com.scale.whiteshadow.data.WhiteShadowPokemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Suppress("USELESS_CAST")
object Dependencies {

    private val networkModule = module {
        factory {
            HttpLoggingInterceptor()
                .setLevel(
                    if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                )
        }

        single {
            OkHttpClient.Builder()
                .addInterceptor(get<HttpLoggingInterceptor>())
                .connectTimeout(10, TimeUnit.SECONDS)
                .build()
        }

        single<Gson> {
            GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        }

        single {
            Retrofit.Builder()
                .client(get())
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(get()))
                .build()
        }

        single { PokemonApiService.create(retrofit = get()) }
    }

    private val viewModelModule = module {
        single { Dispatchers.IO as CoroutineDispatcher }

        single { MainViewModel(pokemonRepo = get(), ioDispatcher = get()) }
    }

    private val repositoryModule = module {
        single { WhiteShadowPokemonRepository(apiService = get()) as PokemonRepository }
    }

    internal val appModules = listOf(networkModule, viewModelModule, repositoryModule)
}
