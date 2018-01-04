package com.hongik.jwlim.easyfunart.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.hongik.jwlim.easyfunart.R

/**
 * Created by JWLIM on 2018-01-04.
 */
class ReviewViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var isHeader : Boolean = false
    var reviewImg : ImageView = itemView!!.findViewById(R.id.review_profile) as ImageView
    var reviewDate : TextView = itemView!!.findViewById(R.id.review_date) as TextView
    var beforeDate : TextView = itemView!!.findViewById(R.id.before_date) as TextView
    var reviewName : TextView = itemView!!.findViewById(R.id.review_name) as TextView
    var reviewContent : TextView = itemView!!.findViewById(R.id.review_content) as TextView
    var reviewStar : ImageView = itemView!!.findViewById(R.id.review_star) as ImageView
    var reviewTitle : TextView = itemView!!.findViewById(R.id.review_title) as TextView

}