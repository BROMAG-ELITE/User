package com.example.bromagindia.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.bromagindia.R

class RegisterActivity : AppCompatActivity() {

    var signin: TextView?=null
    var reg: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        signin=findViewById(R.id.txtSignIn)
        reg=findViewById(R.id.btnRegister)

        signin?.setOnClickListener{
            val intent= Intent(this, MobileNumberActivity ::class.java)
            startActivity(intent)
        }
        reg?.setOnClickListener{
            val intent= Intent(this, MobileNumberActivity ::class.java)
            startActivity(intent)
        }
    }
}