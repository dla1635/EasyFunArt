package com.hongik.jwlim.easyfunart.Fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.hongik.jwlim.easyfunart.R

/**
 * Created by JWLIM on 2018-01-04.
 */
class GalleryFragment: Fragment(), OnMapReadyCallback {
    val TAG: String = " LOG::ReviewFragment"
    var mapView: MapView? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_gallery, container, false)
        Log.v(TAG, "onCreateView")
        mapView = v.findViewById(R.id.map) as MapView
        mapView!!.onCreate(savedInstanceState)
        mapView!!.getMapAsync(this)



        return v
    }
    //    override fun onResume(){
//        super.onResume()
//        mapView!!.onResume()
//    }
    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onStart(){
        super.onStart()
        mapView!!.onStart()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView!!.onSaveInstanceState(outState)
    }
    override fun onLowMemory(){
        super.onLowMemory()
        mapView!!.onLowMemory()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.v(TAG, "onCreate")
    }

    override fun onResume() {
        super.onResume()
        // mapView!!.onResume()
        Log.v(TAG, "onResume")

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.v(TAG, "onAttach")

    }

    override fun onDestroy() {
        super.onDestroy()
        mapView!!.onDestroy()
        Log.v(TAG, "onDestroy")
    }

    override fun onPause() {
        super.onPause()
//        EventBus.getInstance().unregister(this)

//        mapView!!.onPause()
        Log.v(TAG, "onPause")
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.v(TAG, "onViewCreated")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v(TAG, "onDetach")
        // mapView!!.onLowMemory()
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        액티비티가 처음 생성될 때 실행되는 함수
//        if (mapView!=null) {
//            mapView!!.onCreate(savedInstanceState)
//        }
    }
    override fun onMapReady(googleMap: GoogleMap) {
        val SEOUL = LatLng(37.56, 126.97)
        val markerOptions = MarkerOptions()
        markerOptions.position(SEOUL)
        markerOptions.title("서울")
        markerOptions.snippet("수도")
        googleMap.addMarker(markerOptions)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL))
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(13f))
    }

}