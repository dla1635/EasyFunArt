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
class SearchViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
    var SearchImage : ImageView = itemView!!.findViewById(R.id.search_recycler_image) as ImageView
    var SearchTitle : TextView = itemView!!.findViewById(R.id.search_recycler_title) as TextView
    var SearchDate : TextView = itemView!!.findViewById(R.id.search_recycler_date) as TextView
    var SearchPlace : TextView = itemView!!.findViewById(R.id.search_recycler_place) as TextView
    var SearchDocent : Button = itemView!!.findViewById(R.id.search_recycler_docent) as Button
    var SearchHeart : Button = itemView!!.findViewById(R.id.search_recycler_heart) as Button
    var SearchScore : TextView = itemView!!.findViewById(R.id.search_recycler_score) as TextView
    var SearchStar : ImageView = itemView!!.findViewById(R.id.search_recycler_star) as ImageView
}