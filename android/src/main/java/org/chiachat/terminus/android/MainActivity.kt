package org.chiachat.terminus.android;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import org.chiachat.terminus.Platform

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Hello ${Platform.getPlatform()}")
        }
    }
}