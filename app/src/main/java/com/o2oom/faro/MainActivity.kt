package com.o2oom.faro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.ActivityInfo
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.WindowManager
import android.widget.TextView
import kotlin.time.ClockMark

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR

        setContentView(R.layout.activity_main)
    }
}