package com.example.mysecond

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        if (intent.hasExtra("User_string")) {
            val msg=intent.getStringExtra("User_string")
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
            name_one.text=msg
        }

    }
}