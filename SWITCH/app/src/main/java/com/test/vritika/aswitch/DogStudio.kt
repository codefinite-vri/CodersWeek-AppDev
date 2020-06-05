package com.test.vritika.aswitch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DogStudio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_studio)
        val buttonOpen: Button = findViewById(R.id.button)
        buttonOpen.setOnClickListener{
            val intent = Intent(this, DogMain2Activity::class.java)
            startActivity(intent)
        }
    }
}
