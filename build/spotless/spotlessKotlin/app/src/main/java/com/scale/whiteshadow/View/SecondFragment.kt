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
import com.scale.whiteshadow.ui.screens.PokemonInfoScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            viewModel.selectedPokemon.observe(viewLifecycleOwner) {
                setContent {
                    PokemonInfoScreen(
                        content = it,
                        onBackPressed = { findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment) }
                    )
                }
            }
        }
    }
}
