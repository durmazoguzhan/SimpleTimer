package com.oguzhandurmaz.kotlinrunnables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number = 0
    private var runnable: Runnable=Runnable{}
    var handler: Handler=Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(view: View) {
        //Runnable and Handler
        startButton.isEnabled = false
        resetButton.isEnabled=false
        stopButton.isEnabled=true

        runnable=object:Runnable{
            override fun run() {
                number++
                textView.text="Time : $number"
                handler.postDelayed(this,1000)
            }
        }
        handler.post(runnable)
    }

    fun stop(view: View) {
        handler.removeCallbacks(runnable)
        startButton.text="Resume"
        startButton.isEnabled = true
        resetButton.isEnabled=true
        stopButton.isEnabled=false
    }

    fun reset(view:View){
        number=0
        textView.text="Time : $number"
        startButton.text="Start"
    }
}