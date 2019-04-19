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
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        presenter.bind(this) // связывам вью и презентер
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show() //функция для показа Toast сообщений
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        load()  // вызываем загрузку данных
    }

    private fun setMarkers(sberUntis: List<SberUnit>) { // функция для установки марекров
        for (i in sberUntis) {
            mMap.addMarker(MarkerOptions().position(LatLng(i.getLat(), i.getLong())).title(i.getUsNumber()))
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(55.751244, 37.618423))) // движение камеры центр Москвы
    }



    override fun onError(t: Throwable?) {

        showToast(t.toString())

    }

    override fun onLoad(response: List<SberUnit>) {
        listUnits.addAll(response) // добавление полученных объектов в массив
        setMarkers(listUnits) // установка маркеров
    }

    override fun load() {
        return presenter.load() // вызов загрузки объектов у презентера
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbind() // открепление вью от презентера
    }
}
