package com.test.vritika.dogstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonOpen: Button = findViewById(R.id.button)
        buttonOpen.setOnClickListener{
            val intent = Intent(this, BreedActivity::class.java)
            startActivity(intent)
        }
    }
}
