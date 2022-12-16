package com.aceofhigh.artbooktestingproject.viewmodel

import androidx.lifecycle.ViewModel
import com.aceofhigh.artbooktestingproject.repo.ArtRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArtViewModel @Inject constructor(
    private val repository: ArtRepositoryInterface
) : ViewModel() {
    val artList = repository.getArt()


}