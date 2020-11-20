package com.broadcastservices.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.broadcastservices.R
import com.broadcastservices.constants.Constants


class AlarmReceiver : BroadcastReceiver(){
    private  val TAG = "AlarmReceiver"
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent!!.action == Constants.ACTION_RECEIVER) {
            val fooString = intent.getStringExtra(Constants.EXTRA_KEY)
            Toast.makeText(context, R.string.msg_receiver_called, Toast.LENGTH_LONG).show()
            Log.e(TAG, "onReceive: "+ fooString)
        }

    }
}