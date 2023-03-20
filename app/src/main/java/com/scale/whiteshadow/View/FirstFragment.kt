package com.scale.whiteshadow.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.scale.whiteshadow.R
import com.scale.whiteshadow.data.MainViewModel
import com.scale.whiteshadow.ui.screens.PokedexSearchScreenContent
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            viewModel.pokemonInfoList.observe(viewLifecycleOwner) {
                setContent {
                    PokedexSearchScreenContent(viewModel, onClick = {   pokemonInfo ->
                        viewModel.selectedPokemon.postValue(pokemonInfo)
                        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                    })
                }
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
    }
}