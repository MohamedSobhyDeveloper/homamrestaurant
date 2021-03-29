package com.otex.homamrestaurant.view.orderdetails

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.otex.homamrestaurant.R
import com.otex.homamrestaurant.databinding.ActivityOrderDetailsBinding
import com.otex.homamrestaurant.view.baseActivity.BaseActivity
import com.otex.homamrestaurant.view.orderdetails.adapter.OrderDetailsAdapter

class OrderDetailsActivity : BaseActivity() {
    lateinit var binding: ActivityOrderDetailsBinding
    private var orderDetailsViewModel : OrderDetailsViewModel? = null
    var type:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
          typeorder()
          initialize()
          click()


    }

    private fun click() {
        binding.backbtn.setOnClickListener {

            finish()
        }
    }

    @SuppressLint("NewApi")
    private fun typeorder() {
         type= intent.getStringExtra("type").toString()

        if(type.equals("waiting")){
            binding.txtType.text=getString(R.string.waiting_order)
            binding.txtType.setTextColor(getColor(R.color.waitcolor))
        }else if(type.equals("delivered")){
            binding.txtType.text=getString(R.string.delivered)
            binding.txtType.setTextColor(getColor(R.color.delivercolor))
        }else if(type.equals("accepted")){
            binding.txtType.text=getString(R.string.accepted_order)
            binding.txtType.setTextColor(getColor(R.color.acceptedcolor))
        }



    }
    private fun initialize() {
        orderDetailsViewModel = ViewModelProvider(this).get(OrderDetailsViewModel::class.java)
        orderDetailsViewModel!!.getorderdetails()
        orderDetailsViewModel!!.orderDetailslivedata.observe(this) {

            val layoutManager = LinearLayoutManager(this)
            binding.recOrderCart.layoutManager = layoutManager
            val adapter =
                OrderDetailsAdapter(this,null)
            binding.recOrderCart.adapter = adapter

        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}