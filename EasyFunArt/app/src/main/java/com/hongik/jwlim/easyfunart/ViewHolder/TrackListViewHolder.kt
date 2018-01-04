package com.hongik.jwlim.easyfunart.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.bumptech.glide.RequestManager
import com.hongik.jwlim.easyfunart.R

/**
 * Created by JWLIM on 2018-01-02.
 */
class TrackListViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    var TrackList_number : TextView = itemView!!.findViewById(R.id.trackList_number) as TextView
    var TrackList_title : TextView = itemView!!.findViewById(R.id.trackList_title) as TextView

}