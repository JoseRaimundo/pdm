package com.example.raimundo.jogo_memoria

/**
 * Created by raimundo on 10/11/17.
 */
class Placar () {
    var acertos = 0
    var erros   = 0

    fun acertou(){
        acertos++
    }

    fun errou(){
        erros++
    }

    override fun toString(): String {
        return  "Acertos: ${this.acertos} \n" +
                "Erros:   ${this.erros}"
    }
}