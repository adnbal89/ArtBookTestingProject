package com.aceofhigh.artbooktestingproject.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.aceofhigh.artbooktestingproject.adapter.ArtRecyclerAdapter
import com.aceofhigh.artbooktestingproject.adapter.ImageRecyclerViewAdapter
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class ArtFragmentFactory @Inject constructor(
    private val artRecyclerAdapter: ArtRecyclerAdapter,
    private val glide: RequestManager,
    private val imageRecyclerViewAdapter: ImageRecyclerViewAdapter
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        return when (className) {
            ArtFragment::class.java.name -> ArtFragment(artRecyclerAdapter)
            ArtDetailsFragment::class.java.name -> ArtDetailsFragment(glide)
            ImageApiFragment::class.java.name -> ImageApiFragment(imageRecyclerViewAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}