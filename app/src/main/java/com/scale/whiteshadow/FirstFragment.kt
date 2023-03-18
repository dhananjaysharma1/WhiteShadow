package com.scale.whiteshadow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.scale.whiteshadow.data.MainViewModel
import com.scale.whiteshadow.data.PokemonRepository
import com.scale.whiteshadow.databinding.FragmentFirstBinding
import com.scale.whiteshadow.ui.screens.PokedexSearchScreen
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

//    private var _binding: FragmentFirstBinding? = null
    private val viewModel by viewModel<MainViewModel>()

//    // This property is only valid between onCreateView and
//    // onDestroyView.
//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observePokemonData()
        return ComposeView(requireContext()).apply {
            setContent {
                PokedexSearchScreen()
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    private fun observePokemonData() {
        viewModel.pokemonData.observe(viewLifecycleOwner) {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
    }
}