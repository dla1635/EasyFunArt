package com.hongik.jwlim.easyfunart.Dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.hongik.jwlim.easyfunart.R
import java.util.*

/**
 * Created by JWLIM on 2017-12-31.
 */
class CustomDialog(context:Context):Dialog(context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.custom_dialog)

    }

}
