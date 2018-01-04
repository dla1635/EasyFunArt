package com.hongik.jwlim.easyfunart.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.hongik.jwlim.easyfunart.Adapter.HomeFirstAdapter
import com.hongik.jwlim.easyfunart.Adapter.HomeSecondAdapter
import com.hongik.jwlim.easyfunart.Model.HomeFirstData
import com.hongik.jwlim.easyfunart.Model.HomeSecondData
import com.hongik.jwlim.easyfunart.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
//        val idx : Int = pokemonList!!.getChildAdapterPosition(p0)
//        val name : String? = pokemonDatas!!.get(idx).pokemonType
//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }
    // 첫 번째 리사이클러뷰
    private var homeFisrtList : RecyclerView? = null
    private var homeFirstDatas : ArrayList<HomeFirstData>? = null
    private var adapter1 : HomeFirstAdapter? = null

    // 두 번째 리사이클러뷰
    private var testList : RecyclerView? = null
    private var testDatas : ArrayList<HomeSecondData>? = null
    private var adapter2 : HomeSecondAdapter? = null

    // 이건 리사이클러뷰랑 관련 X
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        search_test.setOnClickListener {
            startActivity(Intent(applicationContext, SearchActivity::class.java))
        }

        recommend_test.setOnClickListener {
            startActivity(Intent(applicationContext, RecommendActivity::class.java))
        }

        // 첫 번째 리사이클러뷰
        homeFisrtList = findViewById(R.id.main_recyclerView) as RecyclerView
        homeFisrtList!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        //        val imageView = findViewById(R.id.image_view) as ImageView
//        val drawable = context.getDrawable(R.drawable.background_rounding) as GradientDrawable
//        출처@ http@ //chocorolls.tistory.com/47 [초코롤의 개발이야기]}
////imageView.setBackground(drawable);
//        imageView.setClipToOutline(true);
//
//        출처: http://chocorolls.tistory.com/47 [초코롤의 개발이야기]
////
//
//        imageView.setBackground(drawable)
//        imageView.setClipToOutline(true)


        homeFirstDatas = ArrayList<HomeFirstData>()
        homeFirstDatas!!.add(HomeFirstData(R.drawable.poster, "배준성 개인전"))
        homeFirstDatas!!.add(HomeFirstData(R.drawable.poster, "배준성 개인전"))
        homeFirstDatas!!.add(HomeFirstData(R.drawable.poster, "배준성 개인전"))
        homeFirstDatas!!.add(HomeFirstData(R.drawable.poster, "배준성 개인전"))
        homeFirstDatas!!.add(HomeFirstData(R.drawable.poster, "배준성 개인전"))


        adapter1 = HomeFirstAdapter(homeFirstDatas)
        adapter1!!.setOnItemClickListener(this)
        homeFisrtList!!.adapter = adapter1

        // 두 번째 리사이클러뷰
        testList = findViewById(R.id.main2_recyclerView) as RecyclerView
        testList!!.layoutManager = LinearLayoutManager(this)
        testList!!.setHasFixedSize(true)


        testDatas = ArrayList<HomeSecondData>()
        // test data
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))
        testDatas!!.add(HomeSecondData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))

        adapter2 = HomeSecondAdapter(this, testDatas)
        adapter2!!.setOnItemClickListener(this)
        testList!!.adapter = adapter2


    }
}