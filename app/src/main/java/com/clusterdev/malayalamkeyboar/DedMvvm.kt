package com.clusterdev.malayalamkeyboar

import android.app.Activity
import android.app.Application
import android.preference.PreferenceManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.clusterdev.malayalamkeyboar.datavase.badroom.WildImplHelperRoom
import com.clusterdev.malayalamkeyboar.dihilt.MainApplicationDiHilt
import com.clusterdev.malayalamkeyboar.mainobjact.Ded
import com.clusterdev.malayalamkeyboar.mainobjact.DedInBad
import com.clusterdev.malayalamkeyboar.obj.DedApps
import com.clusterdev.malayalamkeyboar.obj.DedApps.holpsw
import com.facebook.applinks.AppLinkData
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DedMvvm @Inject constructor(
    private val rst: WildImplHelperRoom
) : ViewModel() {

    fun getLiveDedLink(): LiveData<String> {
        return Transformations.map(rst.liveDed()) {
            it?.teplo
        }
    }

    val getDedTeplo = rst.getDeda()?.teplo

    fun butylDeda(): Boolean {
        return getDedTeplo != null
    }

    fun singl(activity: Activity) {
        AppLinkData.fetchDeferredAppLinkData(activity.application) {
            val appLinkData = it?.targetUri
            if (appLinkData == null) {
                appsFlyerLibDed(activity, appLinkData.toString())
            } else {
                nonTachDed(activity, appLinkData.toString(), null)
            }

        }
    }

    private fun appsFlyerLibDed(
        activity: Activity,
        faseBoom: String
    ) {
        val conversionDataListener = object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(apfData: MutableMap<String, Any>?) {
                nonTachDed(activity, faseBoom, apfData)

            }

            override fun onConversionDataFail(p0: String?) {
                nonTachDed(activity, faseBoom, null)

            }

            override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
            }

            override fun onAttributionFailure(p0: String?) {
            }
        }
        AppsFlyerLib.getInstance().init("EjinWLDbouBMXB4JarKedd", conversionDataListener, activity)
        AppsFlyerLib.getInstance().start(activity)
    }

    fun nonTachDed(
        activity: Activity,
        faseBoom: String,
        anyMutableMap: MutableMap<String, Any>?
    ) {
        viewModelScope.launch {
            val vpl = withContext(Dispatchers.Default) {
                AdvertisingIdClient.getAdvertisingIdInfo(
                    activity.application
                ).id.toString()
            }
            OneSignal.setExternalUserId(vpl)
            val linkOne = DedApps.dedStar(
                activity,
                faseBoom,
                anyMutableMap,
                vpl
            )
            holpsw(
                data1 = anyMutableMap,
                data2 = faseBoom,
                res = activity
            )
            val ded = Ded()
            ded.teplo = linkOne
            rst.sleepDed(ded)
        }

    }

    fun workGameGolDeda(
        application: Application,
        url: String
    ) {
        val dffio = application as MainApplicationDiHilt
        val tyo = dffio.daison
        val edbn = tyo.dedInBadDao
        val prefs = PreferenceManager.getDefaultSharedPreferences(application)
        viewModelScope.launch {
            if (edbn.count() == 0L) {
                if (url != rst.getDeda()?.teplo.toString()) {
                    if (!prefs.getBoolean("firstTime", false)) {
                        try {
                            edbn.insert(
                                DedInBad().apply {
                                    this.idRed = "2"
                                    this.teploBad = url
                                }.also {
                                    dffio.redDed = it
                                })
                        } catch (e: Exception) {
                            Ded().apply {
                                this.teplo = url
                            }.also {
                                rst.sleepDed(it)
                            }
                        }
                        val editor = prefs.edit()
                        editor.putBoolean("firstTime", true)
                        editor.commit()
                    }
                }
            }
        }
    }

    fun workGoogleIndia(yui: String, application: Application) {
        val greenDaoApp = application as MainApplicationDiHilt
        val daoSession = greenDaoApp.daison
        val treasureDao = daoSession.dedInBadDao
        viewModelScope.launch {
            try {
                treasureDao.insert(
                    DedInBad().apply {
                        this.idRed = "2"
                        this.teploBad = yui
                    }.also {
                        greenDaoApp.redDed = it
                    })
            } catch (e: Exception) {
                Ded().apply {
                    this.teplo = yui
                }.also {
                    rst.sleepDed(it)
                }
            }
        }
    }
}