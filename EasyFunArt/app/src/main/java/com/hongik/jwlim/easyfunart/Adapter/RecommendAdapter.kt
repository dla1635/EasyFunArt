package com.hongik.jwlim.easyfunart.Adapter

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.hongik.jwlim.easyfunart.Model.RecommendData
import com.hongik.jwlim.easyfunart.R
import com.hongik.jwlim.easyfunart.ViewHolder.RecommendViewHolder
import kotlinx.android.synthetic.main.home2_docent_dialog.view.*
import kotlinx.android.synthetic.main.home2_heart_dialog.view.*

/**
 * Created by minha on 2018-01-04.
 */
class RecommendAdapter (var context : Context, var dataList : ArrayList<RecommendData>?) : RecyclerView.Adapter<RecommendViewHolder>() {
    private var onItemClick : View.OnClickListener? = null

    fun setOnItemClickListener(l: View.OnClickListener){
        onItemClick = l
    }

    override fun onBindViewHolder(holder: RecommendViewHolder?, position: Int) {
        holder!!.RecomendImage.setImageResource(dataList!!.get(position).RecomendImage)
        holder!!.RecomendTitle.text = dataList!!.get(position).RecomendTitle
        holder!!.RecomendDate.text = dataList!!.get(position).RecomendDate
        holder!!.RecomendPlace.text = dataList!!.get(position).RecomendPlace
        holder!!.RecomendDocent.setBackgroundResource(dataList!!.get(position).RecomendDocent)
        holder!!.RecomendHeart.setBackgroundResource(dataList!!.get(position).RecomendHeart)
        holder!!.RecomendScore.text = dataList!!.get(position).RecomendScore
        holder!!.RecomendStar.setImageResource(R.drawable.main_star_full)

        holder!!.RecomendImage.setOnClickListener {
            var builder : AlertDialog.Builder = AlertDialog.Builder(context)
            var inflater : LayoutInflater = LayoutInflater.from(context)
            var view : View = inflater.inflate(R.layout.home2_docent_dialog, null)
            builder.setView(view)
            var dialog : Dialog = builder.create()
            view.dialog_docent_image.setImageResource(dataList!!.get(position).RecomendImage)
            view.dialog_docent_title.setText(dataList!!.get(position).RecomendTitle)
            view.dialog_docent_place.setText(dataList!!.get(position).RecomendPlace)
            dialog.show()

            // dialog 크기변환
            var dm : DisplayMetrics = view.resources.displayMetrics
            var px_width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250.0f, dm) // float형
            var px_height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300.0f, dm)

            val px_width_int = px_width.toInt() // int형으로 변환
            val px_height_int = px_height.toInt()
            dialog!!.window.setLayout(px_width_int, px_height_int)

            view.dialog_docent_xButton.setOnClickListener {
                dialog.dismiss()
            }
        }

        holder!!.RecomendHeart.setOnClickListener {
            var builder : AlertDialog.Builder = AlertDialog.Builder(context)
            var inflater : LayoutInflater = LayoutInflater.from(context)
            var view : View = inflater.inflate(R.layout.home2_heart_dialog, null)
            builder.setView(view)
            var dialog : Dialog = builder.create()
            view.dialog_heart_title.setText(dataList!!.get(position).RecomendTitle)
            dialog.show()

            // dialog 크기변환
            var dm : DisplayMetrics = view.resources.displayMetrics
            var px_width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250.0f, dm) // float형
            var px_height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 356.0f, dm)

            val px_width_int = px_width.toInt() // int형으로 변환
            val px_height_int = px_height.toInt()
            dialog!!.window.setLayout(px_width_int, px_height_int)

            dialog!!.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            //getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            val animation = AnimationUtils.loadAnimation(context, R.anim.scale) // 안될 땐 clean project
            view.startAnimation(animation)

//            val animation2 = AnimationUtils.loadAnimation(context, R.anim.scale2)
//            view.startAnimation(animation2)

            var handler = Handler()
            handler.postDelayed({
                dialog.dismiss()
            }, 1000)
        }
    }

    override fun getItemCount(): Int = dataList!!.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecommendViewHolder {
        val mainView : View = LayoutInflater.from(parent!!.context).inflate(R.layout.recomend_recycler_item, parent, false)
        mainView.setOnClickListener(onItemClick)
        return RecommendViewHolder(mainView)
    }
}