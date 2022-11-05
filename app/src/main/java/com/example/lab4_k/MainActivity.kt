package com.example.lab4_k

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_choice).setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent? ){
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        if (requestCode == 1) {
            if (resultCode == 101) {
                val b = data.extras
                val str1 = b?.getString("drink")
                val str2 = b?.getString("sugar")
                val str3 = b?.getString("ice")
                findViewById<TextView>(R.id.tv_meal).text = String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s\n\n", str1, str2, str3)
            }
        }
    }
}