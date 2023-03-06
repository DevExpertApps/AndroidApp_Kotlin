package com.reward.pro

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {

    private val splashTime = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val sharedPreference =  getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val permissionCheck = sharedPreference.getBoolean("permissionsGranted", false)

        if(permissionCheck){

            var handler = Handler(Looper.getMainLooper())

            handler.postDelayed({
                val intent = Intent(this@SplashScreen, Login::class.java)
                startActivity(intent)
                finish()
            }, splashTime)
        }
        else{

            var handler = Handler(Looper.getMainLooper())

            handler.postDelayed({
                val intent = Intent(this, Permissions::class.java)
                startActivity(intent)
                finish()
            }, splashTime)

        }
    }
}