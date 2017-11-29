package com.example.gpds_gpu.localdados

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var imagemArea : ImageView
    private lateinit var btnfoto    : Button
    private lateinit var btnsave    : Button
    private lateinit var btnloc     : Button
    private lateinit var inte       : Intent
    private lateinit var locArea    : TextView

    lateinit var gpsManager         : LocationManager
    lateinit var gpsListener        : LocationListener
    var localizacao = ""
    var descricao   = ""
    var locais = ArrayList<LocalClasse>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.gpsManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        this.gpsListener = GPSListener()
        this.imagemArea = findViewById(R.id.image_area)
        this.btnsave    = findViewById(R.id.btnSave)
        this.btnfoto    = findViewById(R.id.btnPhoto)
        this.btnloc     = findViewById(R.id.btnLocalization)
        this.locArea    = findViewById(R.id.locArea)
        this.btnfoto.setOnClickListener({ tirarFoto(it) })
        this.btnloc.setOnClickListener({ getLocal(it)})
        this.btnsave.setOnClickListener({ salvarDados(it)})
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (resultCode == Activity.RESULT_OK) {
            val photo = data.extras!!.get("data") as Bitmap
            this.inte = data
            imagemArea.setScaleType(ImageView.ScaleType.FIT_XY)
            imagemArea.setImageBitmap(photo)
            var local = LocalClasse(descricao, localizacao, photo)
            this.locais.add(local)
            System.out.print(local.descricao)

        }
    }

    fun tirarFoto(view : View){
        startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE), 1)
        btnfoto.isEnabled = false
        btnSave.isEnabled = true
    }

    fun salvarDados(view: View){
        System.out.println("Entrou aqui"+ locais[0].descricao)
//        val it = Intent(this, ListagemActivity::class.java)
//        it.putExtra("locais",this.locais)
//        startActivity(Intent.createChooser(it, "compartilhar"))
    }

    fun getLocal(view: View) {
        var time = 10
        while (this.gpsListener.toString() == "" && time != 0){
            time = time - 1
            Thread.sleep(1000)
        }
        if(this.gpsListener.toString() != "") {
            this.locArea.setText(gpsListener.toString())
//            onStop()
//            this.gpsManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//            this.gpsListener = GPSListener()
//            onResume()
        }else{
            this.locArea.setText("Tente novamente!")
        }
    }

    @SuppressLint("MissingPermission")
    override fun onResume() {
        super.onResume()
       this.gpsManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, this.gpsListener)
    }

    override fun onStop() {
        super.onStop()
        this.gpsManager.removeUpdates(this.gpsListener)
    }
}


