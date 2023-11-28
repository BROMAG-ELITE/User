package com.example.bromagindia.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.example.bromagindia.MainActivity
import com.example.bromagindia.R

class OtpActivity : AppCompatActivity() {

    var login: Button?=null
    var back: LinearLayout?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        login=findViewById(R.id.btnLogin)

        back=findViewById(R.id.backOtp)
        back?.setOnClickListener {
            onBackPressed()
            finish()
        }

        login?.setOnClickListener{
            val intent= Intent(this, MainActivity ::class.java)
            startActivity(intent)
        }
    }
}