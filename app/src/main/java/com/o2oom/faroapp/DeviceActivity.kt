package com.o2oom.faroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.ActivityInfo
import com.o2oom.faroapp.R.layout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.driving_activity.*
import kotlinx.android.synthetic.main.driving_activity.LocalDate
import kotlinx.android.synthetic.main.driving_activity.LocalTime
import java.text.SimpleDateFormat
import java.util.*


class DeviceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        setContentView(layout.device_activity)

        //Local Time and Date

        val localTime = Date()
        val timeType = SimpleDateFormat("a hh:mm", Locale.KOREAN)
        val dateType = SimpleDateFormat("MM월 dd일 EE", Locale.KOREAN)

        LocalTime.text = timeType.format(localTime)
        LocalDate.text = dateType.format(localTime)

        //Bluetooth Enabled

        button2.setOnClickListener {
            val nextIntent = Intent(this, SelectDeviceActivity::class.java)
            startActivity(nextIntent)
        }


        select_device_refresh3.setOnClickListener {
            val nextIntent = Intent(this, MainActivity::class.java)
            startActivity(nextIntent)
        }


    }
}