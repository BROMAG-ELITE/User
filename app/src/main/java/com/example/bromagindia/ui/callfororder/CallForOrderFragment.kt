package com.example.bromagindia.ui.callfororder

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.example.bromagindia.R
import com.example.bromagindia.ui.home.AdvertisementBannerAdapter
import com.example.bromagindia.ui.home.AdvertisementBannerImageList
import java.util.Timer
import java.util.TimerTask

class CallForOrderFragment : Fragment() {

    var btnCallNow: Button?=null

    var adAdapter: COAdvertisementBannerAdapter?=null
    var adViewPager: ViewPager?=null

    var adCurrentPage = 0
    var adTimer: Timer? = null
    val adDELAY_MS: Long = 6000
    val adPERIOD_MS: Long = 3000
    val adNUM_PAGES=5
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_call_for_order, container, false)


        btnCallNow = root.findViewById(R.id.btnCall)
        btnCallNow?.setOnClickListener {
            val intentDial = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003099835"))
            startActivity(intentDial)
        }

        adViewPager = root.findViewById(R.id.adViewPager)

        val adHandler = Handler()
        val adUpdate = Runnable {
            if (adCurrentPage === adNUM_PAGES - 1) {
                adCurrentPage = 0
            }
            adViewPager?.setCurrentItem(adCurrentPage++, true)
        }
        adTimer = Timer()
        adTimer!!.schedule(object : TimerTask() {
            override fun run() {
                adHandler.post(adUpdate)
            }
        }, adDELAY_MS, adPERIOD_MS)

        val adModels = ArrayList<AdvertisementBannerImageList>()
        adModels.add(AdvertisementBannerImageList(R.drawable.ad1))
        adModels.add(AdvertisementBannerImageList(R.drawable.ad2))
        adModels.add(AdvertisementBannerImageList(R.drawable.ad3))
        adModels.add(AdvertisementBannerImageList(R.drawable.ad4))
        adModels.add(AdvertisementBannerImageList(R.drawable.ad5))

        adAdapter = COAdvertisementBannerAdapter(this, adModels)
        adViewPager?.adapter = adAdapter

        return root
    }


}