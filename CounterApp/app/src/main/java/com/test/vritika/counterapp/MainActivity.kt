package com.test.vritika.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var incrementNo=0
        button.setOnClickListener {
            incrementNo++
            countValue.text=incrementNo.toString()
        }
    }
}
