package com.otex.homamrestaurant.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.otex.homamrestaurant.R
import com.otex.homamrestaurant.databinding.ActivityLoginBinding
import com.otex.homamrestaurant.utlitites.PrefsUtil
import com.otex.homamrestaurant.view.home.HomeActivity
import com.otex.homamrestaurant.view.start.MainActivity
import com.otex.homamrestaurant.view.baseActivity.BaseActivity
import com.otex.homamrestaurant.view.login.model.ModelLogin
import java.util.HashMap


class LoginActivity : BaseActivity() {

    private var loginviewmodel : LoginActivityViewModel? = null
    lateinit var binding: ActivityLoginBinding
    var email_or_phone:String=""
    var password:String=""
    var type:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()

        click()

    }

    private fun click() {


        binding.backbtn.setOnClickListener {
            //startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


        binding.btnLogin.setOnClickListener {
            email_or_phone=binding.editEmailPhone.text.toString()
            password=binding.editPassword.text.toString()
            if(email_or_phone == ""){
                binding.editEmailPhone.setError(getString(R.string.enter_email))
            }else if(password == ""){
                binding.editPassword.setError(getString(R.string.enter_password))
            }else{

                login(email_or_phone,password)
            }

        }
    }

    private fun login(emailOrPhone: String, password: String) {

        val map = HashMap<String, String?>()
        map.put("email",emailOrPhone)
        map.put("password",password)
        loginviewmodel!!.makeLogin(this, map)

    }

    private fun initialize() {
        loginviewmodel = ViewModelProvider(this).get(LoginActivityViewModel::class.java)
        loginviewmodel!!.loginLivedata.observe(this){

            saveDataInShared(it)
            Toast.makeText(this,getString(R.string.login_success), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }





    }

    private fun saveDataInShared(it: ModelLogin?) {
        PrefsUtil.with(this).add("token",it!!.token).apply()
        PrefsUtil.with(this).add("id",it.restaurant.id).apply()
        PrefsUtil.with(this).add("username",it.restaurant.name).apply()
        PrefsUtil.with(this).add("email",it.restaurant.email).apply()
    }


}