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
import com.hongik.jwlim.easyfunart.Model.SearchData
import com.hongik.jwlim.easyfunart.R
import com.hongik.jwlim.easyfunart.ViewHolder.SearchViewHolder
import kotlinx.android.synthetic.main.home2_docent_dialog.view.*
import kotlinx.android.synthetic.main.home2_heart_dialog.view.*

/**
 * Created by minha on 2018-01-04.
 */
class SearchAdapter (var context : Context, var dataList : ArrayList<SearchData>?) : RecyclerView.Adapter<SearchViewHolder>(){
    private var onItemClick : View.OnClickListener? = null

    fun setOnItemClickListener(l: View.OnClickListener){
        onItemClick = l
    }

    override fun getItemCount(): Int = dataList!!.size

    override fun onBindViewHolder(holder: SearchViewHolder?, position: Int) {
        holder!!.SearchImage.setImageResource(dataList!!.get(position).SearchImage)
        holder!!.SearchTitle.text = dataList!!.get(position).SearchTitle
        holder!!.SearchDate.text = dataList!!.get(position).SearchDate
        holder!!.SearchPlace.text = dataList!!.get(position).SearchPlace
        holder!!.SearchHeart.setBackgroundResource(dataList!!.get(position).SearchHeart)
        holder!!.SearchDocent.setBackgroundResource(dataList!!.get(position).SearchDocent)
        holder!!.SearchScore.text = dataList!!.get(position).SearchScore

        holder!!.SearchStar.setImageResource(R.drawable.main_star_full)

        holder!!.SearchImage.setOnClickListener {
            var builder : AlertDialog.Builder = AlertDialog.Builder(context)
            var inflater : LayoutInflater = LayoutInflater.from(context)
            var view : View = inflater.inflate(R.layout.home2_docent_dialog, null)
            builder.setView(view)
            var dialog : Dialog = builder.create()
            view.dialog_docent_image.setImageResource(dataList!!.get(position).SearchImage)
            view.dialog_docent_title.setText(dataList!!.get(position).SearchTitle)
            view.dialog_docent_place.setText(dataList!!.get(position).SearchPlace)
            dialog.show()

            // dialog 크기변환
            var dm : DisplayMetrics = view.resources.displayMetrics
            var px_width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250.0f, dm) // float형
            var px_height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 356.0f, dm)

            val px_width_int = px_width.toInt() // int형으로 변환
            val px_height_int = px_height.toInt()
            dialog!!.window.setLayout(px_width_int, px_height_int)

            view.dialog_docent_xButton.setOnClickListener {
                dialog.dismiss()
            }
        }

        holder!!.SearchHeart.setOnClickListener {
            var builder : AlertDialog.Builder = AlertDialog.Builder(context)
            var inflater : LayoutInflater = LayoutInflater.from(context)
            var view : View = inflater.inflate(R.layout.home2_heart_dialog, null)
            builder.setView(view)
            var dialog : Dialog = builder.create()
            view.dialog_heart_title.setText(dataList!!.get(position).SearchTitle)
            dialog.show()

            // dialog 크기변환
            var dm : DisplayMetrics = view.resources.displayMetrics
            var px_width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250.0f, dm) // float형
            var px_height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300.0f, dm)

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

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SearchViewHolder {
        val mainView : View = LayoutInflater.from(parent!!.context).inflate(R.layout.search_second_fragment_item, parent, false)
        mainView.setOnClickListener(onItemClick)
        return SearchViewHolder(mainView)
    }

}