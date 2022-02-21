package com.example.popularlibrariesapp.di.modules

import android.content.Context
import com.example.popularlibrariesapp.db.GithubDatabase
import com.example.popularlibrariesapp.db.dao.ReposDao
import com.example.popularlibrariesapp.db.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDb(context: Context): GithubDatabase {
        return GithubDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun providesUserDao(db: GithubDatabase): UserDao {
        return db.userDao
    }

    @Provides
    @Singleton
    fun providesRepoDao(db: GithubDatabase): ReposDao {
        return db.reposDao
    }
}