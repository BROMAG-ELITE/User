package com.example.bromagindia.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bromagindia.R

class AddtocartActivity : AppCompatActivity() {

    var adapter: AddtocartAdapter?=null
    var rv: RecyclerView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtocart)

        rv = findViewById(R.id.addtocartRecyclerview)
        rv?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        val m = ArrayList<AddtocartList>()
        m.add(AddtocartList(R.drawable.vegetarian,"Dish 1","120"))
        m.add(AddtocartList(R.drawable.vegetarian,"Dish 2","50"))
        m.add(AddtocartList(R.drawable.vegetarian,"Dish 3","78"))
        m.add(AddtocartList(R.drawable.vegetarian,"Dish 3","220"))



        adapter = AddtocartAdapter(this, m)
        rv?.adapter = adapter
    }
}