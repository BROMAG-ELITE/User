package com.example.bromagindia.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.bromagindia.R

class RefundCancelActivity : AppCompatActivity() {

    var refund: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refund_cancel)

        refund=findViewById(R.id.txtRefundCancellation)
        refund!!.setOnClickListener {
            val intent = Intent(this, RefundPolicyActivity::class.java)
            startActivity(intent)
        }
    }
}