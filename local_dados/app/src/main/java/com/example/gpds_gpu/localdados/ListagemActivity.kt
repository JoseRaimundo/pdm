package com.example.gpds_gpu.localdados

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ListagemActivity : AppCompatActivity() {

    lateinit var locais : ArrayList<LocalClasse>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem)
        printList()

    }

    fun printList(){
        val it = getIntent()
        this.locais = it.getParcelableArrayListExtra("locais")
        System.out.print(locais[0])
    }
}
