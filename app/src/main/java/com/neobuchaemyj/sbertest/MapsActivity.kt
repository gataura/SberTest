package com.neobuchaemyj.sbertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.neobuchaemyj.sbertest.api.model.SberUnit
import com.neobuchaemyj.sbertest.presenter.SberApiPresenter
import com.neobuchaemyj.sbertest.presenter.helpers.SberView

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, SberView {


    private lateinit var mMap: GoogleMap
    val presenter = SberApiPresenter()
    var listUnits = mutableListOf<SberUnit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        presenter.bind(this)
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        load()
    }

    fun setMarkers(sberUntis: List<SberUnit>) {
        for (i in sberUntis) {
            mMap.addMarker(MarkerOptions().position(LatLng(i.getLat(), i.getLong())).title(i.getUsNumber()))
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(55.751244, 37.618423)))
    }



    override fun onError(t: Throwable?) {

        showToast(t.toString())

    }

    override fun onLoad(response: List<SberUnit>) {
        listUnits.addAll(response)
        setMarkers(listUnits)
    }

    override fun load() {
        return presenter.load()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbind()
    }
}
