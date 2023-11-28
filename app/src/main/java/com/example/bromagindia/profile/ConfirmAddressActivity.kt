package com.example.bromagindia.profile

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.bromagindia.R

class ConfirmAddressActivity : AppCompatActivity() {
    var enterAddress: Button?=null
    var addLay1:LinearLayout?=null
    var addLay2:LinearLayout?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_address)

        enterAddress=findViewById(R.id.btnCompleteAddress)
        addLay1 = findViewById(R.id.completeAddressLay)
        addLay2 = findViewById(R.id.saveAddressLay)


        enterAddress?.setOnClickListener {
            addLay1?.visibility = View.GONE
            addLay2?.visibility = View.VISIBLE
        }

    }
}