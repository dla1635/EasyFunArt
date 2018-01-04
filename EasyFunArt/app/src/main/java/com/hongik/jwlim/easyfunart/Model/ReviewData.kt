package com.hongik.jwlim.easyfunart.Model

/**
 * Created by JWLIM on 2018-01-04.
 */
data class ReviewData (
        var reviewImage : Int,
        var reviewName : String,
        var reviewContent : String,
        var reviewStar : Int,
        var reviewDate : String,
        var beforeDate : String,
        var reviewTitle : String
)