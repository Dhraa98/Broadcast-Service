package com.broadcastservices.receiver

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.broadcastservices.R


class DeviceBootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent!!.action.equals("android.intent.action.BOOT_COMPLETED")) {
            /* Setting the alarm here */
            val alarmIntent = Intent(context, AlarmReceiver::class.java)
            val pendingIntent =
                PendingIntent.getBroadcast(context, 0, alarmIntent, 0)
            val manager =
                context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val interval = 8000
            manager.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(),
                interval.toLong(),
                pendingIntent
            )
            Toast.makeText(context, R.string.msg_alarm_set, Toast.LENGTH_SHORT).show()
        }
    }
}