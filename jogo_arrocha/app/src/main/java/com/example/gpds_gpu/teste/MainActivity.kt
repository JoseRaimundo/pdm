package com.example.gpds_gpu.teste

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var left: TextView
    lateinit var right: TextView
    lateinit var input: EditText
    lateinit var confirm: Button

    private var pontos = Pontos()
    private var random_key = 0
    private var RESULT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        this.left = findViewById(R.id.esquerda)
        this.right = findViewById(R.id.direita)
        this.input = findViewById(R.id.entrada)
        this.confirm = findViewById(R.id.confirma)
        this.confirm.setOnClickListener({ jogar() })
        resetGame()
    }

    fun resetGame(){
        val random = Random()
        this.random_key = random.nextInt(100)
    }

    fun jogar(){
        var value = this.input.text.toString().toInt()

        this.input.setText("")
        if (value == random_key || value <= this.left.text.toString().toInt() || value >= this.right.text.toString().toInt()){
            resultTest(1)
        }else if (value > random_key){
            this.right.setText(value.toString())
        }else{
            this.left.setText(value.toString())
        }

        if (this.left.text.toString().toInt()+1 == random_key && this.right.text.toString().toInt()-1 == random_key){
            resultTest(2)
        }
    }

    fun resultTest(r: Int){
        val it = Intent(this, ResultActivity::class.java)
        if(r == 1) {
            pontos.marcaDerrota()
            it.putExtra("MSN", "p")
            it.putExtra("placar", pontos.retornaPlacar())
        }else {
            pontos.marcaVitoria()
            it.putExtra("MSN", "v")
            it.putExtra("placar", pontos.retornaPlacar())
        }
        this.left.setText("0")
        this.right.setText("100")
        resetGame()
        startActivity(it)
    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT){
            if (resultCode == Activity.RESULT_OK){
                val msg = data?.getStringExtra("MSN")
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }
        }

    }

}
