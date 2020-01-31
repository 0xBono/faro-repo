package com.o2oom.faroapp

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.content.pm.ActivityInfo
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.control_layout.*
import java.io.IOException
import java.text.SimpleDateFormat


class ControlActivity: AppCompatActivity() {

    companion object {
        var m_myUUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
        var m_bluetoothSocket: BluetoothSocket? = null
        lateinit var m_bluetoothAdapter: BluetoothAdapter
        var m_isConnected: Boolean = false
        lateinit var m_address: String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.control_layout)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        button.setOnClickListener {
            val nextIntent = Intent(this, SelectDeviceActivity::class.java)
            startActivity(nextIntent)
        }

        button8.setOnClickListener {
            val nextIntent = Intent(this, SelectDeviceActivity::class.java)
            startActivity(nextIntent)
        }
        select_device_refresh2.setOnClickListener {
            val nextIntent = Intent(this, MainActivity::class.java)
            startActivity(nextIntent)
        }

        val localTime = Date()
        val timeType = SimpleDateFormat("a hh:mm", Locale.KOREAN)
        val dateType = SimpleDateFormat("MM월 dd일 EE", Locale.KOREAN)

        LocalTime2.text = timeType.format(localTime)
        LocalDate2.text = dateType.format(localTime)

        m_address = intent.getStringExtra(SelectDeviceActivity.EXTRA_ADDRESS)

        ConnectToDevice(this).execute()

        control_led_on.setOnClickListener { sendCommand("A") }
        control_led_off.setOnClickListener { sendCommand("a") }
        control_led_on2.setOnClickListener { sendCommand("B") }
        control_led_off2.setOnClickListener { sendCommand("b") }
        control_led_on3.setOnClickListener { sendCommand("C") }
        control_led_off3.setOnClickListener { sendCommand("c") }
        control_led_on4.setOnClickListener { sendCommand("D") }
        control_led_off4.setOnClickListener { sendCommand("d") }
    }

    private fun sendCommand(input: String) {
        if (m_bluetoothSocket != null) {
            try{
                m_bluetoothSocket!!.outputStream.write(input.toByteArray())
            } catch(e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun disconnect() {
        if (m_bluetoothSocket != null) {
            try {
                m_bluetoothSocket!!.close()
                m_bluetoothSocket = null
                m_isConnected = false
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        finish()
    }

    private class ConnectToDevice(c: Context) : AsyncTask<Void, Void, String>() {
        private var connectSuccess: Boolean = true
        private val context: Context

        init {
            this.context = c
        }


        override fun doInBackground(vararg p0: Void?): String? {
            try {
                if (m_bluetoothSocket == null || !m_isConnected) {
                    m_bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
                    val device: BluetoothDevice = m_bluetoothAdapter.getRemoteDevice(m_address)
                    m_bluetoothSocket = device.createInsecureRfcommSocketToServiceRecord(m_myUUID)
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery()
                    m_bluetoothSocket!!.connect()
                }
            } catch (e: IOException) {
                connectSuccess = false
                e.printStackTrace()
            }
            return null
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (!connectSuccess) {
                Log.i("data", "couldn't connect")
            } else {
                m_isConnected = true
            }
        }
    }
}