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
class HomeRecyclerViewHolder (itemView: View?) : RecyclerView.ViewHolder(itemView)  {
    var homeRecyclerTopics : TextView = itemView!!.findViewById(R.id.home2_recycler_topics) as TextView

    // first item
    var homeRecyclerImage1 : ImageView = itemView!!.findViewById(R.id.home2_recycler_image1) as ImageView
    var homeRecyclerTitle1 : TextView = itemView!!.findViewById(R.id.home2_recycler_title1) as TextView
    var homeRecyclerDate1 : TextView = itemView!!.findViewById(R.id.home2_recycler_date1) as TextView
    var homeRecyclerPlace1 : TextView = itemView!!.findViewById(R.id.home2_recycler_place1) as TextView
    var homeRecyclerStar1 : ImageView = itemView!!.findViewById(R.id.home2_recycler_star1) as ImageView
    var homeRecyclerScore1 : TextView = itemView!!.findViewById(R.id.home2_recyler_score1) as TextView
    var homeRecyclerDocent1 : Button = itemView!!.findViewById(R.id.home2_recycler_docent1) as Button
    var homeRecyclerHeart1 : Button = itemView!!.findViewById(R.id.home2_recycler_heart1) as Button

    // second item
    var homeRecyclerImage2 : ImageView = itemView!!.findViewById(R.id.home2_recycler_image2) as ImageView
    var homeRecyclerTitle2 : TextView = itemView!!.findViewById(R.id.home2_recycler_title2) as TextView
    var homeRecyclerDate2 : TextView = itemView!!.findViewById(R.id.home2_recycler_date2) as TextView
    var homeRecyclerPlace2 : TextView = itemView!!.findViewById(R.id.home2_recycler_place2) as TextView
    var homeRecyclerStar2 : ImageView = itemView!!.findViewById(R.id.home2_recycler_star2) as ImageView
    var homeRecyclerScore2 : TextView = itemView!!.findViewById(R.id.home2_recyler_score2) as TextView
    var homeRecyclerDocent2 : Button = itemView!!.findViewById(R.id.home2_recycler_docent2) as Button
    var homeRecyclerHeart2 : Button = itemView!!.findViewById(R.id.home2_recycler_heart2) as Button

    // third item
    var homeRecyclerImage3 : ImageView = itemView!!.findViewById(R.id.home2_recycler_image3) as ImageView
    var homeRecyclerTitle3 : TextView = itemView!!.findViewById(R.id.home2_recycler_title3) as TextView
    var homeRecyclerDate3 : TextView = itemView!!.findViewById(R.id.home2_recycler_date3) as TextView
    var homeRecyclerPlace3 : TextView = itemView!!.findViewById(R.id.home2_recycler_place3) as TextView
    var homeRecyclerStar3 : ImageView = itemView!!.findViewById(R.id.home2_recycler_star3) as ImageView
    var homeRecyclerScore3 : TextView = itemView!!.findViewById(R.id.home2_recyler_score3) as TextView
    var homeRecyclerDocent3 : Button = itemView!!.findViewById(R.id.home2_recycler_docent3) as Button
    var homeRecyclerHeart3 : Button = itemView!!.findViewById(R.id.home2_recycler_heart3) as Button


}