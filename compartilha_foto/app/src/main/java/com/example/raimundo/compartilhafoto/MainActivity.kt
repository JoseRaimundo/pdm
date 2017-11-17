package com.example.raimundo.compartilhafoto

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Picture
import android.media.Image
import android.media.audiofx.EnvironmentalReverb
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import java.io.File
import android.provider.MediaStore.Images
import android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE





class MainActivity : AppCompatActivity() {

    private lateinit var imagemArea : ImageView
    private lateinit var btnfoto    : Button
    private lateinit var btncomp    : Button
    private lateinit var inte       :Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imagemArea = findViewById(R.id.image_area)
        btncomp = findViewById(R.id.btnCompartilha)
        btnfoto = findViewById(R.id.btnCamera)
        this.btnfoto.setOnClickListener({ tirarFoto(it) })
        this.btncomp.setOnClickListener({ compartilharFoto(it)})
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (resultCode == Activity.RESULT_OK) {
            val photo = data.extras!!.get("data") as Bitmap
            this.inte = data
            imagemArea.setScaleType(ImageView.ScaleType.FIT_XY)
            imagemArea.setImageBitmap(photo)
        }
    }

    fun tirarFoto(view : View){
        startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE), 1)
        btnfoto.isEnabled = false
        btncomp.isEnabled = true
    }

    fun compartilharFoto(view: View){
        var it = Intent(Intent.ACTION_SEND)
        it.setType("image/png")
        it.putExtras(inte)
        startActivity(Intent.createChooser(it, "compartilhar"))
        btncomp.isEnabled = false
        btnfoto.isEnabled = true
    }
}
