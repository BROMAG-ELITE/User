package com.example.bromagindia.ui.home

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.bromagindia.R
import java.util.*

class VideoAdapter(val context: HomeFragment, var videoLists: ArrayList<VideoList>) : RecyclerView.Adapter<VideoAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.video_items,
            parent,
            false
        )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(this.videoLists[position], context)
//        val video_url: String = videoLists[position].uri
//
//        holder.v.setVideoURI(Uri.parse(video_url))


    }

    override fun getItemCount(): Int {
        return videoLists.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val v: VideoView = itemView.findViewById(R.id.video)

        fun bindItems(videoLists: VideoList, context: HomeFragment) {
            val video_url: String = videoLists.uri

            v.setVideoURI(Uri.parse(video_url))
        }
    }


}


