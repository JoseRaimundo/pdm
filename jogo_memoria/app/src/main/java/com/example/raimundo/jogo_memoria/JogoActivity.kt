package com.example.raimundo.jogo_memoria


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import java.util.Arrays
import java.util.Collections
import kotlin.collections.ArrayList
import kotlin.collections.listOf


class JogoActivity : AppCompatActivity() {
    private val RESULTADO = 2
    private val MAX_IMAGENS = 15
    private var status = 0
    private var placar = Placar()
    private lateinit var carta1: Carta
    private lateinit var carta2: Carta
    private lateinit var layout: GridLayout
    private lateinit var txtPontos: TextView
    private var cartasViradas = 0
    private var cartas = ArrayList<Carta>()
    private var image_capa = R.drawable.capa
    private var imagens = listOf(R.drawable.huck,
            R.drawable.luigi,
            R.drawable.goku,
            R.drawable.aranha,
            R.drawable.sonic,
            R.drawable.mario,
            R.drawable.volverine,
            R.drawable.batman
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)
        this.txtPontos = findViewById(R.id.txtPontos)
        this.layout = findViewById(R.id.layoutMain)
        this.criaCartas()
        this.montaMesa()
    }

    fun criaCartas() {
        var par = 0
        for (i in 1..MAX_IMAGENS + 1) {
            var c = Carta(i - 1, par, ImageButton(this))
            c.capa.setBackgroundResource(image_capa)
            c.capa.setTag(i - 1)
            c.capa.setOnClickListener({ onClick(it) })
            this.cartas.add(c)
            Collections.shuffle(this.cartas)
            if (i % 2 == 0) par += 1
        }
    }

    fun loclaizaCarta(key : Int): Carta{
        for (i in 0..MAX_IMAGENS)
            if(cartas[i].id_carta == key)
                return cartas[i]
        return cartas[0]
    }

    fun montaMesa() {
        for (i in 0..MAX_IMAGENS)
            this.layout.addView(cartas[i].capa)
    }

    fun atualizaPlacar() {
        this.txtPontos.setText(placar.toString())
    }

    fun verificaFinal(){
        if(cartasViradas >= 8){
            val it = Intent(this, ResultadoActivity::class.java)
            if(placar.acertos > placar.erros){
                it.putExtra("TEXTO", "Parabéns Você Ganhou!\n${placar.toString()}")
            }else if (placar.acertos < placar.erros){
                it.putExtra("TEXTO", "Vocé Perdeu!\n${placar.toString()}")
            }else {
                it.putExtra("TEXTO", "Vocé empatou!\n${placar.toString()}")
            }
            finish()
            startActivity(it)
        }
    }


    fun onClick(view: View) {
        var carta_temp = view as ImageButton

        if (status == 0) {
            carta1 = this.loclaizaCarta(carta_temp.tag.toString().toInt())
            carta_temp.setBackgroundResource(imagens[carta1.par_carta])
            status = 1
            carta_temp.isClickable = false
        } else if (status == 1) {
            carta2 = this.loclaizaCarta(carta_temp.tag.toString().toInt())
            carta_temp.setBackgroundResource(imagens[carta2.par_carta])
            if (carta1.par_carta == carta2.par_carta) {
                carta_temp.isClickable = false
                this.cartasViradas++;
                this.placar.acertou()
            } else {
                carta1.capa.setBackgroundResource(image_capa)
                carta1.capa.isClickable = true
                carta2.capa.setBackgroundResource(image_capa)
                carta2.capa.isClickable = true
                this.placar.errou()
            }
            status = 0

        }
        atualizaPlacar()
        verificaFinal()
    }
}

