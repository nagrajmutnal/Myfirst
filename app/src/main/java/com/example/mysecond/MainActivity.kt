package com.example.mysecond

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToast.setOnClickListener {
            val i = Log.i("MainActivity", "button was pressed")
            Toast.makeText(this, "button was clicked", Toast.LENGTH_SHORT).show()


        }
       sendMessageToNextActivity.setOnClickListener({
            val message: String = enterMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("User_string",message)
            startActivity(intent)
        })

        sndtootherapps.setOnClickListener {
            val msgg :String = enterMessage.text.toString()
            val intent=Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,msgg)
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"share to"))
        }
        recyclerview.setOnClickListener {
            val intent=Intent(this,HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}