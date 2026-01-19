package com.example.progressbar

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator

class DotsLoader @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val dotPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#FF5722")
    }

    private val dotRadius = 10f.dp
    private val dotSpacing = 20f.dp
    private val dotCount = 3
    private var animationProgress = 0f
    private val animator = ValueAnimator.ofFloat(0f, 1f).apply {
        duration = 600
        repeatCount = ValueAnimator.INFINITE
        repeatMode = ValueAnimator.REVERSE
        interpolator = AccelerateDecelerateInterpolator()
        addUpdateListener {
            animationProgress = it.animatedValue as Float
            invalidate()
        }
    }

    private val Float.dp: Float
        get() = this * resources.displayMetrics.density

    fun startAnimation() {
        animator.start()
    }

    fun stopAnimation() {
        animator.cancel()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val totalWidth = dotCount * dotRadius * 2 + (dotCount - 1) * dotSpacing
        val startX = (width - totalWidth) / 2 + dotRadius
        val centerY = height / 2f

        for (i in 0 until dotCount) {
            val dotX = startX + i * (dotRadius * 2 + dotSpacing)
            val scale = when (i) {
                0 -> 1f - animationProgress * 0.5f
                1 -> 1f + animationProgress * 0.3f
                else -> 1f + (1 - animationProgress) * 0.5f
            }

            canvas.drawCircle(dotX, centerY, dotRadius * scale, dotPaint)
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.cancel()
    }
}