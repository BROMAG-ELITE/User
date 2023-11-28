package com.example.bromagindia.menu

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

class AddtocartAdapter(val context: AddtocartActivity, var menuLists : ArrayList<AddtocartList>) : RecyclerView.Adapter<AddtocartAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_items, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(this.menuLists[position],context)
    }

    override fun getItemCount(): Int {
        return menuLists.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(menuLists: AddtocartList, context: AddtocartActivity) {
            val img = itemView.findViewById<ImageView>(R.id.menuImage)
            val name = itemView.findViewById<TextView>(R.id.name)
            val price = itemView.findViewById<TextView>(R.id.price)

            val add = itemView.findViewById<Button>(R.id.btnAdd)


            Glide.with(context).load(menuLists.image).into(img)
            name.text=menuLists.name
            price.text=menuLists.price


        }
    }



}



