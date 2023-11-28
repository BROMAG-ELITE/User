package com.example.bromagindia.walkthrough

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.bromagindia.R

class SliderAdapter (val context: SliderActivity, private val list: List<Slider>) : PagerAdapter() {
    override fun isViewFromObject(v: View, `object`: Any): Boolean {
        // Return the current view
        return v === `object` as View
    }


    override fun getCount(): Int {
        // Count the items and return it
        return list.size
    }


    override fun instantiateItem(parent: ViewGroup, position: Int): Any {

        val list = this.list[position]

        // Get the view from pager page layout
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.slider_items, parent, false)

        // Get the widgets reference from layout
        val image: ImageView = view.findViewById(R.id.slide)
        val title: TextView = view.findViewById(R.id.infoTitle)
        val msg: TextView = view.findViewById(R.id.infoMsg)


        image.setImageResource(list.image)
        title.text=list.title
        msg.text=list.info




        parent.addView(view)

        // Return the view
        return view
    }


    override fun destroyItem(parent: ViewGroup, position: Int, `object`: Any) {
        // Remove the view from view group specified position
        parent.removeView(`object` as View)
    }
}