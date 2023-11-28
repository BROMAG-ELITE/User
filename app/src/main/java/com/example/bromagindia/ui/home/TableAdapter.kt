package com.example.bromagindia.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bromagindia.R
import com.example.bromagindia.TableBookingActivity
import com.example.bromagindia.subcusine.SubCusineActivity
import com.example.bromagindia.subcusine.SubCusineGridList
import java.util.ArrayList

class TableAdapter(val context: TableActivity, private var iconList: ArrayList<TableList>) : BaseAdapter() {

    override fun getCount(): Int {
        return iconList.size
    }

    override fun getItem(position: Int): Any {
        return iconList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val iList = this.iconList[position]

        val inflater = context.layoutInflater

        val view = inflater.inflate(R.layout.table_grid_items,parent,false)
        val icon = view.findViewById<ImageView>(R.id.icon)
        val no = view.findViewById<TextView>(R.id.tableNo)
        val seat = view.findViewById<TextView>(R.id.seater)
        val book = view.findViewById<TextView>(R.id.btn_booknow)



//        Glide.with(context).load(iList.imageIcon).into(icon)
        icon.setImageResource(iList.imageIcon)

        no.text=iList.tableNo
        seat.text=iList.seater

        book.setOnClickListener {
            val intent= Intent(context, TableBookingActivity::class.java)
            context.startActivity(intent)
        }

        return view
    }
}



