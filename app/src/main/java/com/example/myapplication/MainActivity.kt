package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redInput = findViewById<EditText>(R.id.redInput)
        val greenInput = findViewById<EditText>(R.id.greenInput)
        val blueInput = findViewById<EditText>(R.id.blueInput)
        val btn = findViewById<Button>(R.id.createBtn)
        val colorView = findViewById<View>(R.id.colorView)

        btn.setOnClickListener {
            val r = redInput.text.toString()
            val g = greenInput.text.toString()
            val b = blueInput.text.toString()

            if (r.length == 2 && g.length == 2 && b.length == 2) {
                try {
                    val color = Color.parseColor("#$r$g$b")
                    colorView.setBackgroundColor(color)
                } catch (e: Exception) {
                    Toast.makeText(this, "Invalid hex values", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Enter 2 hex chars for each channel", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
