package com.hongik.jwlim.easyfunart.Activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.hongik.jwlim.easyfunart.ApplicationController
import com.hongik.jwlim.easyfunart.Dialog.CustomDialog
import com.hongik.jwlim.easyfunart.GET.RecordResponse
import com.hongik.jwlim.easyfunart.NetworkService
import com.hongik.jwlim.easyfunart.R
import com.tsengvn.typekit.TypekitContextWrapper
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaybackScreen : AppCompatActivity() {

    private var networkService : NetworkService? = null
    private var mp : MediaPlayer? = null
    var pos : Int? = null
    var bStart :  Button? = null
    var bPause : Button? = null
    var bRestart : Button? = null
    var bStop : Button? = null
    var sb : SeekBar? = null
    var isPlaying : Boolean = false
    var start_pause : Int = 0
    var dialog : CustomDialog? = null





    internal inner class MyThread : Thread() {
        override fun run() { // 쓰레드가 시작되면 콜백되는 메서드
            // 씨크바 막대기 조금씩 움직이기 (노래 끝날 때까지 반복)
            while (isPlaying) {
                sb!!.setProgress(mp!!.getCurrentPosition())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//        Typekit.getInstance()
//                .addNormal(Typekit.createFromAsset(this, "fonts/NanumSquareR.ttf"))
//                .addBold(Typekit.createFromAsset(this, "fonts/NanumSquareB.ttf"))
//
//        networkService = ApplicationController.instance!!.networkService
//        bStart = findViewById(R.id.button1) as Button


        sb = findViewById(R.id.seekBar1) as SeekBar

        // MediaPlayer 객체 초기화 , 재생
        mp = MediaPlayer.create(
                getApplicationContext(), // 현재 화면의 제어권자
                R.raw.thank_you) // 음악파일
        mp!!.setLooping(false) // true:무한반복
        mp!!.start() // 노래 재생 시작
        val a = mp!!.getDuration() // 노래의 재생시간(miliSecond)
        sb!!.setMax(a)// 씨크바의 최대 범위를 노래의 재생시간으로 설정
        MyThread().start() // 씨크바 그려줄 쓰레드 시작
        isPlaying = true // 씨크바 쓰레드 반복 하도록



        sb!!.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener {

            override fun onStopTrackingTouch(seekBar:SeekBar) {
                isPlaying = true
                val ttt = seekBar.getProgress()
                mp!!.seekTo(ttt)
                mp!!.start()
                MyThread().start()
            }
            override fun onStartTrackingTouch(seekBar:SeekBar) {
                isPlaying = false
                mp!!.pause()
            }
            override fun onProgressChanged(seekBar:SeekBar, progress:Int, fromUser:Boolean) {
                if (seekBar.getMax() === progress)
                {
                    bStart!!.setVisibility(View.VISIBLE)
                    bStop!!.setVisibility(View.INVISIBLE)
                    bPause!!.setVisibility(View.INVISIBLE)
                    bRestart!!.setVisibility(View.INVISIBLE)
                    isPlaying = false
                    mp!!.stop()
                }
            }
        })



        playbackScreen_playPause_btn!!.setOnClickListener(object:View.OnClickListener {

            override fun onClick(v:View) {

                if(start_pause.equals(0)) {
                    pos = mp!!.getCurrentPosition()
                    mp!!.pause() // 일시중지
                    isPlaying = false // 쓰레드 정지
                    start_pause = 1
                    Log.d("pause",start_pause.toString())

                }
                else if(start_pause.equals(1)){
                    // 멈춘 지점부터 재시작
                    mp!!.seekTo(pos!!) // 일시정지 시점으로 이동
                    mp!!.start() // 시작
                    isPlaying = true // 재생하도록 flag 변경
                    MyThread().start() // 쓰레드 시작
                    start_pause = 0

                }
            }
        })

//        bStop!!.setOnClickListener(object:View.OnClickListener {
//            override fun onClick(v:View) {
//                // 음악 종료
//                isPlaying = false // 쓰레드 종료
//                mp!!.stop() // 멈춤
//                mp!!.release() // 자원 해제
//                bStart!!.setVisibility(View.VISIBLE)
//                bPause!!.setVisibility(View.INVISIBLE)
//                bRestart!!.setVisibility(View.INVISIBLE)
//                bStop!!.setVisibility(View.INVISIBLE)
//                sb!!.setProgress(0) // 씨크바 초기화
//            }
//        })

        playbackScreen_next_btn.setOnClickListener{//이전 버튼 클릭시.
//            GetNextRecord()
        }
        wh_btn.setOnClickListener{//이전 버튼 클릭시.
            val intent = Intent(applicationContext, DisplayInfoActivity::class.java)
            startActivity(intent)
        }

        playbackScreen_prev_btn.setOnClickListener{//다음 버튼 클릭시.
//            GetPrevRecord()
        }

        playbackScreen_script_button.setOnClickListener{

            var script_layout : LinearLayout

            script_layout = LinearLayout(this)
            script_layout.setLayoutParams(LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT))
            script_layout.setOrientation(LinearLayout.VERTICAL)
            script_layout.setHorizontalGravity(Gravity.CENTER_HORIZONTAL)
            script_layout.setBackgroundColor(Color.parseColor("#80000000"))
            playbackScreen_script_layout.addView(script_layout)

            var work_name : TextView? = null
            var work_content : TextView? = null



            work_name = TextView(this)
            val param1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT)

            work_name.setLayoutParams(param1)
            work_name.setTextColor(Color.parseColor("#000000"))
            work_name.setTextSize(15f)
            work_name.setGravity(Gravity.CENTER)
            work_name.setText("김동률-감사")
            script_layout.addView(work_name)


            work_content = TextView(this)
            val param2 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT)

            work_content.setLayoutParams(param2)
            work_content.setTextColor(Color.parseColor("#000000"))
            work_content.setTextSize(15f)
            work_content.setGravity(Gravity.CENTER)
            work_content.setText("ASDSAD999")
            script_layout.addView(work_content)

        }

//        val loginParams: WindowManager.LayoutParams
        dialog = CustomDialog(this@PlaybackScreen)

//        loginParams = dialog!!.getWindow().getAttributes()
//
//        // Dialog 사이즈 조절 하기
//        loginParams.width = WindowManager.LayoutParams.MATCH_PARENT
//        loginParams.height = WindowManager.LayoutParams.MATCH_PARENT
//        dialog!!.getWindow().setAttributes(loginParams)

        dialog!!.show()

    }


    fun GetNextRecord(){

        val NextRecordResponse = networkService!!.getNextRecord()

        NextRecordResponse.enqueue(object : Callback<RecordResponse>{

            override fun onResponse(call: Call<RecordResponse>?, response: Response<RecordResponse>?) {
                if(response!!.isSuccessful){
                    if(response!!.body().equals("success")){

                        playbackScreen_galleryname_text.setText(response.body().gallery_name)//전시회 이름
                        playbackScreen_workname_text.setText(response.body().work_name)//작품 이름

                        Glide.with(this@PlaybackScreen)//작품 이름
                                .load(response.body().work_img)
                                .into(playbackScreen_work_img)

                        pause()//기존 음악 정지.
                        play(response.body().work_record)//새로운 음악 실행.

                    }else{
                        ApplicationController.instance!!.makeToast("다음곡 받기 실패")
                    }

                }else{
                    ApplicationController.instance!!.makeToast("다음곡 받기 실패")
                }

            }
            override fun onFailure(call: Call<RecordResponse>?, t: Throwable?) {
                ApplicationController.instance!!.makeToast("통신 실패")

            }

        })
    }

    fun GetPrevRecord(){

        val PrevRecordResponse = networkService!!.getPrevRecord()

        PrevRecordResponse.enqueue(object : Callback<RecordResponse>{

            override fun onResponse(call: Call<RecordResponse>?, response: Response<RecordResponse>?) {
                if(response!!.isSuccessful){
                    if(response!!.body().equals("success")){

                        playbackScreen_galleryname_text.setText(response.body().gallery_name)//전시회 이름
                        playbackScreen_workname_text.setText(response.body().work_name)//작품 이름

                        Glide.with(this@PlaybackScreen)//작품 이름
                                .load(response.body().work_img)
                                .into(playbackScreen_work_img)

                        pause()//기존 음악 정지.
                        play(response.body().work_record)//새로운 음악 실행.

                    }else{
                        ApplicationController.instance!!.makeToast("다음곡 받기 실패")
                    }

                }else{
                    ApplicationController.instance!!.makeToast("다음곡 받기 실패")
                }

            }
            override fun onFailure(call: Call<RecordResponse>?, t: Throwable?) {
                ApplicationController.instance!!.makeToast("통신 실패")

            }

        })
    }

    fun pause(){
        isPlaying = false // 쓰레드 종료
        mp!!.stop() // 멈춤
        mp!!.release() // 자원 해제
        sb!!.setProgress(0) // 씨크바 초기화
    }

    fun play(work_record : Uri){
        mp = MediaPlayer.create(
                getApplicationContext(), // 현재 화면의 제어권자
                work_record) // 음악파일
        mp!!.setLooping(false) // true:무한반복
        mp!!.start() // 노래 재생 시작
        val a = mp!!.getDuration() // 노래의 재생시간(miliSecond)
        sb!!.setMax(a)// 씨크바의 최대 범위를 노래의 재생시간으로 설정
        MyThread().start() // 씨크바 그려줄 쓰레드 시작
        isPlaying = true // 씨크바 쓰레드 반복 하도록
    }

    override fun onPause() {
        super.onPause()
        isPlaying = false // 쓰레드 정지
        if (mp != null)
        {
            mp!!.release() // 자원해제
        }
    }
    //폰트 변경을 위한 함수
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase))
    }
}
