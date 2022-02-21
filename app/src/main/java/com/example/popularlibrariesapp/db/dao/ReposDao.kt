package com.example.popularlibrariesapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.popularlibrariesapp.db.entity.GithubRepoEntity
import io.reactivex.rxjava3.core.Single

@Dao
interface ReposDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repos: List<GithubRepoEntity>)

    @Query("SELECT * FROM GithubRepoEntity WHERE userId = :userId")
    fun getAll(userId: Long): Single<List<GithubRepoEntity>>
}