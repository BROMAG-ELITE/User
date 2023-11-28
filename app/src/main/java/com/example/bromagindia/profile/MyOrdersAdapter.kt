package com.example.bromagindia.profile

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bromagindia.R
import java.util.ArrayList

class MyOrdersAdapter(val context: MyOrdersActivity, var menuLists : ArrayList<MyOrdersList>) : RecyclerView.Adapter<MyOrdersAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_items, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(this.menuLists[position],context)
    }

    override fun getItemCount(): Int {
        return menuLists.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img = itemView.findViewById<ImageView>(R.id.menuImage)
        val name = itemView.findViewById<TextView>(R.id.name)
        val price = itemView.findViewById<TextView>(R.id.price)
        val day = itemView.findViewById<TextView>(R.id.day)



        fun bindItems(menuLists: MyOrdersList, context: MyOrdersActivity) {



            Glide.with(context).load(menuLists.image).into(img)
            name.text=menuLists.name
            price.text=menuLists.price
            day.text =menuLists.day

        }
    }



}



