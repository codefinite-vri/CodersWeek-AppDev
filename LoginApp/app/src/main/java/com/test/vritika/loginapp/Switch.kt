package com.test.vritika.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Switch : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1: Button = findViewById(R.id.counter)
        button1.setOnClickListener{
            val intent1 = Intent(this, CounterActivity::class.java)
            startActivity(intent1)
        }
        val button2: Button = findViewById(R.id.dogs)
        button2.setOnClickListener{
            val intent2 = Intent(this, DogStudio::class.java)
            startActivity(intent2)
        }
    }
}
