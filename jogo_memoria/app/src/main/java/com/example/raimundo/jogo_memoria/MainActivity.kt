package com.example.raimundo.jogo_memoria


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btn16: Button;
    val JOGO = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btn16 = findViewById(R.id.btn16)
        this.btn16.setOnClickListener({ onClick(it) })

    }

    fun onClick(view: View) {
        val it = Intent(this, JogoActivity::class.java)
        startActivityForResult(it, JOGO)
    }

}