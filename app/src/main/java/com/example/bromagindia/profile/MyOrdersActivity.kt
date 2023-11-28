package com.example.bromagindia.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bromagindia.R
import com.example.bromagindia.auth.OtpActivity
import com.example.bromagindia.menu.MenuAdapter
import com.example.bromagindia.menu.MenuList

class MyOrdersActivity : AppCompatActivity() {

    var adapter: MyOrdersAdapter?=null
    var rv: RecyclerView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orders)

        rv = findViewById(R.id.orderRecyclerview)
        rv?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)



        val m = ArrayList<MyOrdersList>()
        m.add(MyOrdersList(R.drawable.vegetarian,"Dish 1","120","2 November 2023"))
        m.add(MyOrdersList(R.drawable.vegetarian,"Dish 2","50","26 October 2023"))
        m.add(MyOrdersList(R.drawable.vegetarian,"Dish 3","78", "11 October 2023"))
        m.add(MyOrdersList(R.drawable.vegetarian,"Dish 4","100","4 September 2023"))
        m.add(MyOrdersList(R.drawable.vegetarian,"Dish 5","40","19 June 2023"))
        m.add(MyOrdersList(R.drawable.vegetarian,"Dish 6","10","7 January 2022"))
        m.add(MyOrdersList(R.drawable.vegetarian,"Dish 7","220","13 August 2022"))
        m.add(MyOrdersList(R.drawable.vegetarian,"Dish 8","56","6 March 2022"))

        adapter = MyOrdersAdapter(this, m)
        rv?.adapter = adapter
    }
}