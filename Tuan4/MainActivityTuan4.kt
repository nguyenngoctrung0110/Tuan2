package com.example.tuan2.Tuan4

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tuan2.R

class MainActivityTuan4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val context: Context = this
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_tuan4)
        var btnGet=findViewById<Button>(R.id.btnGetData)
        var tvKQ=findViewById<TextView>(R.id.tvKQ)
        val fn1=VolleyFn1()
        btnGet.setOnClickListener {
            fn1.getAllData(context, tvKQ!!)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}