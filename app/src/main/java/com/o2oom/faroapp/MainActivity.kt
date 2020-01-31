package com.o2oom.faroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.ActivityInfo
import com.o2oom.faroapp.R.layout
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        setContentView(layout.activity_main)

        //Local Time and Date

        val localTime = Date()
        val timeType = SimpleDateFormat("a hh:mm", Locale.KOREAN)
        val dateType = SimpleDateFormat("MM월 dd일 EE", Locale.KOREAN)

        LocalTime.text = timeType.format(localTime)
        LocalDate.text = dateType.format(localTime)

        //Bluetooth Enabled

        button34.setOnClickListener {
            val nextIntent = Intent(this, SelectDeviceActivity::class.java)
            startActivity(nextIntent)
        }

        button7.setOnClickListener {
            val nextIntent2 = Intent(this, SelectDeviceActivity::class.java)
            startActivity(nextIntent2)
        }

        button5.setOnClickListener {
            val nextIntent3 = Intent(this, DrivingActivity::class.java)
            startActivity(nextIntent3)
        }

        button6.setOnClickListener {
            val nextIntent2 = Intent(this, DeviceActivity::class.java)
            startActivity(nextIntent2)
        }
    }
}