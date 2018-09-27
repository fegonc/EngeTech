package com.example.felip.engetech

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_foto.*
import kotlinx.android.synthetic.main.activity_foto.*
import kotlinx.android.synthetic.main.activity_pessoa_juridica1.*

class MainActivity : AppCompatActivity() {

    fun View.chamaTela1() {
        setContentView(R.layout.activity_pessoa_fisica1)
    }

    fun View.chamaTela2() {
        setContentView(R.layout.activity_pessoa_juridica1)
    }

    fun View.chamaFoto1() {
        setContentView(R.layout.activity_foto)

        tirarFoto.setOnClickListener {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (callCameraIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(callCameraIntent, CAMERA_REQUEST_CODE)
            }

        }

    }


    fun View.chamaFoto2() {
        setContentView(R.layout.activity_foto)

        tirarFoto.setOnClickListener {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (callCameraIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(callCameraIntent, CAMERA_REQUEST_CODE)
            }
        }
    }




    val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK && data != null &&  tirarFoto) {
                    lugarDaFoto.setImageBitmap(data.extras.get("data") as Bitmap)
                }
            }
            else -> {
                Toast.makeText( this, "Unrecognized request code", Toast.LENGTH_SHORT).show()
            }
        }

    }



    }


