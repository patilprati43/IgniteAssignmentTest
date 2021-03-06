package com.example.ignite.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class BooknameTextview : AppCompatTextView {
    var ttfname:String="montserrat_regular.ttf"
    constructor(context: Context) : super(context) {
        val face = Typeface.createFromAsset(context.assets, ttfname)
        this.typeface = face
    }

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        val face = Typeface.createFromAsset(context.assets, ttfname)
        this.typeface = face
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyle: Int
    ) : super(context, attrs, defStyle) {
        val face = Typeface.createFromAsset(context.assets, ttfname)
        this.typeface = face
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }
}
