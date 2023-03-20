package com.scale.whiteshadow

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.fragment.findNavController
import com.scale.whiteshadow.data.MainViewModel
import com.scale.whiteshadow.ui.screens.PokemonInfoScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            viewModel.selectedPokemon.observe(viewLifecycleOwner) {
                setContent {
                    Log.d("HereBeCode:", "onCreateView: $it")
                    PokemonInfoScreen(content = it, onBackPressed = { findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment) })
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}