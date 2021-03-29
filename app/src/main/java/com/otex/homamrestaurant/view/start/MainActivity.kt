package com.otex.homamrestaurant.view.start

import android.content.Intent
import android.os.Bundle
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.otex.homamrestaurant.databinding.ActivityMainBinding
import com.otex.homamrestaurant.view.login.LoginActivity
import com.otex.homamrestaurant.view.baseActivity.BaseActivity


class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        anim_btn()
        click()
    }

    private fun anim_btn() {
        YoYo.with(Techniques.ZoomIn)
            .duration(400)
            .repeat(0)
            .playOn(binding.btnStore)
        YoYo.with(Techniques.ZoomIn)
            .duration(400)
            .repeat(0)
            .playOn(binding.btnDriver)
    }

    private fun click() {
        binding.btnStore.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("type", "store")
            startActivity(intent)
            finish()
        }

        binding.btnDriver.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("type", "driver")
            startActivity(intent)
            finish()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}