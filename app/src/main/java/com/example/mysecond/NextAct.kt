package com.example.mysecond
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.nextact_main.*

class NextAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nextact_main)
        var button:Button=findViewById(R.id.add)
        if (intent.hasExtra("string")) {
            val msg = intent.getStringExtra("string")
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            if(msg=="sleeping")
            { var msg1:String=msg+" sleeping is food daily 8 hours sleeping is needed"
            textViewi.text = msg1}
            else
                textViewi.text=msg

        }
        button.setOnClickListener ({
            Toast.makeText(this,"done",Toast.LENGTH_SHORT).show()
        })
    }
}