package com.example.bromagindia.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.bromagindia.MainActivity
import com.example.bromagindia.R

class MobileNumberActivity : AppCompatActivity() {

    var otp: Button?=null
    var signup:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_number)

        otp=findViewById(R.id.btnGetOtp)
        signup=findViewById(R.id.txtSignUP)
        otp?.setOnClickListener{
            val intent= Intent(this, OtpActivity ::class.java)
            startActivity(intent)
        }
        signup?.setOnClickListener{
            val intent= Intent(this, RegisterActivity ::class.java)
            startActivity(intent)
        }
    }
}