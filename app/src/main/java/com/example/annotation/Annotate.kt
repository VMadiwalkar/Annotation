package com.example.annotation

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View


class Annotate: View{

     var mPaths: ArrayList<Path> = ArrayList<Path>()
     var mPaints :ArrayList<Paint> = ArrayList<Paint>()
     lateinit var mPath:Path
    var mPen : Int = Color.RED
    private lateinit var mPaint:Paint
    var mOldX: Float = 0.0f
    var mOldY: Float = 0.0f
    lateinit var mCanvas:Canvas
    var isErase : Boolean = false
     lateinit var mBitmap: Bitmap

    constructor(context: Context) : super(context) {
        init()

        //params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    }
    fun init(){
        Log.d("annotation","init func");
        mPath = Path()
        addPath(false)


    }
    fun addPath(fill : Boolean){
        mPath = Path()
        mPaths.add(mPath)
        mPaint = Paint()
        mPaints.add(mPaint)
        mPaint.color = mPen
        if (!fill)
            mPaint.style = Paint.Style.STROKE
        else
            mPaint.style = Paint.Style.FILL
        mPaint.strokeWidth = 20F

    }
    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet){
        init()
    }
    fun changeStroke(color:Int){

        this.mPen = color
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d("annotation","init");

       // Toast.makeText(context,"YOLO",Toast.LENGTH_LONG)
        var pointX = event!!.getX()
        var pointY = event!!.getY()
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                this.addPath(true)
               // if (pointX != null && pointY != null ) {

                        this.mPath.addCircle(pointX,pointY,mPaint.strokeWidth/2, Path.Direction.CW)


              //  }
                if (pointX != null && pointY != null) {
                    this.addPath(false)
                    mPath.moveTo(pointX,pointY)
                    }
                return true
                }
            MotionEvent.ACTION_MOVE -> {
                if (pointX != null && pointY != null) {

                    mPath.lineTo(pointX,pointY)
                }
                //return true
            }
            MotionEvent.ACTION_UP -> {
                this.addPath(true)
                if(mOldX == pointX && mOldY == pointY)
                    this.mPath.addCircle(pointX,pointY,10f, Path.Direction.CW)
            }
            else -> return false

            }
        postInvalidate()
        if (pointX != null && pointY != null) {
            mOldX = pointX
            mOldY = pointY
        }
        return false
        }

    override fun onDraw(canvas: Canvas?) {

        super.onDraw(canvas)
        var i :Int = 0
        while(i  < mPaths.size ) {
            canvas?.drawPath(mPaths.get(i), mPaints.get(i))
            i++
        }

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas =  Canvas(mBitmap);
    }




    constructor(context: Context,attributeSet: AttributeSet,defStyleAttr:Int) : super(context,attributeSet,defStyleAttr)   {init()}



}