package com.clusterdev.malayalamkeyboar.mainobjact;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;

@Entity(tableName = "ded")
public class Ded {

    @PrimaryKey(autoGenerate = false)
    private int id;
    private String teplo;

    public Ded() {
    }

    public Ded(int id, String teplo) {
        this.id = id;
        this.teplo = teplo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeplo() {
        return teplo;
    }

    public void setTeplo(String teplo) {
        this.teplo = teplo;
    }

    @Override
    public String toString() {
        return "Ded{" +
                "id=" + id +
                ", teplo='" + teplo + '\'' +
                '}';
    }
}
