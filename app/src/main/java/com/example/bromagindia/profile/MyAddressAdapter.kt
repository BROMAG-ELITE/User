package com.example.bromagindia.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bromagindia.R
import java.util.ArrayList

class MyAddressAdapter(val context: MyAddressActivity, var addLists: ArrayList<MyAddressList>) : RecyclerView.Adapter<MyAddressAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.address_items, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(this.addLists[position])
    }

    override fun getItemCount(): Int {
        return addLists.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.findViewById<TextView>(R.id.name)
        val address = itemView.findViewById<TextView>(R.id.address)



        fun bindItems(addLists: MyAddressList) {

            name.text=addLists.name
            address.text=addLists.add

        }
    }



}



