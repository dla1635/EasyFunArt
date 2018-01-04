package com.hongik.jwlim.easyfunart.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.hongik.jwlim.easyfunart.R
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), View.OnClickListener {

//    val tv = findViewById(R.id.textView1) as TextView
//    val s = findViewById(R.id.spinner1) as Spinner
//    s.setOnItemSelectedListener(object:AdapterView.OnItemSelectedListener() {
//        fun onItemSelected(parent:AdapterView<*>, view:View,
//                           position:Int, id:Long) {
//            tv.setText(("position : " + position +
//                    parent.getItemAtPosition(position)))
//        }
//        fun onNothingSelected(parent:AdapterView<*>) {}
//    })


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        search_searchButton.setOnClickListener(this)
        search_backButton.setOnClickListener(this)

        if (savedInstanceState == null) {
            val bundle = Bundle()
            AddFragment(SearchFirstFragment(), bundle, "first")
        }

//        val arrays = arrayOf("최신순", "별점순")
//        search_spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, arrays)

//        pinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
//        spinner.setAdapter(spinnerArrayAdapter);

//        val spinner = findViewById(R.id.spinner) as Spinner
//        val adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, android.R.layout.simple_spinner_item)
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinner.setAdapter(adapter)
        val adapter = ArrayAdapter.createFromResource(this, R.array.spinner, R.layout.search_spinner_title)
        adapter.setDropDownViewResource(R.layout.search_spinner_item)

        search_spinner.adapter = adapter


        search_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            search_searchButton -> {
                // 사용자가 직접 검색
                // 지금 그냥 프래그먼트 보이게 설정
                var bundle = Bundle()
                ReplaceFragment(SearchProceedingFragment(), bundle, "proceeding")
                search_layout.visibility = View.VISIBLE

                // 진행중 버튼
                search_proceedingBtn.setOnClickListener {
                    var bundle = Bundle()
                    ReplaceFragment(SearchProceedingFragment(), bundle, "proceeding")
                    search_proceedingBtn.setBackgroundResource(R.color.colorAccent)
                    search_preparingBtn.setBackgroundResource(R.color.colore1e1e1)
                    search_completeBtn.setBackgroundResource(R.color.colore1e1e1)
                }

                // 준비중 버튼
                search_preparingBtn.setOnClickListener {
                    var bundle = Bundle()
                    ReplaceFragment(SearchPreparingFragment(), bundle, "preparing")
                    search_preparingBtn.setBackgroundResource(R.color.colorAccent)
                    search_proceedingBtn.setBackgroundResource(R.color.colore1e1e1)
                    search_completeBtn.setBackgroundResource(R.color.colore1e1e1)
                }

                // 완료 버튼
                search_completeBtn.setOnClickListener {
                    var bundle = Bundle()
                    ReplaceFragment(SearchCompleteFragment(), bundle, "complete")
                    search_completeBtn.setBackgroundResource(R.color.colorAccent)
                    search_preparingBtn.setBackgroundResource(R.color.colore1e1e1)
                    search_proceedingBtn.setBackgroundResource(R.color.colore1e1e1)
                }
            }
        // 백 버튼
            search_backButton -> {
                // 어디로 가는지 모르겠음
            }
        // 탭 바 홈 버튼
            tabbar_home_button -> {

            }
        // 탭 바 추천 버튼
            tabbar_recommend_button -> {
                startActivity(Intent(applicationContext, RecommendActivity::class.java))
            }
        // 탭 바 도슨트 버튼
            tabbar_docent_button -> {

            }
        // 탭 바 마이페이지 버튼
            tabbar_mypage_button -> {

            }
        }
    }

    fun AddFragment(fragment: Fragment, bundle: Bundle, tag: String) {            //오버라이딩하여 최초에 추가될 프레그먼트 생성함수
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.add(R.id.search_frame, fragment, tag)
        //transaction.addToBackStack(null);
        transaction.commit()
    }

    fun ReplaceFragment(fragment: Fragment, bundle: Bundle, tag: String) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.replace(R.id.search_frame, fragment, tag)
        //transaction.addToBackStack(null)
        transaction.commit()
    }
}
