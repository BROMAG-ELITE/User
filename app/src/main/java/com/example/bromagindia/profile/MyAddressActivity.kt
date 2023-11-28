package com.example.bromagindia.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bromagindia.R
import com.example.bromagindia.auth.OtpActivity

class MyAddressActivity : AppCompatActivity() {

    var adapter: MyAddressAdapter?=null
    var rv: RecyclerView?=null
    var addAddress: LinearLayout?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_address)

        rv = findViewById(R.id.addRecyclerview)
        rv?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        addAddress=findViewById(R.id.addressLay)
        addAddress?.setOnClickListener{
            val intent= Intent(this, ConfirmAddressActivity ::class.java)
            startActivity(intent)
        }

        val m = ArrayList<MyAddressList>()
        m.add(MyAddressList("Home","No 17, Vallal Paari Nagar, Pallikarani, Chennai 600100, TamilNadu, India."))
        m.add(MyAddressList("Work","Rajalakshmi Nagar, Pari Nagar, Pallikaranai, Chennai, Tamil Nadu 600100"))

        adapter = MyAddressAdapter(this, m)
        rv?.adapter = adapter
    }
}