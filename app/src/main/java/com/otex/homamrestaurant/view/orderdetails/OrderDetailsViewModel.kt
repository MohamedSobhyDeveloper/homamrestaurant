package com.otex.homamrestaurant.view.orderdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderDetailsViewModel : ViewModel() {


    var orderDetailslivedata = MutableLiveData<String>()

    fun getorderdetails(){

        orderDetailslivedata.postValue("Egypt")
    }
}