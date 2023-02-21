package com.clusterdev.malayalamkeyboar.obj

import android.app.Activity
import com.appsflyer.AppsFlyerLib
import com.clusterdev.malayalamkeyboar.R
import com.onesignal.OneSignal
import net.moznion.uribuildertiny.URIBuilderTiny
import java.util.*

object DedApps{

    fun dedStar(activity: Activity, faseBoom: String, bolt: MutableMap<String, Any>?, gog: String): String {
        val bal = URIBuilderTiny("https://cleolife.online/wild.php")
        val toop = activity.application
        bal.addQueryParameter(
            toop.getString(R.string.rifjmde),
            toop.getString(R.string.trdhjs)
        )
        bal.addQueryParameter(
            toop.getString(R.string.xcvbnm),
            TimeZone.getDefault().id
        )
        bal.addQueryParameter(
            toop.getString(R.string.qwertyuio), gog
        )
        bal.addQueryParameter(
            toop.getString(R.string.wertyuiop),
            faseBoom
        )
        bal.addQueryParameter(
            toop.getString(R.string.asdfghjk),
            when (faseBoom) {
                "null" -> bolt?.get("media_source").toString()
                else -> "deeplink"
            }
        )
        bal.addQueryParameter(
            toop.getString(R.string.zxcvbn),
            when (faseBoom) {
                "null" -> {
                    AppsFlyerLib.getInstance().getAppsFlyerUID(activity)
                }
                else -> "null"
            }
        )
        bal.addQueryParameter(
            toop.getString(R.string.lkjhg),
            bolt?.get("adset_id").toString()
        )
        bal.addQueryParameter(
            toop.getString(R.string.mnb),
            bolt?.get("campaign_id").toString()
        )
        bal.addQueryParameter(
            toop.getString(R.string.poiuytr),
            bolt?.get("campaign").toString()
        )
        bal.addQueryParameter(
            toop.getString(R.string.lsdkfgj),
            bolt?.get("adset").toString()
        )
        bal.addQueryParameter(
            toop.getString(R.string.ryfh),
            bolt?.get("adgroup").toString()
        )
        bal.addQueryParameter(
            toop.getString(R.string.iyhk),
            bolt?.get("orig_cost").toString()
        )
        bal.addQueryParameter(
            toop.getString(R.string.esdhj),
            bolt?.get("af_siteid").toString()
        )
        return bal.build().toString()
    }

    fun holpsw(data1: MutableMap<String, Any>?, data2: String, res: Activity) {
        OneSignal.initWithContext(res.application)
        OneSignal.setAppId("a2cb7334-1f6d-4475-bafb-021a328ad825")
        val kold = "key2"
        val yoplde = data1?.get("campaign").toString()
        if (yoplde == "null" && data2 == "null") {
            OneSignal.sendTag(kold, "organic")
        } else if (yoplde != "null") {
            OneSignal.sendTag(kold, yoplde.substringBefore("_"))
        } else if (data2 != "null") {
            OneSignal.sendTag(kold, data2.replace("myapp://", "").substringBefore("/"))
        }
    }

}