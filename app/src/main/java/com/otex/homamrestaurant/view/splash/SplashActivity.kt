package com.otex.homamrestaurant.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.otex.homamrestaurant.R
import com.otex.homamrestaurant.databinding.ActivitySplashBinding
import com.otex.homamrestaurant.utlitites.PrefsUtil
import com.otex.homamrestaurant.view.home.HomeActivity
import com.otex.homamrestaurant.view.login.LoginActivity
import com.otex.homamrestaurant.view.start.MainActivity

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    var signstate:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({

            signstate= PrefsUtil.with(this)["token", ""].toString()
            if(signstate.isNotEmpty()) {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }

        }, 2000)
    }
}