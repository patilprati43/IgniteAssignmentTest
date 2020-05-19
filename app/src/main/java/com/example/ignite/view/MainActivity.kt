package com.example.ignite.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ignite.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //fiction click listener
        txtfictiongenre.setOnClickListener {
            val intent = Intent(this, DisplayActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("genre", "fiction")
            // start your next activity
            startActivity(intent)
        }

        //politics click listener
        txtpoliticsgenre.setOnClickListener {
            val intent = Intent(this, DisplayActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("genre", "politics")
            // start your next activity
            startActivity(intent)
        }

        //drama click listener
        txtdramagenre.setOnClickListener {
            val intent = Intent(this, DisplayActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("genre", "drama")
            // start your next activity
            startActivity(intent)
        }

        //humor click listener
        txthumorgenre.setOnClickListener {
            val intent = Intent(this, DisplayActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("genre", "humor")
            // start your next activity
            startActivity(intent)
        }

        //philosophy click listener
        txtphilosophygenre.setOnClickListener {
            val intent = Intent(this, DisplayActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("genre", "philosophy")
            // start your next activity
            startActivity(intent)
        }

        //history click listener
        txthistorygenre.setOnClickListener {
            val intent = Intent(this, DisplayActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("genre", "history")
            // start your next activity
            startActivity(intent)
        }

        //adventure click listener
        txtadventuregenre.setOnClickListener {
            val intent = Intent(this, DisplayActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("genre", "adventure")
            // start your next activity
            startActivity(intent)
        }
    }
}
