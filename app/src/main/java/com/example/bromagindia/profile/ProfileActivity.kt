package com.example.bromagindia.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.BounceInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.bromagindia.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val lay1=findViewById<ConstraintLayout>(R.id.Lay1)
        lay1.setOnClickListener {
            val intent = Intent(this, MyOrdersActivity::class.java)
            startActivity(intent)
        }

        val lay2=findViewById<ConstraintLayout>(R.id.Lay2)
        lay2.setOnClickListener {
            val intent = Intent(this, MyAddressActivity::class.java)
            startActivity(intent)
        }

        val lay3=findViewById<ConstraintLayout>(R.id.Lay3)
        lay3.setOnClickListener {
            val intent = Intent(this, RefundCancelActivity::class.java)
            startActivity(intent)
        }

        val lay4=findViewById<ConstraintLayout>(R.id.Lay4)
        lay4.setOnClickListener {
            val intent = Intent(this, FeedbackActivity::class.java)
            startActivity(intent)
        }

        val lay5=findViewById<ConstraintLayout>(R.id.Lay5)
        lay5.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
        }

        val lay6=findViewById<ConstraintLayout>(R.id.Lay6)
        lay6.setOnClickListener {
            val intent = Intent(this, PrivacyPolicyActivity::class.java)
            startActivity(intent)
        }

        val lay7=findViewById<ConstraintLayout>(R.id.Lay7)
        lay7.setOnClickListener {
            val intent = Intent(this, TermsConditionActivity::class.java)
            startActivity(intent)
        }

        val lay8=findViewById<ConstraintLayout>(R.id.Lay8)
        lay8.setOnClickListener {
            val intent = Intent(this, ContactusActivity::class.java)
            startActivity(intent)
        }

    }
}




