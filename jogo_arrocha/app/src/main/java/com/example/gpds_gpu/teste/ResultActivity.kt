package com.example.gpds_gpu.teste

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    lateinit var back: Button
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        this.result = findViewById(R.id.resultado)
        this.back   = findViewById(R.id.voltar)
        printResult()

        this.back.setOnClickListener({onClick(it)})
    }

    fun printResult(){
        val it = getIntent()

        if (it.getStringExtra("MSN").equals("v")) {
            this.result.setText("Ganhou!!\n")
            this.result.setBackgroundColor(Color.GREEN)
        }else{
            this.result.setText("Perdeu!!\n")
            result.setBackgroundColor(Color.RED)
        }
        this.result.append(it.getStringExtra("placar"))
        setResult(Activity.RESULT_OK, it)
    }

    fun onClick(view: View){
        printResult()
        finish()
    }
}
