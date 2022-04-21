package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var image=imageView
        var fadeIn=AnimationUtils.loadAnimation(applicationContext,R.anim.fade_in)
        var roted=AnimationUtils.loadAnimation(applicationContext,R.anim.roted)
        image.startAnimation(fadeIn);
        image.startAnimation(roted)


        Handler().postDelayed(Runnable {


                var intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)

            finish()
        },8000)
    }

}
