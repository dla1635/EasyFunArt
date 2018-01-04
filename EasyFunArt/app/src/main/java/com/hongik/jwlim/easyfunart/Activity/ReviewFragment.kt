package com.hongik.jwlim.easyfunart.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.hongik.jwlim.easyfunart.R

/**
 * Created by JungWonhee on 2017-12-31.
 */
class ReviewFragment: Fragment() {
    private var reviewList : RecyclerView?=null
    private var reviewDatas : ArrayList<ReviewData>?=null
    private var adapter : ReviewAdapter? = null

    val TAG : String = " LOG::ReviewFragment"
    var button  :Button? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_review, container, false)
        Log.v(TAG, "onCreateView")
        button = v!!.findViewById(R.id.write_review) as Button

        button!!.setOnClickListener{//이전 버튼 클릭시.
            val intent = Intent(getActivity(), WriteReview::class.java)
            startActivity(intent)
        }
        reviewList = v.findViewById(R.id.main_list) as RecyclerView

        reviewList!!.layoutManager = LinearLayoutManager(context)

        reviewDatas = ArrayList<ReviewData>()
        reviewDatas!!.add(ReviewData(R.raw.jwh, "정원희", "피카츄",R.drawable.detailpg_star_on,"2017-01-24","1일전","1전시 제목입니당"))
        reviewDatas!!.add(ReviewData(R.raw.jwh, "임종완", "이상해씨",R.drawable.detailpg_star_on,"2017-01-25","2일전","2전시 제목입니당"))
        reviewDatas!!.add(ReviewData(R.raw.jwh, "김다혜", "파이리",R.drawable.detailpg_star_on,"2017-01-26","3일전","3전시 제목입니당"))
        reviewDatas!!.add(ReviewData(R.raw.jwh, "홍주영", "꼬부기",R.drawable.detailpg_star_on,"2017-01-27","4일전","4전시 제목입니당"))
        reviewDatas!!.add(ReviewData(R.raw.jwh, "김은영", "피카츄",R.drawable.detailpg_star_on,"2017-01-28","5일전","5전시 제목입니당"))
        reviewDatas!!.add(ReviewData(R.raw.jwh, "신예지", "이상해씨",R.drawable.detailpg_star_on,"2017-01-29","6일전","6전시 제목입니당"))
        reviewDatas!!.add(ReviewData(R.raw.jwh, "정승후", "파이리",R.drawable.detailpg_star_on,"2017-01-30","7일전","7전시 제목입니당"))
        reviewDatas!!.add(ReviewData(R.raw.jwh, "권민하", "꼬부기",R.drawable.detailpg_star_on,"2017-01-31","8일전","8전시 제목입니당"))
        reviewDatas!!.add(ReviewData(R.raw.jwh, "박지윤", "피카츄",R.drawable.detailpg_star_on,"2017-01-01","9일전","9전시 제목입니당"))
        reviewDatas!!.add(ReviewData(R.raw.jwh, "이동수", "이상해씨",R.drawable.detailpg_star_on,"2017-01-02","10일전","10전시 제목입니당"))
        reviewDatas!!.add(ReviewData(R.raw.jwh, "이혜진", "파이리",R.drawable.detailpg_star_on,"2017-01-03","11일전","11전시 제목입니당"))
        reviewDatas!!.add(ReviewData(R.raw.jwh, "김지혜", "꼬부기",R.drawable.detailpg_star_on,"2017-01-04","12일전","12전시 제목입니당"))

        adapter = ReviewAdapter(reviewDatas)

     //   adapter!!.setOnItemClickListener(this)

        reviewList!!.adapter = adapter
        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.v(TAG, "onCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "onResume")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.v(TAG, "onAttach")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "onDestroy")
    }

    override fun onPause() {
        super.onPause()
//        EventBus.getInstance().unregister(this)
        Log.v(TAG, "onPause")
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.v(TAG, "onViewCreated")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v(TAG, "onDetach")
    }

}
