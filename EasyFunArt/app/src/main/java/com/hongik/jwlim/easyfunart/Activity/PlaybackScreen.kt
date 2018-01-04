package com.hongik.jwlim.easyfunart.Activity

import android.graphics.Color
import android.graphics.Typeface
import android.media.MediaPlayer
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.View.GONE
import android.view.WindowManager
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hongik.jwlim.easyfunart.ApplicationController
import com.hongik.jwlim.easyfunart.Dialog.CustomDialog
import com.hongik.jwlim.easyfunart.GET.RecordResponse
import com.hongik.jwlim.easyfunart.NetworkService
import com.hongik.jwlim.easyfunart.R
import com.hongik.jwlim.easyfunart.R.drawable.docentplaying_stop
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Url
import java.security.AccessController.getContext



class PlaybackScreen : AppCompatActivity() {


    private var networkService : NetworkService? = null
    private var mp : MediaPlayer? = null
    var pos : Int? = null
    var sb : SeekBar? = null
    var isPlaying : Boolean = false
    var start_pause : Int = 0
    var i : Int? = 0
    var j : Int? = 0
    var quotient : Int? = 0
    var remainder : Int? = 0




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

//        networkService = ApplicationController.instance!!.networkService
//        bStart = findViewById(R.id.button1) as Button

        sb = findViewById(R.id.seekBar1) as SeekBar
        var music_url : String = "asd"
        var uri :Uri = Uri.parse(music_url)

        // MediaPlayer 객체 초기화 , 재생
        mp = MediaPlayer.create(
                getApplicationContext(),R.raw.palette // 현재 화면의 제어권자
                ) // 음악파일

        mp!!.setLooping(false) // true:무한반복
        mp!!.start() // 노래 재생 시작
        val a = mp!!.getDuration() // 노래의 재생시간(miliSecond)
        sb!!.setMax(a)// 씨크바의 최대 범위를 노래의 재생시간으로 설정
        MyThread().start() // 씨크바 그려줄 쓰레드 시작
        isPlaying = true // 씨크바 쓰레드 반복 하도록


//        quotient = mp!!.duration/60000
//        remainder = mp!!.duration%60000
//
//        quotient

//        Log.d("몫",quotient.toString())
//        Log.d("나머지",remainder.toString())

        sb!!.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener {

            override fun onStopTrackingTouch(seekBar:SeekBar){
                isPlaying = true
                val ttt = seekBar.getProgress()
                mp!!.seekTo(ttt)
                mp!!.start()
                MyThread().start()
                playbackScreen_playPause_btn.setBackgroundResource(R.drawable.docentplaying_stop)

            }

            override fun onStartTrackingTouch(seekBar:SeekBar){
                isPlaying = false
                mp!!.pause()
            }

            override fun onProgressChanged(seekBar:SeekBar, progress:Int, fromUser:Boolean) {
                if (seekBar.getMax() === progress){
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
                    playbackScreen_playPause_btn.setBackgroundResource(R.drawable.btn_docent_play)

                }
                else if(start_pause.equals(1)){
                    // 멈춘 지점부터 재시작
                    pos = mp!!.getCurrentPosition()
                    mp!!.seekTo(pos!!) // 일시정지 시점으로 이동
                    mp!!.start() // 시작
                    isPlaying = true // 재생하도록 flag 변경
                    MyThread().start() // 쓰레드 시작
                    start_pause = 0
                    playbackScreen_playPause_btn.setBackgroundResource(R.drawable.docentplaying_stop)
                }
            }
        })

        playbackScreen_cancel_btn!!.setOnClickListener {
            pause()
            Toast.makeText(getApplication(),"getListdata2 error1",Toast.LENGTH_SHORT).show();

        }

        playbackScreen_next_btn.setOnClickListener{//이전 버튼 클릭시.
//            GetNextRecord()
        }

        playbackScreen_prev_btn.setOnClickListener{//다음 버튼 클릭시.
//            GetPrevRecord()
        }

        playbackScreen_script_button.setOnClickListener{
            ScriptCreation()
            Toast.makeText(getApplication(),"getListdata2 error1",Toast.LENGTH_SHORT).show();
        }
        playbackScreen_map_button.setOnClickListener{
            MapCreation()
        }

//        val loginParams: WindowManager.LayoutParams
//        dialog = CustomDialog(this@PlaybackScreen)
//
//        loginParams = dialog!!.getWindow().getAttributes()
//        // Dialog 사이즈 조절 하기
//
//        loginParams.width = WindowManager.LayoutParams.MATCH_PARENT
//        loginParams.height = WindowManager.LayoutParams.MATCH_PARENT
//        dialog!!.getWindow().setAttributes(loginParams)
//
//        dialog!!.show()


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

    fun ScriptCreation(){

        if(i!!.equals(0)){

//            var param1 = playbackScreen_layout_view!!.layoutParams
//            param1.height = 450
//            playbackScreen_layout_view!!.

            //if,스크립트를 키는데 지도가 미리켜져있을경우 지도를 없애기 위해.
            playbackScreen_map_img!!.setAlpha(0)//투명도 100%
            playbackScreen_scroll_view!!.setBackgroundColor(Color.parseColor("#00ffffff"))
            j = 0
            //////////////////////////////////////////////////////////////////////////////////////////
            playbackScreen_script_layout!!.setHorizontalGravity(Gravity.CENTER_HORIZONTAL)
            playbackScreen_scroll_view!!.setBackgroundColor(Color.parseColor("#99000000"))//배경화면 어둡게.


            //갤러리 이름
            playbackScreen_scriptGallery_text!!.setTextColor(Color.parseColor("#ffae00"))
            playbackScreen_scriptGallery_text!!.setTextSize(20f)
            playbackScreen_scriptGallery_text!!.setText("\n꽃갈피\n")
            playbackScreen_scriptGallery_text!!.setTypeface(Typeface.DEFAULT_BOLD)

            //작품 이름
            playbackScreen_title_text!!.setTextColor(Color.parseColor("#ffffff"))
            playbackScreen_title_text!!.setTextSize(15f)
            playbackScreen_title_text!!.setText("아이유-밤편지\n")


            //작품 내용
            playbackScreen_content_text!!.setTextColor(Color.parseColor("#ffffff"))
            playbackScreen_content_text!!.setTextSize(15f)

            playbackScreen_content_text!!.setText("이 밤 그날의 반딧불을 \n" +
                    "당신의 창 가까이 보낼게요\n" +
                    "음 사랑한다는 말이에요\n" +
                    "\n" +
                    "나 우리의 첫 입맞춤을 떠올려\n" +
                    "그럼 언제든 눈을 감고 \n" +
                    "음 가장 먼 곳으로 가요\n" +
                    "\n" +
                    "난 파도가 머물던 \n" +
                    "모래 위에 적힌 글씨처럼\n" +
                    "그대가 멀리 \n" +
                    "사라져 버릴 것 같아 \n" +
                    "늘 그리워 그리워\n" +
                    "\n" +
                    "여기 내 마음속에 \n" +
                    "모든 말을 \n" +
                    "다 꺼내어 줄 순 없지만\n" +
                    "사랑한다는 말이에요\n" +
                    "\n" +
                    "어떻게 나에게 \n" +
                    "그대란 행운이 온 걸까\n" +
                    "지금 우리 함께 있다면 \n" +
                    "아 얼마나 좋을까요\n" +
                    "\n" +
                    "난 파도가 머물던 \n" +
                    "모래 위에 적힌 글씨처럼\n" +
                    "그대가 멀리 \n" +
                    "사라져 버릴 것 같아\n" +
                    "또 그리워 더 그리워\n" +
                    "\n" +
                    "나의 일기장 안에\n" +
                    "모든 말을 \n" +
                    "다 꺼내어 줄 순 없지만\n" +
                    "사랑한다는 말\n" +
                    "\n" +
                    "이 밤 그날의 반딧불을 \n" +
                    "당신의\n" +
                    "창 가까이 띄울게요\n" +
                    "음 좋은 꿈 이길 바라요")

            i = 1
            Log.d("로그1",i.toString())

        }else if(i!!.equals(1)){

            playbackScreen_galleryname_text!!.setTextColor(Color.parseColor("#000000"))//배경 갤러리 이름 나타내기.
            playbackScreen_workname_text!!.setTextColor(Color.parseColor("#000000"))//배경 작품 이름 나타내기


            //텍스트 컬러 투명하게...
            playbackScreen_scriptGallery_text!!.setTextColor(Color.parseColor("#00ffffff"))
            playbackScreen_title_text!!.setTextColor(Color.parseColor("#00ffffff"))
            playbackScreen_content_text!!.setTextColor(Color.parseColor("#00ffffff"))
            playbackScreen_scroll_view!!.setBackgroundColor(Color.parseColor("#00ffffff"))
            i = 0


            Log.d("로그2",i.toString())

        }
    }


    fun MapCreation(){

        if(j!!.equals(0)){

            //if,맵을 키는데 스크립트가 켜져있는 경우, 스크립트를 없앤다.
            playbackScreen_galleryname_text!!.setTextColor(Color.parseColor("#000000"))
            playbackScreen_galleryname_text!!.setTypeface(Typeface.DEFAULT)

            playbackScreen_scriptGallery_text!!.setTextColor(Color.parseColor("#00ffffff"))
            playbackScreen_title_text!!.setTextColor(Color.parseColor("#00ffffff"))
            playbackScreen_content_text!!.setTextColor(Color.parseColor("#00ffffff"))
            playbackScreen_scroll_view!!.setBackgroundColor(Color.parseColor("#00ffffff"))
            i = 0
            /////////////////////////////////////////////////////////////////////////////////////////

            playbackScreen_map_img!!.setImageResource(R.drawable.pic1)
            playbackScreen_map_img!!.setAlpha(255)//투명도 0%
            playbackScreen_script_layout!!.setHorizontalGravity(Gravity.CENTER_HORIZONTAL)
            playbackScreen_scroll_view!!.setBackgroundColor(Color.parseColor("#77000000"))

            j = 1
            Log.d("로그1",j.toString())

        }else if(j!!.equals(1)){

            playbackScreen_map_img!!.setAlpha(0)//투명도 100%
            playbackScreen_scroll_view!!.setBackgroundColor(Color.parseColor("#00ffffff"))
            j = 0

            Log.d("로그2",j.toString())

        }

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

}
