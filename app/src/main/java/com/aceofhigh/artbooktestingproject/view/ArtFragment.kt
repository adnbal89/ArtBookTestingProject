package com.aceofhigh.artbooktestingproject.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aceofhigh.artbooktestingproject.R
import com.aceofhigh.artbooktestingproject.databinding.FragmentArtsBinding

class ArtFragment : Fragment(R.layout.fragment_arts) {
    private lateinit var fragmentBinding: FragmentArtsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentArtsBinding.bind(view)
        fragmentBinding = binding

        binding.fab.setOnClickListener {
            findNavController().navigate(ArtFragmentDirections.actionArtFragmentToArtDetailsFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}