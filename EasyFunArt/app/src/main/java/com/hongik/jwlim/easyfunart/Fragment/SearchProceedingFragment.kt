package com.hongik.jwlim.easyfunart.Activity

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.hongik.jwlim.easyfunart.Adapter.SearchAdapter
import com.hongik.jwlim.easyfunart.Model.SearchData
import com.hongik.jwlim.easyfunart.R

/**
 * Created by minha on 2018-01-04.
 */
class SearchProceedingFragment : Fragment(), View.OnClickListener {
    override fun onClick(p0: View?) {
//        val idx : Int = pokemonList!!.getChildAdapterPosition(p0)
//        val name : String? = pokemonDatas!!.get(idx).pokemonType
//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }

    private var searchList : RecyclerView? = null
    private var searchDatas : ArrayList<SearchData>? = null
    private var adapter : SearchAdapter? = null
    private var preparingBtn : Button? = null

    private var onClicked : View.OnClickListener? = null

    fun CustomOnClickListener(I : View.OnClickListener) {
        onClicked = I
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.search_second_fragment, container, false)

        searchList = v.findViewById(R.id.search_recyclerView) as RecyclerView
        searchList!!.layoutManager = LinearLayoutManager(context)

        searchDatas = ArrayList<SearchData>()
        searchDatas!!.add(SearchData(R.drawable.poster2, "제목", "시간", "장소", R.drawable.main_heart_off, R.drawable.main_heart_on, "3.3"))

        adapter = SearchAdapter(context, searchDatas)
        adapter!!.setOnItemClickListener(this)
        searchList!!.adapter = adapter


        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(ContentValues.TAG, "onCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.v(ContentValues.TAG, "onResume")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.v(ContentValues.TAG, "onAttach")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(ContentValues.TAG, "onDestroy")
    }

    override fun onPause() {
        super.onPause()
//        EventBus.getInstance().unregister(this)
        Log.v(ContentValues.TAG, "onPause")
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v(ContentValues.TAG, "onViewCreated")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v(ContentValues.TAG, "onDetach")
    }
    //Attach->Create->CreateView->ViewCreated->Resume
}