package com.otex.homamrestaurant.view.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.otex.homamrestaurant.interfaces.HandleRetrofitResp
import com.otex.homamrestaurant.retrofit.HandelCalls
import com.otex.homamrestaurant.utlitites.DataEnum
import com.otex.homamrestaurant.view.home.model.ModelHomeDashBord
import java.util.HashMap

class HomeActivityViewModel:ViewModel(), HandleRetrofitResp {

    var homeLivedata = MutableLiveData<ModelHomeDashBord>()


    fun getHomeDashbord(context: Context){

        HandelCalls.getInstance(context)?.call(DataEnum.home.name, null, true, this)

    }

    override fun onResponseSuccess(flag: String?, o: Any?) {
        if(flag==DataEnum.home.name){
            val modelHomeDashBord: ModelHomeDashBord = o as ModelHomeDashBord
            homeLivedata.value = modelHomeDashBord
        }
    }

    override fun onResponseFailure(flag: String?, o: String?) {
        TODO("Not yet implemented")
    }

    override fun onNoContent(flag: String?, code: Int) {
        TODO("Not yet implemented")
    }

    override fun onBadRequest(flag: String?, o: Any?) {
        TODO("Not yet implemented")
    }

}