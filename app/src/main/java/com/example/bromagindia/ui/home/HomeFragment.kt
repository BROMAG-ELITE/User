package com.example.bromagindia.ui.home

import android.Manifest
import android.content.Context.*
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.MediaController
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.bromagindia.PlayContestActivity
import com.example.bromagindia.profile.ProfileActivity
import com.example.bromagindia.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import java.util.Locale
import java.util.Timer
import java.util.TimerTask


class HomeFragment : Fragment(){

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    var bVideo:VideoView?=null
    var mediaController:android.widget.MediaController?=null
    var recyclerview :RecyclerView?=null
    var videoAdapter:VideoAdapter?=null

    var adapter: BannerAdapter?=null
    var viewPager: ViewPager?=null
    var topnotchAdapter: TopnotchBannerAdapter?=null
    var topnotchViewPager: ViewPager?=null
    var nvAdapter: NonvegBannerAdapter?=null
    var nvViewPager: ViewPager?=null
    var vAdapter: VegBannerAdapter?=null
    var vViewPager: ViewPager?=null
    var adAdapter: AdvertisementBannerAdapter?=null
    var adViewPager: ViewPager?=null
    var fbAdapter: FeedbackBannerAdapter?=null
    var fbViewPager: ViewPager?=null

    var currentPage = 0
    var timer: Timer? = null
    val DELAY_MS: Long = 6000
    val PERIOD_MS: Long = 3000
    val NUM_PAGES=5

    var fbCurrentPage = 0
    var fbTimer: Timer? = null
    val fbDELAY_MS: Long = 6000
    val fbPERIOD_MS: Long = 3000
    val fbNUM_PAGES=5

    var nvCurrentPage = 0
    var nvTimer: Timer? = null
    val nvDELAY_MS: Long = 6000
    val nvPERIOD_MS: Long = 3000
    val nvNUM_PAGES=5

    var vCurrentPage = 0
    var vTimer: Timer? = null
    val vDELAY_MS: Long = 6000
    val vPERIOD_MS: Long = 3000
    val vNUM_PAGES=5

    var adCurrentPage = 0
    var adTimer: Timer? = null
    val adDELAY_MS: Long = 6000
    val adPERIOD_MS: Long = 3000
    val adNUM_PAGES=5

    var tnCurrentPage = 0
    var tnTimer: Timer? = null
    val tnDELAY_MS: Long = 8000
    val tnPERIOD_MS: Long = 3000
    val tnNUM_PAGES=7

    var tbImage:CardView?=null
    var play:Button?=null
    var profile:ImageView?=null
    var table:Button? = null


    var loc: TextView? = null
    var progress: ProgressBar? = null


    companion object{
        private val REQUEST_PERMISSION_CODE = 2020
    }

    private var myMap:GoogleMap?=null

    var map:CardView?=null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        tbImage = root.findViewById(R.id.card_view)
        play = root.findViewById(R.id.btnPlayContest)
        loc = root.findViewById(R.id.cAddress)
        progress =root.findViewById(R.id.progress)
        map=root.findViewById(R.id.mapCard)
        table=root.findViewById(R.id.btnBookTable)

        table?.setOnClickListener {
            val intent= Intent(activity, TableActivity::class.java)
            startActivity(intent)
        }

        map!!.setOnClickListener {
            val intent= Intent(activity, BromagMapsActivity::class.java)
            startActivity(intent)
        }

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        permission()



        play!!.setOnClickListener {
            val intent= Intent(activity, PlayContestActivity::class.java)
            startActivity(intent)
//            requireActivity().finish()
        }

        profile = root.findViewById(R.id.profileImage)

        profile!!.setOnClickListener {
            val intent= Intent(activity, ProfileActivity::class.java)
            startActivity(intent)
//            requireActivity().finish()
        }


        tbImage?.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.navigation_dining)
        }

        viewPager = root.findViewById(R.id.viewPager)
        topnotchViewPager = root.findViewById(R.id.topnotchViewPager)
        nvViewPager = root.findViewById(R.id.nvViewPager)
        vViewPager = root.findViewById(R.id.vViewPager)
        adViewPager = root.findViewById(R.id.adViewPager)
        fbViewPager = root.findViewById(R.id.fbViewPager)
        recyclerview = root.findViewById(R.id.vR1)


        bVideo = root.findViewById(R.id.bromagVideo) as VideoView?

        val path = "android.resource://" + requireActivity().packageName + "/" + R.raw.bromag
        val uri =Uri.parse(path)
        bVideo?.setVideoURI(uri)

        mediaController = MediaController(activity)
        bVideo?.setMediaController(mediaController)

//        recyclerview?.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
//        val vdModels = ArrayList<VideoList>()
//        vdModels.add(VideoList("android.resource://" + requireActivity().packageName + "/" + R.raw.vd1))
//        vdModels.add(VideoList("android.resource://" + requireActivity().packageName + "/" + R.raw.vd2))
//
//        videoAdapter = VideoAdapter(this, vdModels)
//        recyclerview?.adapter = videoAdapter

        val handler = Handler()
        val update = Runnable {
            if (currentPage === NUM_PAGES - 1) {
                currentPage = 0
            }
            viewPager?.setCurrentItem(currentPage++, true)
        }
        timer = Timer()
        timer!!.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, DELAY_MS, PERIOD_MS)

        val fbHandler = Handler()
        val fbUpdate = Runnable {
            if (fbCurrentPage === fbNUM_PAGES - 1) {
                fbCurrentPage = 0
            }
            fbViewPager?.setCurrentItem(fbCurrentPage++, true)
        }
        fbTimer = Timer()
        fbTimer!!.schedule(object : TimerTask() {
            override fun run() {
                fbHandler.post(fbUpdate)
            }
        }, fbDELAY_MS, fbPERIOD_MS)

        val nvHandler = Handler()
        val nvUpdate = Runnable {
            if (nvCurrentPage === nvNUM_PAGES - 1) {
                nvCurrentPage = 0
            }
            nvViewPager?.setCurrentItem(nvCurrentPage++, true)
        }
        nvTimer = Timer()
        nvTimer!!.schedule(object : TimerTask() {
            override fun run() {
                nvHandler.post(nvUpdate)
            }
        }, nvDELAY_MS, nvPERIOD_MS)

        val vHandler = Handler()
        val vUpdate = Runnable {
            if (vCurrentPage === vNUM_PAGES - 1) {
                vCurrentPage = 0
            }
            vViewPager?.setCurrentItem(vCurrentPage++, true)
        }
        vTimer = Timer()
        vTimer!!.schedule(object : TimerTask() {
            override fun run() {
                vHandler.post(vUpdate)
            }
        }, vDELAY_MS, vPERIOD_MS)

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

        val tnHandler = Handler()
        val tnUpdate = Runnable {
            if (tnCurrentPage === tnNUM_PAGES - 1) {
                tnCurrentPage = 0
            }
            topnotchViewPager?.setCurrentItem(tnCurrentPage++, true)
        }
        tnTimer = Timer()
        tnTimer!!.schedule(object : TimerTask() {
            override fun run() {
                tnHandler.post(tnUpdate)
            }
        }, tnDELAY_MS, tnPERIOD_MS)





        val models = ArrayList<BannerImageList>()
        models.add(BannerImageList(R.drawable.b1))
        models.add(BannerImageList(R.drawable.b2))
        models.add(BannerImageList(R.drawable.b3))
        models.add(BannerImageList(R.drawable.b4))

        adapter = BannerAdapter(this, models)
        viewPager?.adapter = adapter

        val nvModels = ArrayList<NonvegBannerImageList>()
        nvModels.add(NonvegBannerImageList(R.drawable.nv1))
        nvModels.add(NonvegBannerImageList(R.drawable.nv2))
        nvModels.add(NonvegBannerImageList(R.drawable.nv3))
        nvModels.add(NonvegBannerImageList(R.drawable.nv4))
        nvModels.add(NonvegBannerImageList(R.drawable.nv2))

        nvAdapter = NonvegBannerAdapter(this, nvModels)
        nvViewPager?.adapter = nvAdapter

        val vModels = ArrayList<VegBannerImageList>()
        vModels.add(VegBannerImageList(R.drawable.v1))
        vModels.add(VegBannerImageList(R.drawable.v2))
        vModels.add(VegBannerImageList(R.drawable.v3))
        vModels.add(VegBannerImageList(R.drawable.v4))
        vModels.add(VegBannerImageList(R.drawable.v5))

        vAdapter = VegBannerAdapter(this, vModels)
        vViewPager?.adapter = vAdapter

        val adModels = ArrayList<AdvertisementBannerImageList>()
        adModels.add(AdvertisementBannerImageList(R.drawable.ad1))
        adModels.add(AdvertisementBannerImageList(R.drawable.ad2))
        adModels.add(AdvertisementBannerImageList(R.drawable.ad3))
        adModels.add(AdvertisementBannerImageList(R.drawable.ad4))
        adModels.add(AdvertisementBannerImageList(R.drawable.ad5))

        adAdapter = AdvertisementBannerAdapter(this, adModels)
        adViewPager?.adapter = adAdapter

        val topnotchModels = ArrayList<TopnotchBannerImageList>()
        topnotchModels.add(TopnotchBannerImageList(R.drawable.tn1,"Indian"))
        topnotchModels.add(TopnotchBannerImageList(R.drawable.tn2,"Chinese"))
        topnotchModels.add(TopnotchBannerImageList(R.drawable.tn3,"Italian"))
        topnotchModels.add(TopnotchBannerImageList(R.drawable.tn4,"Arabian"))
        topnotchModels.add(TopnotchBannerImageList(R.drawable.tn2,"West African"))

        topnotchAdapter = TopnotchBannerAdapter(this, topnotchModels)
        topnotchViewPager?.adapter = topnotchAdapter

        val fbModels = ArrayList<FeedbackList>()
        fbModels.add(FeedbackList(R.drawable.ad1,"Saravana Bhavan","Chennai","For special occasions, Dragon Delights offers private dining options where you can enjoy an exclusive culinary journey tailored to your preferencesWhere Tradition Meets Innovation."))
        fbModels.add(FeedbackList(R.drawable.ad2,"Thalapakatti","Kanchipuram","For special occasions, Dragon Delights offers private dining options where you can enjoy an exclusive culinary journey tailored to your preferencesWhere Tradition Meets Innovation."))
        fbModels.add(FeedbackList(R.drawable.ad3,"Anjappar","Chennai","For special occasions, Dragon Delights offers private dining options where you can enjoy an exclusive culinary journey tailored to your preferencesWhere Tradition Meets Innovation."))
        fbModels.add(FeedbackList(R.drawable.ad4,"A2B","Bangalore","For special occasions, Dragon Delights offers private dining options where you can enjoy an exclusive culinary journey tailored to your preferencesWhere Tradition Meets Innovation."))
        fbModels.add(FeedbackList(R.drawable.ad2,"Zaitoon","Pune","For special occasions, Dragon Delights offers private dining options where you can enjoy an exclusive culinary journey tailored to your preferencesWhere Tradition Meets Innovation."))

        fbAdapter = FeedbackBannerAdapter(this, fbModels)
        fbViewPager?.adapter = fbAdapter

        return root
    }

    private fun permission() {
        if (ContextCompat.checkSelfPermission(
                requireActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_PERMISSION_CODE
            )

        }
        else {
            loc?.text = ""
            progress?.visibility = View.VISIBLE
            getCurrentLocation()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSION_CODE && grantResults.size>0){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getCurrentLocation()
            }
            else
            {
                Toast.makeText(requireActivity(),"Permission Denied",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getCurrentLocation(){
        var locationRequest = com.google.android.gms.location.LocationRequest()
        locationRequest.priority = com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 10000
        locationRequest.fastestInterval = 5000

        if (ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }

        val geocoder = Geocoder(requireActivity(), Locale.getDefault())
        var address:List<Address>

        LocationServices.getFusedLocationProviderClient(requireActivity())
            .requestLocationUpdates(locationRequest, object : LocationCallback(){
                override fun onLocationResult(p0: LocationResult) {
                    super.onLocationResult(p0)
                    LocationServices.getFusedLocationProviderClient(requireActivity())
                        .removeLocationUpdates(this)
                    if (p0 != null && p0.locations.size>0){
                        var locIndex = p0.locations.size-1

                        var lat =  p0.locations.get(locIndex).latitude
                        var long = p0.locations.get(locIndex).longitude

                        address = geocoder.getFromLocation(lat,long,1)!!
                        var ad:String =address[0].getAddressLine(0)
                        loc?.text =ad
                        if(loc != null){
                            progress?.visibility = View.GONE

                        }
                    }
                }

            }, Looper.getMainLooper())


    }
}