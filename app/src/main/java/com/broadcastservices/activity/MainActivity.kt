package com.broadcastservices.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.broadcastservices.R

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var buttonBroadcast: Button
    private lateinit var buttonService: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControls()
    }

    private fun initControls() {
        buttonBroadcast = findViewById(R.id.button_broadcast_receiver)
        buttonService = findViewById(R.id.button_service)

        buttonBroadcast.setOnClickListener(this)
        buttonService.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button_broadcast_receiver -> {
                val intent = Intent(this, ReceiverActivity::class.java)
                startActivity(intent)
            }
            R.id.button_service -> {
                val intent = Intent(this, ServiceExampleActivity::class.java)
                startActivity(intent)
            }
        }
    }
}