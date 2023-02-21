package com.clusterdev.malayalamkeyboar.dihilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import com.clusterdev.malayalamkeyboar.datavase.gree.RedHelp
import com.clusterdev.malayalamkeyboar.mainobjact.DaoMaster
import com.clusterdev.malayalamkeyboar.mainobjact.DaoSession
import com.clusterdev.malayalamkeyboar.mainobjact.DedInBad

@HiltAndroidApp
class MainApplicationDiHilt : Application() {
    lateinit var daison: DaoSession
    var redDed: DedInBad? = null

    override fun onCreate() {
        super.onCreate()
        val openHelper = RedHelp(this, "DED_IN_BAD.db")
        val database = openHelper.writableDatabase
        daison = DaoMaster(database).newSession()
    }
}