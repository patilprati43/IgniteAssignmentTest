package com.example.ignite.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.TextViewCompat


class Heading1Textview : AppCompatTextView {

    companion object{
        const val ttfname:String="montserrat_semibold.ttf"

    }
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
