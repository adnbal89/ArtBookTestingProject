package com.aceofhigh.artbooktestingproject.roomdb

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import com.aceofhigh.artbooktestingproject.getOrAwaitValueTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@SmallTest
class ArtDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var database: ArtDatabase

    private lateinit var dao: ArtDao

    @Before
    fun setup() {

        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), ArtDatabase::class.java
        )
            .allowMainThreadQueries() //this is a test case, we don't want other thread pools
            .build()

        dao = database.artDao()
    }

    @After
    fun teardown() {
        database.close()
    }


    @Test
    fun insertArtTesting() = runBlocking {
        val exampleArt = Art("Mona Lisa", "Da Vinci", 1700, "test.com", 1)
        dao.insertArt(exampleArt)

        val list = dao.observeArts().getOrAwaitValueTest()
        assertThat(list).contains(exampleArt)

    }

    @Test
    fun deleteArtTesting() = runTest {
        val exampleArt = Art("Mona Lisa", "Da Vinci", 1700, "test.com", 1)
        dao.insertArt(exampleArt)
        dao.deleteArt(exampleArt)

        val list = dao.observeArts().getOrAwaitValueTest()
        assertThat(list).doesNotContain(exampleArt)

    }

}