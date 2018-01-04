package com.hongik.jwlim.easyfunart.Activity

import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hongik.jwlim.easyfunart.Adapter.TrackListAdapter
import com.hongik.jwlim.easyfunart.ApplicationController
import com.hongik.jwlim.easyfunart.CommonData
import com.hongik.jwlim.easyfunart.Model.TrackData
import com.hongik.jwlim.easyfunart.NetworkService

import com.hongik.jwlim.easyfunart.R

import com.hongik.jwlim.easyfunart.Response.TrackListResponse
import com.hongik.jwlim.easyfunart.ViewHolder.TrackListViewHolder
import kotlinx.android.synthetic.main.activity_track.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrackActivity : AppCompatActivity(), View.OnClickListener {

    private var networkService: NetworkService? = null
    private var trackListAdpater: TrackListAdapter? = null
    private var requestManager : RequestManager? = null
    private var trackData : ArrayList<TrackData>? = null

    var splitList1: ArrayList<TrackData>? = null
    var splitList2: ArrayList<TrackData>? = null
    var splitList3: ArrayList<TrackData>? = null
    var splitList4: ArrayList<TrackData>? = null

    var splitList11: ArrayList<TrackData>? = null
    var splitList22: ArrayList<TrackData>? = null
    var splitList33: ArrayList<TrackData>? = null
    var splitList44: ArrayList<TrackData>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)

//        networkService = ApplicationController.instance!!.networkService
//        getTrackList()
        trackList_reyclerview.layoutManager = LinearLayoutManager(this)
        requestManager = Glide.with(this)

        splitList1 = ArrayList<TrackData>()
        splitList2 = ArrayList<TrackData>()
        splitList3 = ArrayList<TrackData>()
        splitList4 = ArrayList<TrackData>()

        splitList11 = ArrayList<TrackData>()
        splitList22 = ArrayList<TrackData>()
        splitList33 = ArrayList<TrackData>()
        splitList44 = ArrayList<TrackData>()

        trackData = ArrayList<TrackData>()

        trackData!!.add(TrackData("1층","아이유-밤편지"))
        trackData!!.add(TrackData("2층","아이유-밤편지"))
        trackData!!.add(TrackData("2층","아이유-밤지"))
        trackData!!.add(TrackData("2층","아이유-밤편"))
        trackData!!.add(TrackData("3층","아이유-편지"))
        trackData!!.add(TrackData("3층","아이유-밤지"))
        trackData!!.add(TrackData("3층","아이유-밤편"))
        trackData!!.add(TrackData("4층","아이유-편지"))
        trackData!!.add(TrackData("4층","아이유-편지"))
        trackData!!.add(TrackData("4층","아이유-편지"))
        trackData!!.add(TrackData("4층","아이유-편지"))

        for (t in trackData!!) {
            if (t.floor.equals("1층")) {
                splitList1!!.add(t)
            } else if (t.floor.equals("2층")) {
                splitList2!!.add(t)
            } else if (t.floor.equals("3층")) {
                splitList3!!.add(t)
            } else if (t.floor.equals("4층")) {
                splitList4!!.add(t)
            }
        }

        splitList11!!.add(TrackData("1층시작", "1층시작"))
        splitList22!!.add(TrackData("2층시작", "2층시작"))
        splitList33!!.add(TrackData("3층시작", "3층시작"))
        splitList44!!.add(TrackData("4층시작", "4층시작"))

        //층 타이틀을 층 데이터 맨앞에 붙임.
        splitList1!!.addAll(0, splitList11!!)
        splitList2!!.addAll(0, splitList22!!)
        splitList3!!.addAll(0, splitList33!!)
        splitList4!!.addAll(0, splitList44!!)


        //trackList 초기화
        trackData = ArrayList<TrackData>()
        //trackData에 합침.
        trackData!!.addAll(splitList1!!)
        trackData!!.addAll(splitList2!!)
        trackData!!.addAll(splitList3!!)
        trackData!!.addAll(splitList4!!)


//        Log.d("1층",trackData!!.get(0).floor.toString())
//        Log.d("2층",trackData!!.get(1).floor.toString())
//        Log.d("3층",trackData!!.get(2).floor.toString())
//        Log.d("4층",trackData!!.get(3).floor.toString())
//        Log.d("5층",trackData!!.get(4).floor.toString())
//        Log.d("6층",trackData!!.get(5).floor.toString())
//        Log.d("7층",trackData!!.get(6).floor.toString())
//        Log.d("8층",trackData!!.get(7).floor.toString())
//        Log.d("9층",trackData!!.get(8).floor.toString())
//        Log.d("10층",trackData!!.get(9).floor.toString())
//        Log.d("11층",trackData!!.get(10).floor.toString())
//        Log.d("12층",trackData!!.get(11).floor.toString())
//        Log.d("12층",trackData!!.get(12).floor.toString())
//        Log.d("12층",trackData!!.get(13).floor.toString())


        trackListAdpater = TrackListAdapter(trackData!!)//requestManager는 glide 쓰기 위해.
        trackListAdpater!!.setOnItemClickListener(this@TrackActivity)//클릭 이벤트를 위한
        trackList_reyclerview.adapter = trackListAdpater//어댑터에 붙여주기

    }

    fun getTrackList(){

        val getTrack = networkService!!.getTrackList()
        getTrack.enqueue(object : Callback<TrackListResponse>{

            override fun onResponse(call: Call<TrackListResponse>?, response: Response<TrackListResponse>?) {
                if (response!!.isSuccessful) {

                    if(response!!.body().status.equals("success")) {

//                        trackListAdpater = TrackListAdapter(response.body().trackListData, requestManager!!)//requestManager는 glide 쓰기 위해.
                        trackListAdpater!!.setOnItemClickListener(this@TrackActivity)//클릭 이벤트를 위한?
                        trackList_reyclerview.adapter = trackListAdpater//어댑터에 붙여주기
//                        trackData = response.body().trackListData

                    }
                }else{
                    ApplicationController.instance!!.makeToast("fail")
                    Log.d("실패원인",response.body().status)

                }

            }
            override fun onFailure(call: Call<TrackListResponse>?, t: Throwable?) {

            }
        })

    }

    override fun onClick(v: View?) {

        val idx : Int = trackList_reyclerview.getChildAdapterPosition(v)
        val intent = Intent(applicationContext, PlaybackScreen::class.java)
//        intent.putExtra("board_id", boardList!!.get(idx).board_id)
//        intent.putExtra("user_email", CommonData.loginData!!.email)
        startActivity(intent)

    }


}
