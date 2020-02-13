package com.example.mysecond

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mysecond.Supplier.hobbies
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*


class HobbiesAdapter (val context: Context, hobbies:List<Hobby>) :
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        println(hobbies.size)
        return hobbies.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        println(hobby)
        holder.SetData(hobby, position)

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentHobby: Hobby? = null
        var currentposition: Int = 0

        init {
            itemView.setOnClickListener {
                Toast.makeText(context, currentHobby!!.title + " clicked", Toast.LENGTH_SHORT).show()
                //val message: String = "hello"
            }


            itemView.txvTitle.setOnClickListener({
               val mssg=  currentHobby!!.title.toString()

                val intent = Intent(itemView.context, NextAct::class.java)

                intent.putExtra("string", mssg)
                itemView.context.startActivity(intent)
            }
            )
            itemView.imageView.setOnClickListener {
                val msgg: String = "my hobby is" + currentHobby!!.title
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, msgg)
                intent.type = "text/plain"
                context.startActivity(Intent.createChooser(intent, "share to"))
            }
        }


        fun SetData(hobby:Hobby?,position: Int)
        {itemView.txvTitle.text=hobby!!.title
         this.currentHobby=hobby
         this.currentposition=position
        }
    }
    }
