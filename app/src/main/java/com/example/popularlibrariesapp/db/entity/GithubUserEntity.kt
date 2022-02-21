package com.example.popularlibrariesapp.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GithubUserEntity(
    @PrimaryKey val id: Long,
    val login: String,
    val avatarUrl: String,
    val reposUrl: String,
)
