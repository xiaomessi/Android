package com.example.broadcasttest3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastReceiver1 : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"Receive1",Toast.LENGTH_SHORT).show()
    }

}