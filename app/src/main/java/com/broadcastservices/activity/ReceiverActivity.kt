package com.broadcastservices.activity

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.broadcastservices.R
import com.broadcastservices.constants.Constants
import com.broadcastservices.receiver.AlarmReceiver
import java.util.*


class ReceiverActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var buttonStartService: Button
    private lateinit var buttonStoptService: Button

    private lateinit var pendingIntent: PendingIntent
    private lateinit var alarmManager: AlarmManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)
        initControls()
    }

    private fun initControls() {

        buttonStartService = findViewById(R.id.button_startAlarm)
        buttonStoptService = findViewById(R.id.button_stopAlarm)

        buttonStartService.setOnClickListener(this)
        buttonStoptService.setOnClickListener(this)


        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(this, AlarmReceiver::class.java)
        intent.action = Constants.INTENT_ACTION
        intent.putExtra(Constants.EXTRA_KEY, Constants.EXTRA_KEY_VALUE)
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)


    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button_startAlarm -> {
                start()
            }
            R.id.button_stopAlarm -> {
                cancel()
            }

        }
    }


    private fun cancel() {

        alarmManager.cancel(pendingIntent)
        Toast.makeText(this, R.string.msg_alarm_cacel, Toast.LENGTH_SHORT).show()
    }

    private fun start() {


        val interval = Constants.INTERVAL

        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis(),
            interval.toLong(),
            pendingIntent
        )
        Toast.makeText(this, R.string.msg_alarm_set, Toast.LENGTH_SHORT).show()
    }
}