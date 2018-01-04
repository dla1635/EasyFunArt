package com.hongik.jwlim.easyfunart.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.hongik.jwlim.easyfunart.Adapter.RecommendAdapter
import com.hongik.jwlim.easyfunart.Model.RecommendData
import com.hongik.jwlim.easyfunart.R
import kotlinx.android.synthetic.main.activity_recommend.*

class RecommendActivity : AppCompatActivity() , View.OnClickListener {
    override fun onClick(p0: View?) {

    }

    private var recomendList : RecyclerView? = null
    private var recomendDatas : ArrayList<RecommendData>? = null
    private var adapter : RecommendAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)

        tabbar_search_button.setOnClickListener {
            startActivity(Intent(applicationContext, RecommendActivity::class.java))
        }

        recomendList = findViewById(R.id.recomend_recyclerView) as RecyclerView
        recomendList!!.layoutManager = LinearLayoutManager(this)

        recomendDatas = ArrayList<RecommendData>()
        recomendDatas!!.add(RecommendData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        recomendDatas!!.add(RecommendData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        recomendDatas!!.add(RecommendData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        recomendDatas!!.add(RecommendData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))

        adapter = RecommendAdapter(this, recomendDatas)
        adapter!!.setOnItemClickListener(this)
        recomendList!!.adapter = adapter
    }
}
