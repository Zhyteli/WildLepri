package com.clusterdev.malayalamkeyboar.datavase.badroom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.clusterdev.malayalamkeyboar.mainobjact.Ded

@Dao
interface DaoRoom {
    @Query("SELECT * FROM ded LIMIT 1")
    fun objectDedGet(): Ded?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun gonaDeda(data: Ded)

    @Query("SELECT * FROM ded")
    fun liveDataDeda(): LiveData<Ded>
}