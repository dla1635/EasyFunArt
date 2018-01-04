package com.hongik.jwlim.easyfunart.Activity

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.hongik.jwlim.easyfunart.R


/**
 * Created by JungWonhee on 2017-12-31.
 */
class DisplayFragment: Fragment() {
    var button  :Button? = null
    val TAG : String = " LOG::GalleryFragment"
 //   var imageView : ImageView ? = findViewById(R.id.profile)
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_display, container, false)
        Log.v(TAG, "onCreateView")
//        Glide.with(this).load("https://drive.google.com/open?id=1GkY8n_8t4p928mVCRxXhChgsYFQBj94z")
//                .bitmapTransform(CropCircleTransformation(context))
//                .into(profile)


        //  button = v!!.findViewById(R.id.more_info) as Button
//
//            button!!.setOnClickListener{//이전 버튼 클릭시.
//                val intent = Intent(getActivity(), ArtistInfo::class.java)
//                startActivity(intent)
//            }
        return v
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.v(TAG, "onCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "onResume")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.v(TAG, "onAttach")


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "onDestroy")
    }

    override fun onPause() {
        super.onPause()
//        EventBus.getInstance().unregister(this)
        Log.v(TAG, "onPause")
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.v(TAG, "onViewCreated")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v(TAG, "onDetach")
    }
}
