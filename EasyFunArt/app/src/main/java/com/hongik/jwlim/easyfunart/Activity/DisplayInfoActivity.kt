package com.hongik.jwlim.easyfunart.Activity

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import com.hongik.jwlim.easyfunart.Fragment.DisplayFragment
import com.hongik.jwlim.easyfunart.Fragment.GalleryFragment
import com.hongik.jwlim.easyfunart.Fragment.ReviewFragment

import com.hongik.jwlim.easyfunart.R
import kotlinx.android.synthetic.main.activity_display_info.*
import kotlinx.android.synthetic.main.activity_display_info.view.*
import kotlinx.android.synthetic.main.home2_heart_dialog.view.*

class DisplayInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_info)
        var bundle = Bundle()
        AddFragment(DisplayFragment(), bundle, "first")

        main_tab.addTab(main_tab.newTab().setText("전시정보"))
        main_tab.addTab(main_tab.newTab().setText("갤러리정보"))
        main_tab.addTab(main_tab.newTab().setText("갤러리정보"))


        back_button!!.setOnClickListener{//이전 버튼 클릭시.
            val intent = Intent(applicationContext, PlaybackScreen::class.java)
            startActivity(intent)
        }
        share_button!!.setOnClickListener{
            val msg = Intent(Intent.ACTION_SEND)

            msg.addCategory(Intent.CATEGORY_DEFAULT)

            msg.putExtra(Intent.EXTRA_SUBJECT, "주제")

            msg.putExtra(Intent.EXTRA_TEXT, "내용")

            msg.putExtra(Intent.EXTRA_TITLE, "제목")

            msg.type = "text/plain"

            startActivity(Intent.createChooser(msg, "공유"))
        }

        heart!!.setOnClickListener {
            var builder : AlertDialog.Builder = AlertDialog.Builder(this)

            var inflater : LayoutInflater = LayoutInflater.from(this)
            var view : View = inflater.inflate(R.layout.home2_heart_dialog, null)
            builder.setView(view)
            var dialog : Dialog = builder.create()
            view.dialog_heart_title.setText(heart.text.toString())

            dialog.show()

            // dialog 크기변환
            var dm : DisplayMetrics = view.resources.displayMetrics
            var px_width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250.0f, dm) // float형
            var px_height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 184.0f, dm)

            val px_width_int = px_width.toInt() // int형으로 변환
            val px_height_int = px_height.toInt()
            dialog!!.window.setLayout(px_width_int, px_height_int)

            dialog!!.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            //getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            val animation = AnimationUtils.loadAnimation(this, R.anim.scale) // 안될 땐 clean project
            view.startAnimation(animation)

//            val animation2 = AnimationUtils.loadAnimation(context, R.anim.scale2)
//            view.startAnimation(animation2)

            var handler = Handler()
            handler.postDelayed({
                dialog.dismiss()
            }, 1000)
        }
        star!!.setOnClickListener {
            var builder : AlertDialog.Builder = AlertDialog.Builder(this)

            var inflater : LayoutInflater = LayoutInflater.from(this)
            var view : View = inflater.inflate(R.layout.score, null)
            builder.setView(view)
            var dialog : Dialog = builder.create()
            //  view.dialog_evaluation_title.setText(dialog_evaluation_title.text.toString())

            dialog.show()


            var dm : DisplayMetrics = view.resources.displayMetrics
            var px_width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250.0f, dm) // float형
            var px_height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 220.0f, dm)

            val px_width_int = px_width.toInt() // int형으로 변환
            val px_height_int = px_height.toInt()
            dialog!!.window.setLayout(px_width_int, px_height_int)

            dialog!!.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            //getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            val animation = AnimationUtils.loadAnimation(this, R.anim.scale) // 안될 땐 clean project
            view.startAnimation(animation)

//            val animation2 = AnimationUtils.loadAnimation(context, R.anim.scale2)
//            view.startAnimation(animation2)

        }






        main_tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab!!.position){
                    0 ->{
                        var bundle = Bundle()
                        ReplaceFragment(DisplayFragment(), bundle, "first")
                    }
                    1->{
                        var bundle = Bundle()
                        //  AddFragment(GalleryFragment(), bundle, "second")

                        ReplaceFragment(GalleryFragment(), bundle, "second")}
                    2->{
                        var bundle = Bundle()
                        //  AddFragment(ReviewFragment(), bundle, "third")
                        ReplaceFragment(ReviewFragment(), bundle, "third")
                    }
                }
            }
        })

    }



    fun AddFragment(fragment: Fragment, bundle: Bundle, tag: String) {            //오버라이딩하여 최초에 추가될 프레그먼트 생성함수
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.add(R.id.main_frame, fragment, tag)
        //transaction.addToBackStack(null);
        transaction.commit()
    }

    fun TagFragment(tag: String) {
        Log.v("home", tag)
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        val fragment = supportFragmentManager.findFragmentByTag(tag)
        if(fragment!=null) {
            transaction.replace(R.id.main_frame, fragment)
            transaction.commit()
        }
    }
    fun ReplaceFragment(fragment: Fragment, bundle: Bundle, tag: String) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.replace(R.id.main_frame, fragment, tag)
        //transaction.addToBackStack(null)
        transaction.commit()

    }
}
