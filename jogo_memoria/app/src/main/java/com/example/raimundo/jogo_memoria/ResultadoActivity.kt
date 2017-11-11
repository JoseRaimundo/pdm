package com.example.raimundo.jogo_memoria

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    private lateinit var telaResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        this.telaResult = findViewById(R.id.resultadoTela)
        this.telaResult.text = intent.getStringExtra("TEXTO")
    }
}
