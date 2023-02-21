package com.clusterdev.malayalamkeyboar.dihilt

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.clusterdev.malayalamkeyboar.datavase.badroom.DaoRoom
import com.clusterdev.malayalamkeyboar.datavase.badroom.MainRDatabase
import com.clusterdev.malayalamkeyboar.mainobjact.Ded
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DiModule {

    @Provides
    @Singleton
    fun roomDatabaseMain(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, MainRDatabase::class.java, "ded_t.db")
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provDaoDataRoom(rom: MainRDatabase): DaoRoom = rom.dedDao()

    @Provides
    fun provideDed() = Ded()

}