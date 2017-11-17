package com.example.gpds_gpu.teste

/**
 * Created by gpds-gpu on 17/11/17.
 */
class Pontos (){
    private var vitorias : Int = 0
    private var derrotas : Int = 0

    fun marcaVitoria(){
        this.vitorias++
    }

    fun marcaDerrota(){
        this.derrotas++
    }

    fun retornaPlacar() : String{
        return "Vitorias: ${this.vitorias}\nDerrotas: ${this.derrotas}"
    }

}