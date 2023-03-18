package com.scale.whiteshadow

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import com.scale.whiteshadow.Dependencies.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class WhiteShadowApplication: Application(), LifecycleObserver, LifecycleOwner {
    override fun getLifecycle(): Lifecycle {
        return ProcessLifecycleOwner.get().lifecycle
    }

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(applicationContext)
            modules(appModules)
        }
    }
}