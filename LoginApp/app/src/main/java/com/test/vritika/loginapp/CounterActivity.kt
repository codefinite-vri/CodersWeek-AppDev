package com.test.vritika.loginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_counter.*

class CounterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        var incrementNo=0
        button.setOnClickListener {
            incrementNo++
            countValue.text=incrementNo.toString()
        }
    }
}
