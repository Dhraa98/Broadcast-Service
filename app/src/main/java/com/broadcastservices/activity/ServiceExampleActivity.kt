package com.broadcastservices.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.broadcastservices.R
import com.broadcastservices.constants.Constants
import com.broadcastservices.services.ForegroundService


class ServiceExampleActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnStartService: Button
    private lateinit var btnStopService: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_exmple)
        initControls()
    }

    private fun initControls() {
        btnStartService = findViewById(R.id.button_startService)
        btnStopService = findViewById(R.id.button_stopService)

        btnStartService.setOnClickListener(this)
        btnStopService.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button_stopService -> {
                stopService()
            }
            R.id.button_startService -> {
                startService()
            }
        }
    }

    fun startService() {
        val serviceIntent = Intent(this, ForegroundService::class.java)
        serviceIntent.putExtra(Constants.EXTRA_KEY_SERVICE, Constants.EXTRA_KEY_VALUE_SERVICE)
        ContextCompat.startForegroundService(this, serviceIntent)
    }

    fun stopService() {
        val serviceIntent = Intent(this, ForegroundService::class.java)
        stopService(serviceIntent)
    }
}