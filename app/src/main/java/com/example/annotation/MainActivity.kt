package com.example.annotation

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_main)
        val strokeWidth = 40
        drawing?.setStrokWidth(strokeWidth.toFloat())
        strokeWidthSelector?.progress = strokeWidth
        btnGreen.setOnClickListener(){
            Log.d("Main","Red Clicked");
            drawing.setPencilColor(Color.GREEN)


        }
        btnErase.setOnClickListener(){
            drawing.setMode(SimpleDrawingView.DrawingMode.ERASER)
        }

        btnRed.setOnClickListener(){
            drawing.setPencilColor(Color.RED)
        }

        strokeWidthSelector.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                drawing?.setStrokWidth(progress.toFloat())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

    fun setEraseMode(view: View) {
        drawing?.setMode(SimpleDrawingView.DrawingMode.ERASER)
    }

    fun setPencilColor(view: View) {
        val color = (view.background as? ColorDrawable)?.color ?: Color.BLACK
        drawing?.setMode(SimpleDrawingView.DrawingMode.ERASER)
        drawing?.setPencilColor(color)
    }


}
