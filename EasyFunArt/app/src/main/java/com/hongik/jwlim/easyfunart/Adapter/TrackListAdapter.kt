package com.hongik.jwlim.easyfunart.Adapter

import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bumptech.glide.RequestManager
import com.hongik.jwlim.easyfunart.Model.TrackData
import com.hongik.jwlim.easyfunart.R
import com.hongik.jwlim.easyfunart.ViewHolder.*
import java.lang.Boolean.TRUE

/**
 * Created by JWLIM on 2018-01-02.
 */
class TrackListAdapter(var trackData: ArrayList<TrackData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val TYPE_FLOOR: Int = 0
    val TYPE_ITEM: Int = 1

    private var onItemClick: View.OnClickListener? = null


    fun setOnItemClickListener(l: View.OnClickListener) {
        onItemClick = l
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {



        if (viewType == TYPE_FLOOR) {
            val v = LayoutInflater.from(parent!!.context).inflate(R.layout.floor_list, parent, false)
            v.setOnClickListener(onItemClick)
            return FloorViewHolder(v)
        }
        else{
            val v = LayoutInflater.from(parent!!.context).inflate(R.layout.tracklist_item, parent, false)
            v.setOnClickListener(onItemClick)
            return TrackListViewHolder(v)
        }

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

        if (holder is FloorViewHolder) {
            holder.Floor.text = trackData.get(position).floor.substring(0,2)
        }else if (holder is TrackListViewHolder) {
            holder.TrackList_number.text = trackData.get(position).floor
            holder.TrackList_title.text = trackData.get(position).title
        }
    }

        override fun getItemViewType(position: Int): Int {
//            Log.d("인덱스사이즈","접근횟수")

            if (trackData.get(position).floor.equals("1층시작")) {
                return TYPE_FLOOR
            } else if (trackData.get(position).floor.equals("2층시작")) {
                return TYPE_FLOOR
            } else if (trackData.get(position).floor.equals("3층시작")) {
                return TYPE_FLOOR
            } else if (trackData.get(position).floor.equals("4층시작")) {
                return TYPE_FLOOR
            } else {
//                Log.d("아이템접근","횟수")
                return TYPE_ITEM
            }

        }



    override fun getItemCount(): Int{
//        Log.d("인덱스사이즈",(splitList1.size.toString()))
        return trackData.size //최대 층수를 idx값에 저장하여 list 사이즈에 더해줌.
    }
}