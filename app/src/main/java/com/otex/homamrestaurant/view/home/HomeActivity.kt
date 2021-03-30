package com.otex.homamrestaurant.view.home

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.otex.homamrestaurant.databinding.ActivityHomeBinding
import com.otex.homamrestaurant.view.order.OrderActivity
import com.otex.homamrestaurant.view.baseActivity.BaseActivity

class HomeActivity : BaseActivity() {
    lateinit var binding: ActivityHomeBinding
    private var homeActivityViewModel : HomeActivityViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initialize()

        getHomeDashBord()
        click()
    }

    private fun getHomeDashBord() {

        homeActivityViewModel!!.getHomeDashbord(this)

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

    @SuppressLint("SetTextI18n")
    private fun initialize() {
        homeActivityViewModel = ViewModelProvider(this).get(HomeActivityViewModel::class.java)
        homeActivityViewModel!!.homeLivedata.observe(this) {

            binding.orderCount.text=it.pending.toString() +" Order"
            binding.deliveredCount.text=it.delivered.toString() +" Order"
            binding.canceledCount.text=it.canceled.toString() +" Order"
            binding.accptedCount.text=it.accepted.toString() +" Order"
            binding.totalStoreCount.text=it.revenue.toString() +" Order"


        }

    }
}