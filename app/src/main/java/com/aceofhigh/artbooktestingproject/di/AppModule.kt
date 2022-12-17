package com.aceofhigh.artbooktestingproject.di

import android.content.Context
import androidx.room.Room
import com.aceofhigh.artbooktestingproject.R
import com.aceofhigh.artbooktestingproject.api.RetrofitAPI
import com.aceofhigh.artbooktestingproject.repo.ArtRepository
import com.aceofhigh.artbooktestingproject.repo.ArtRepositoryInterface
import com.aceofhigh.artbooktestingproject.roomdb.ArtDao
import com.aceofhigh.artbooktestingproject.roomdb.ArtDatabase
import com.aceofhigh.artbooktestingproject.util.Util.BASE_URL
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            ArtDatabase::class.java, "ArtBookDB"
        ).build()

    @Singleton
    @Provides
    fun provideDao(database: ArtDatabase) = database.artDao()

    @Singleton
    @Provides
    fun provideRetrofitAPI(): RetrofitAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(RetrofitAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideGlide(@ApplicationContext context: Context) =
        Glide.with(context).setDefaultRequestOptions(
            RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
        )

    @Singleton
    @Provides
    fun provideNormalRepo(dao: ArtDao, api: RetrofitAPI) =
        ArtRepository(dao, api) as ArtRepositoryInterface

}