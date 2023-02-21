package com.clusterdev.malayalamkeyboar.datavase.badroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.clusterdev.malayalamkeyboar.mainobjact.Ded;

@Database(entities = Ded.class, version = 1)
public abstract class MainRDatabase extends RoomDatabase {
    public abstract DaoRoom dedDao();
}
