package com.hongik.jwlim.easyfunart.Activity

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import com.hongik.jwlim.easyfunart.R
import kotlinx.android.synthetic.main.activity_write_review.*

class WriteReview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_review)

        back_button2!!.setOnClickListener{
            val intent = Intent(applicationContext, DisplayInfoActivity::class.java)
            startActivity(intent)
        }

        write!!.setOnClickListener {
            var builder : AlertDialog.Builder = AlertDialog.Builder(this)

            var inflater : LayoutInflater = LayoutInflater.from(this)
            var view : View = inflater.inflate(R.layout.write, null)
            builder.setView(view)
            var dialog : Dialog = builder.create()
         //   view.dialog_heart_title.setText(heart.text.toString())

            dialog.show()

            // dialog 크기변환
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
    }
}
