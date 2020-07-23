package com.example.annotation

import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

       /*val bitmap: Bitmap = Bitmap.createBitmap(500,500,Bitmap.Config.ARGB_8888)
        val v: View = Annotate(applicationContext)
        val canvas:Canvas = Canvas(bitmap)
        v.draw(canvas)
        image.setImageBitmap(bitmap)*/
    }
}
