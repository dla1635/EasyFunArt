package com.hongik.jwlim.easyfunart.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.util.Log
import com.hongik.jwlim.easyfunart.Adapter.TabAdapter

import com.hongik.jwlim.easyfunart.R
import kotlinx.android.synthetic.main.activity_gallery_list.*

class GalleryListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_list)

        main2_tab.addTab(main2_tab.newTab().setText("내 주변 전시"))
        main2_tab.addTab(main2_tab.newTab().setText("찜한 전시"))

        var tabAdapter = TabAdapter(supportFragmentManager,main2_tab.tabCount)
        main2_viewPager.adapter = tabAdapter

        main2_viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(main2_tab))

        main2_tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                main2_viewPager.currentItem = tab!!.position

            }

        })


    }


}
