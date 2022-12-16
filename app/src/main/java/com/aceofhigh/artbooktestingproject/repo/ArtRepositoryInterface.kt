package com.aceofhigh.artbooktestingproject.repo

import androidx.lifecycle.LiveData
import com.aceofhigh.artbooktestingproject.model.ImageResponse
import com.aceofhigh.artbooktestingproject.roomdb.Art
import com.aceofhigh.artbooktestingproject.util.Resource

interface ArtRepositoryInterface {

    suspend fun insertArt(art: Art)

    suspend fun deleteArt(art: Art)

    fun getArt(): LiveData<List<Art>>

    suspend fun searchImage(imageString: String): Resource<ImageResponse>

}