package com.otex.homamrestaurant.view.orderdetails.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.otex.homamrestaurant.databinding.ItemCartBinding
import com.otex.homamrestaurant.view.orderdetails.model.FoodLoveModel

class OrderDetailsAdapter(private val context: Context, val chartList: MutableList<FoodLoveModel>?)
    : RecyclerView.Adapter<OrderDetailsAdapter.MyViewHolder>() {

    var itemBinding: ItemCartBinding?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        itemBinding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
         return MyViewHolder(itemBinding!!)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {




    }



    fun addList(movielist: MutableList<FoodLoveModel>) {

        this.chartList?.addAll(movielist)
        notifyDataSetChanged()
    }




    override fun getItemCount(): Int {
        if (chartList?.size== null) {
            return 5
        } else {
            return chartList?.size!!
        }
    }



    class MyViewHolder(private val itemBinding: ItemCartBinding) : RecyclerView.ViewHolder(itemBinding.root) {



    }
}