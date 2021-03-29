package com.otex.homamrestaurant.view.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.otex.homamrestaurant.databinding.ActivityHomeBinding
import com.otex.homamrestaurant.view.order.OrderActivity
import com.otex.homamrestaurant.view.baseActivity.BaseActivity

class HomeActivity : BaseActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        type_user()
        click()
    }

    private fun type_user() {
        val type=intent.getStringExtra("type")

        if(type.equals("driver")){
            binding.canceledbtn.visibility=View.GONE
            binding.totalstoreubtn.visibility=View.GONE
        }else{
            Log.e("type","not driver")
        }

    }

    private fun click() {


        binding.waitingbtn.setOnClickListener {
            val intent=Intent(this,OrderActivity::class.java)
            intent.putExtra("type","waiting")
            startActivity(intent)

        }

        binding.deliveredbtn.setOnClickListener {
            val intent=Intent(this,OrderActivity::class.java)
            intent.putExtra("type","delivered")
            startActivity(intent)
        }

        binding.acceptedbtn.setOnClickListener {
            val intent=Intent(this,OrderActivity::class.java)
            intent.putExtra("type","accepted")
            startActivity(intent)
        }

        binding.canceledbtn.setOnClickListener {
            val intent=Intent(this,OrderActivity::class.java)
            intent.putExtra("type","canceled")
            startActivity(intent)
        }

        binding.totalstoreubtn.setOnClickListener {
//            val intent=Intent(this,OrderActivity::class.java)
//            intent.putExtra("type","canceled")
//            startActivity(intent)
        }

        binding.totaldeliveryubtn.setOnClickListener {
//            val intent=Intent(this,OrderActivity::class.java)
//            intent.putExtra("type","canceled")
//            startActivity(intent)
        }

    }
}