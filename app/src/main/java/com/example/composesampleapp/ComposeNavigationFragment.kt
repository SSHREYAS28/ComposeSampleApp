package com.example.composesampleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.composesampleapp.databinding.ComposeNavigationFragmentBinding

class ComposeNavigationFragment: Fragment() {
    private lateinit var binding: ComposeNavigationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ComposeNavigationFragmentBinding.inflate(inflater, container, false)
        binding.btnAsCompose.setOnClickListener {
            findNavController().navigate(R.id.action_composeNavigationFragment_to_launchTabFragment, null)
        }
        return binding.root
    }

}