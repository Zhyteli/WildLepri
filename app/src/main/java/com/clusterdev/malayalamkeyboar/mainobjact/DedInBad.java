package com.clusterdev.malayalamkeyboar.mainobjact;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

@Entity(indexes = {
        @Index(value = "idRed, teplo")
})
public class DedInBad {
    @Id
    private String idRed;
    private String teplo;

    @Generated(hash = 1378403499)
    public DedInBad() {
    }

    @NotNull
    @Override
    public String toString() {
        return "DedInBad{" +
                "idRed='" + idRed + '\'' +
                ", teplo='" + teplo + '\'' +
                '}';
    }

    @Generated(hash = 929958740)
    public DedInBad(String idRed, String teplo) {
        this.idRed = idRed;
        this.teplo = teplo;
    }

    public String getIdRed() {
        return idRed;
    }

    public void setIdRed(String idRed) {
        this.idRed = idRed;
    }

    public String getTeploBad() {
        return teplo;
    }

    public void setTeploBad(String teplo) {
        this.teplo = teplo;
    }

    public String getTeplo() {
        return this.teplo;
    }

    public void setTeplo(String teplo) {
        this.teplo = teplo;
    }
}
