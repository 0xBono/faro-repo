package com.o2oom.faro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.ActivityInfo
import com.o2oom.faro.R.layout
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
        setContentView(layout.activity_main)

        //Local Time and Date

        val localTime = Date()
        val timeType = SimpleDateFormat("a hh:mm", Locale.KOREAN)
        val dateType = SimpleDateFormat("MM월 dd일 EE", Locale.KOREAN)

        LocalTime.text = timeType.format(localTime)
        LocalDate.text = dateType.format(localTime)
    }
}