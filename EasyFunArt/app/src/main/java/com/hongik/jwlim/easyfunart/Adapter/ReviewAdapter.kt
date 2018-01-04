package com.hongik.jwlim.easyfunart.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hongik.jwlim.easyfunart.Model.ReviewData
import com.hongik.jwlim.easyfunart.R
import com.hongik.jwlim.easyfunart.ViewHolder.ReviewViewHolder

/**
 * Created by JWLIM on 2018-01-04.
 */
class ReviewAdapter (var dataList : ArrayList<ReviewData>?) : RecyclerView.Adapter<ReviewViewHolder>(){


    private var onItemClick : View.OnClickListener? = null
    private var headerFlag : Boolean? = false;

    override fun onBindViewHolder(holder: ReviewViewHolder?, position: Int) {
//        if(position==0)
//            holder!!.isHeader=true
//        if(!holder!!.isHeader){
//            holder!!.reviewImg.setImageResource(dataList!!.get(position).reviewImage)
//            holder!!.reviewName.text = dataList!!.get(position).reviewName
//            holder!!.reviewContent.text = dataList!!.get(position).reviewContent
//            holder!!.reviewDate.text = dataList!!.get(position).reviewDate
//            holder!!.beforeDate.text = dataList!!.get(position).beforeDate
//            holder!!.reviewStar.setImageResource(dataList!!.get(position).reviewStar)
//            holder!!.reviewTitle.text = dataList!!.get(position).reviewTitle
//
//        }

        holder!!.reviewImg.setImageResource(dataList!!.get(position).reviewImage)
        holder!!.reviewName.text = dataList!!.get(position).reviewName
        holder!!.reviewContent.text = dataList!!.get(position).reviewContent
        holder!!.reviewDate.text = dataList!!.get(position).reviewDate
        holder!!.beforeDate.text = dataList!!.get(position).beforeDate
        holder!!.reviewStar.setImageResource(dataList!!.get(position).reviewStar)
        holder!!.reviewTitle.text = dataList!!.get(position).reviewTitle



    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ReviewViewHolder {
        var mainView : View

        headerFlag = false
        mainView = LayoutInflater.from(parent!!.context).inflate(R.layout.review_item, parent, false)

        mainView.setOnClickListener(onItemClick)
        return ReviewViewHolder(mainView)
    }

    override fun getItemCount(): Int = dataList!!.size

    fun setOnItemClickListener(l: View.OnClickListener){
        onItemClick = l
    }
}