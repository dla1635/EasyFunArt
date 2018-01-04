package com.hongik.jwlim.easyfunart.Response

import android.widget.TextView
import com.hongik.jwlim.easyfunart.Model.TrackData

/**
 * Created by JWLIM on 2018-01-02.
 */
data class TrackListResponse (

        var trackListData : ArrayList<TrackData>,
        var msg : String,
        var status : String



)