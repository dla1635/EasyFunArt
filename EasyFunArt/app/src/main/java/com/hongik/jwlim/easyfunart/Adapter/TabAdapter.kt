package com.hongik.jwlim.easyfunart.Adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.hongik.jwlim.easyfunart.Fragment.*

/**
 * Created by JWLIM on 2018-01-04.
 */
class TabAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    var tabCount : Int = 0
    var firtTab : SurroundingFragment? = null
    var secondTab : BookMarkFragment? = null

    constructor(fm : FragmentManager?, tabCount : Int) : this(fm){
        this.tabCount = tabCount
        this.firtTab = SurroundingFragment()
        this.secondTab = BookMarkFragment()

    }

    override fun getItem(position: Int): Fragment? {
        when(position){
            0-> {
                val bundle = Bundle()
                bundle.putString("title", "전시정보")
                firtTab!!.arguments = bundle

                return firtTab
            }
            1-> {
                val bundle = Bundle()
                bundle.putString("title", "갤러리정보")
                secondTab!!.arguments = bundle
                return secondTab
            }

        }

        return null
    }

    override fun getCount(): Int = tabCount
}