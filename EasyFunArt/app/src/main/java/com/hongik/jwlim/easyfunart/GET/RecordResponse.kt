package com.hongik.jwlim.easyfunart.GET

import android.net.Uri
import java.net.URI
import java.net.URL

/**
 * Created by JWLIM on 2017-12-31.
 */
data class RecordResponse(

        var gallery_name : String,
        var gallery_img : String,
        var work_name : String,
        var work_img : String,
        var work_script: String,
        var work_record : Uri

)