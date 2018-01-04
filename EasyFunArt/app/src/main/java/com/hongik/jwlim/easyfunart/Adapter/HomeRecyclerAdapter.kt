package com.hongik.jwlim.easyfunart.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hongik.jwlim.easyfunart.Model.HomeRecyclerData
import com.hongik.jwlim.easyfunart.R
import com.hongik.jwlim.easyfunart.ViewHolder.HomeRecyclerViewHolder

/**
 * Created by minha on 2018-01-04.
 */
class HomeRecyclerAdapter(var context : Context, var dataList : ArrayList<HomeRecyclerData>?) : RecyclerView.Adapter<HomeRecyclerViewHolder>() {
    private var onItemClick : View.OnClickListener? = null

    fun setOnItemClickListener(l: View.OnClickListener){
        onItemClick = l
    }

    override fun getItemCount(): Int = dataList!!.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeRecyclerViewHolder {
        val mainView : View = LayoutInflater.from(parent!!.context).inflate(R.layout.contain_main_test, parent, false)
        mainView.setOnClickListener(onItemClick)
        return HomeRecyclerViewHolder(mainView)
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder?, position: Int) {
        holder!!.homeRecyclerTopics.text = "주제입니다"
        holder!!.homeRecyclerImage1.setImageResource(dataList!!.get(position).homeRecyclerImage1)
        holder!!.homeRecyclerTitle1.text = dataList!!.get(position).homeRecyclerTitle1
        holder!!.homeRecyclerDate1.text = dataList!!.get(position).homeRecyclerDate1
        holder!!.homeRecyclerPlace1.text = dataList!!.get(position).homeRecyclerPlace1
        holder!!.homeRecyclerHeart1.setBackgroundResource(dataList!!.get(position).homeRecyclerHeart1)
        holder!!.homeRecyclerDocent1.setBackgroundResource(dataList!!.get(position).homeRecyclerDocent1)
        holder!!.homeRecyclerScore1.text = (dataList!!.get(position).homeRecyclerScore1)
        holder!!.homeRecyclerStar1.setImageResource(R.drawable.main_star_full)

        holder!!.homeRecyclerImage2.setImageResource(dataList!!.get(position).homeRecyclerImage2)
        holder!!.homeRecyclerTitle2.text = dataList!!.get(position).homeRecyclerTitle2
        holder!!.homeRecyclerDate2.text = dataList!!.get(position).homeRecyclerDate2
        holder!!.homeRecyclerPlace2.text = dataList!!.get(position).homeRecyclerPlace2
        holder!!.homeRecyclerHeart2.setBackgroundResource(dataList!!.get(position).homeRecyclerHeart2)
        holder!!.homeRecyclerDocent2.setBackgroundResource(dataList!!.get(position).homeRecyclerDocent2)
        holder!!.homeRecyclerScore2.text = (dataList!!.get(position).homeRecyclerScore2)
        holder!!.homeRecyclerStar2.setImageResource(R.drawable.main_star_full)

        holder!!.homeRecyclerImage3.setImageResource(dataList!!.get(position).homeRecyclerImage3)
        holder!!.homeRecyclerTitle3.text = dataList!!.get(position).homeRecyclerTitle3
        holder!!.homeRecyclerDate3.text = dataList!!.get(position).homeRecyclerDate3
        holder!!.homeRecyclerPlace3.text = dataList!!.get(position).homeRecyclerPlace3
        holder!!.homeRecyclerHeart3.setBackgroundResource(dataList!!.get(position).homeRecyclerHeart3)
        holder!!.homeRecyclerDocent3.setBackgroundResource(dataList!!.get(position).homeRecyclerDocent3)
        holder!!.homeRecyclerScore3.text = (dataList!!.get(position).homeRecyclerScore1)
        holder!!.homeRecyclerStar3.setImageResource(R.drawable.main_star_full)
    }
}
