package com.example.composesampleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.example.composesampleapp.databinding.LaunchTabFragmentBinding
import com.example.mylibrary.TabBarScreen

class LaunchTabFragment: Fragment() {

    private lateinit var binding: LaunchTabFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)
        binding = LaunchTabFragmentBinding.inflate(layoutInflater)

        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                TabBarScreen()
            }
        }

        return binding.root
    }
}