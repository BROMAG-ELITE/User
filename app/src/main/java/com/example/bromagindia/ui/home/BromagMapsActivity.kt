package com.example.bromagindia.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bromagindia.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.bromagindia.databinding.ActivityBromagMapsBinding

class BromagMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityBromagMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBromagMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val bromag = LatLng(12.9280315,80.2064333)
        mMap.addMarker(MarkerOptions().position(bromag).title("BromagIndia"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bromag))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bromag,14f))
    }
}