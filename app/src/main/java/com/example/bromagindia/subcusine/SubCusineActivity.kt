package com.example.bromagindia.subcusine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import com.example.bromagindia.R
import com.example.bromagindia.menu.MenuActivity
import com.example.bromagindia.ui.takeaway.TakeawayGridAdapter
import com.example.bromagindia.ui.takeaway.TakeawayGridList

class SubCusineActivity : AppCompatActivity() {

    var adapter: SubCusineGridAdapter?=null
    var gridView: GridView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_cusine)

        gridView = findViewById(R.id.grid)

        val m = ArrayList<SubCusineGridList>()
        m.add(SubCusineGridList(R.drawable.vegetarian,"Vegetarian"))
        m.add(SubCusineGridList(R.drawable.egg,"Egg"))
        m.add(SubCusineGridList(R.drawable.chicken,"Chicken"))
        m.add(SubCusineGridList(R.drawable.mutton,"Mutton"))
        m.add(SubCusineGridList(R.drawable.seafood,"Sea Foods"))


        // on below line we are setting adapter to our grid view.
        gridView!!.adapter = adapter

        adapter = SubCusineGridAdapter(this, m)
        gridView?.adapter = adapter

        gridView!!.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val intent = Intent(this, MenuActivity ::class.java)
                startActivity(intent)
            }

    }
}