package com.example.bromagindia.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bromagindia.R
import com.example.bromagindia.subcusine.SubCusineGridAdapter
import com.example.bromagindia.subcusine.SubCusineGridList

class MenuActivity : AppCompatActivity() {

    var adapter: MenuAdapter?=null
    var rv: RecyclerView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        rv = findViewById(R.id.menuRecyclerview)
        rv?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        val m = ArrayList<MenuList>()
        m.add(MenuList(R.drawable.vegetarian,"Dish 1","120"))
        m.add(MenuList(R.drawable.vegetarian,"Dish 2","50"))
        m.add(MenuList(R.drawable.vegetarian,"Dish 3","78"))
        m.add(MenuList(R.drawable.vegetarian,"Dish 4","100"))
        m.add(MenuList(R.drawable.vegetarian,"Dish 5","40"))
        m.add(MenuList(R.drawable.vegetarian,"Dish 6","10"))
        m.add(MenuList(R.drawable.vegetarian,"Dish 7","220"))
        m.add(MenuList(R.drawable.vegetarian,"Dish 8","56"))
        m.add(MenuList(R.drawable.vegetarian,"Dish 9","67"))
        m.add(MenuList(R.drawable.vegetarian,"Dish 10","120"))
        m.add(MenuList(R.drawable.vegetarian,"Dish 11","280"))
        m.add(MenuList(R.drawable.vegetarian,"Dish 12","94"))


        adapter = MenuAdapter(this, m)
        rv?.adapter = adapter


    }
}