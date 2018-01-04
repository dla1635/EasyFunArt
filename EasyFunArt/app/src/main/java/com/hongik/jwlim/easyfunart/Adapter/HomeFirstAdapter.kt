package com.hongik.jwlim.easyfunart.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hongik.jwlim.easyfunart.Model.HomeFirstData
import com.hongik.jwlim.easyfunart.R
import com.hongik.jwlim.easyfunart.ViewHolder.HomeFirstViewHolder

/**
 * Created by minha on 2018-01-04.
 */
class HomeFirstAdapter(var dataList : ArrayList<HomeFirstData>?) : RecyclerView.Adapter<HomeFirstViewHolder>() {

    private var onItemClick : View.OnClickListener? = null

    override fun onBindViewHolder(holder: HomeFirstViewHolder?, position: Int) {
        holder!!.homeFirstImage.setImageResource(dataList!!.get(position).homeFirstImage)
        holder!!.homeFirstTitle.text = dataList!!.get(position).homeFirstTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeFirstViewHolder {
        val mainView : View = LayoutInflater.from(parent!!.context).inflate(R.layout.home_first_item, parent, false)
        mainView.setOnClickListener(onItemClick)

        return HomeFirstViewHolder(mainView)
    }

    override fun getItemCount(): Int = dataList!!.size

    fun setOnItemClickListener(l: View.OnClickListener){
        onItemClick = l
    }
}