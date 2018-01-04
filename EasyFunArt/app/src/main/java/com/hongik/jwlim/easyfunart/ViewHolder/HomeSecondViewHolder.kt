package com.hongik.jwlim.easyfunart.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.hongik.jwlim.easyfunart.R

/**
 * Created by minha on 2018-01-04.
 */
class HomeSecondViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var home2Image : ImageView = itemView!!.findViewById(R.id.home2_recycler_image) as ImageView
    var home2Title : TextView = itemView!!.findViewById(R.id.home2_recycler_title) as TextView
    var home2Date : TextView = itemView!!.findViewById(R.id.home2_recycler_date) as TextView
    var home2Place : TextView = itemView!!.findViewById(R.id.home2_recycler_place) as TextView
    var home2Star : ImageView = itemView!!.findViewById(R.id.home2_recycler_star) as ImageView
    var home2Score : TextView = itemView!!.findViewById(R.id.home2_recyler_score) as TextView
    var home2Docent : Button = itemView!!.findViewById(R.id.home2_recycler_docent) as Button
    var home2Heart : Button = itemView!!.findViewById(R.id.home2_recycler_heart) as Button
}