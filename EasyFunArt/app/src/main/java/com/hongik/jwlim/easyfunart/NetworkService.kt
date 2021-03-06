package com.hongik.jwlim.easyfunart


import com.hongik.jwlim.easyfunart.GET.RecordResponse
import com.hongik.jwlim.easyfunart.Response.TrackListResponse
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by JWLIM on 2017-12-31.
 */
interface NetworkService {

    @GET("")
    fun getNextRecord(): Call<RecordResponse>

    @GET("")
    fun getPrevRecord(): Call<RecordResponse>

    @GET("")
    fun getTrackList():Call<TrackListResponse>

}