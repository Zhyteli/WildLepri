package com.clusterdev.malayalamkeyboar.golk

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.clusterdev.malayalamkeyboar.R
import com.clusterdev.malayalamkeyboar.databinding.ActivityDedEstBinding

class DedEst : AppCompatActivity() {
    private val vok by lazy {
        ActivityDedEstBinding.inflate(layoutInflater)
    }
    private val imageIds = listOf(
        R.drawable.brain,
        R.drawable.cotel,
        R.drawable.dym,
        R.drawable.hors,
        R.drawable.shlip,
        R.drawable.ten
    )
    private var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vok.root)

        vok.startButton.setOnClickListener { startGame() }

    }

    private fun startGame() {
        // Hide the button and show the image
        vok.startButton.visibility = Button.INVISIBLE
        vok.gameImage.visibility = ImageView.VISIBLE

        // Start the animation
        val animation = AnimationUtils.loadAnimation(this, R.anim.slot_animation)
        vok.gameImage.startAnimation(animation)

        // Change the image every second
        val handler = android.os.Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                currentIndex = (currentIndex + 1) % imageIds.size
                vok.gameImage.setImageResource(imageIds[currentIndex])
                handler.postDelayed(this, 100)
            }
        }, 100)
    }

    override fun onBackPressed() {
    }
}