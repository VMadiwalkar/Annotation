package com.example.annotation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.graphics.Paint
import android.graphics.Path
import android.util.Log
import android.view.MotionEvent
import android.view.ViewGroup.LayoutParams
import android.widget.Toast

class Annotate: View{
     lateinit var params:LayoutParams
    private var path:Path = Path()
    private var brush:Paint = Paint()
    constructor(context: Context) : super(context) {
        init()

        //params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    }
    fun init(){
        Log.d("annotation","init func");
        brush.isAntiAlias = true;
        brush.color = Color.RED
        brush.style = Paint.Style.STROKE
        brush.strokeJoin = Paint.Join.ROUND
        brush.strokeWidth = 8f;
    }
    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet){
        init()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d("annotation","init");

       // Toast.makeText(context,"YOLO",Toast.LENGTH_LONG)
        var pointX = event?.getX()
        var pointY = event?.getY();
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                if (pointX != null && pointY != null) {
                        path.moveTo(pointX,pointY)
                    }
                return true
                }
            MotionEvent.ACTION_MOVE -> {
                if (pointX != null && pointY != null) {
                    path.lineTo(pointX,pointY)
                }
                //return true
            }
            else -> return false

            }
        postInvalidate();
        return false
        }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawPath(path,brush)
    }


    constructor(context: Context,attributeSet: AttributeSet,defStyleAttr:Int) : super(context,attributeSet,defStyleAttr)   {init()}



}