package com.hongik.jwlim.easyfunart.Activity

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hongik.jwlim.easyfunart.R

/**
 * Created by minha on 2018-01-04.
 */
class SearchFirstFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.search_first_fragment, container, false)

        Log.v(ContentValues.TAG, "onCreateView")
        if(arguments != null){
            //v!!.first_text.text = arguments.getString("title")
        }
        //v!!.first_text.text = ApplicationObject.name
        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(ContentValues.TAG, "onCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.v(ContentValues.TAG, "onResume")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.v(ContentValues.TAG, "onAttach")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(ContentValues.TAG, "onDestroy")
    }

    override fun onPause() {
        super.onPause()
//        EventBus.getInstance().unregister(this)
        Log.v(ContentValues.TAG, "onPause")
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v(ContentValues.TAG, "onViewCreated")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v(ContentValues.TAG, "onDetach")
    }
    //Attach->Create->CreateView->ViewCreated->Resume
}