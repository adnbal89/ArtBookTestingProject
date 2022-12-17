package com.aceofhigh.artbooktestingproject.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.aceofhigh.artbooktestingproject.R
import com.aceofhigh.artbooktestingproject.adapter.ImageRecyclerViewAdapter
import javax.inject.Inject

class ImageApiFragment @Inject constructor(
    private val imageRecyclerViewAdapter: ImageRecyclerViewAdapter
) : Fragment(R.layout.fragment_image_api) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}