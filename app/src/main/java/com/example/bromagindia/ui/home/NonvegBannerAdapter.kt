package com.example.bromagindia.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.bromagindia.R

class NonvegBannerAdapter(val context: HomeFragment, private val list: List<NonvegBannerImageList>) : PagerAdapter() {

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
            .inflate(R.layout.nonveg_banner_items, parent, false)

        // Get the widgets reference from layout
        val image: ImageView = view.findViewById(R.id.bannerImage)

        Glide.with(context).load(list.bannerImage).into(image)



        parent.addView(view)

        // Return the view
        return view
    }


    override fun destroyItem(parent: ViewGroup, position: Int, `object`: Any) {
        // Remove the view from view group specified position
        parent.removeView(`object` as View)
    }
}


