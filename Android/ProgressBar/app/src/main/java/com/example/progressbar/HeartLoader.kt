package com.example.progressbar

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Color
import android.graphics.CornerPathEffect
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.moveTo

class HeartLoader @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val heartPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        style = Paint.Style.FILL
        pathEffect = CornerPathEffect(10f)
    }

    private val outlinePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#FFCDD2")
        style = Paint.Style.STROKE
        strokeWidth = 3f.dp
    }

    private var rotationAngle = 0f
    private var scale = 1f
    private val heartPath = android.graphics.Path()

    private val animator = ValueAnimator.ofFloat(0f, 1f).apply {
        duration = 1500
        repeatCount = ValueAnimator.INFINITE
        interpolator = AccelerateDecelerateInterpolator()
        addUpdateListener {
            val progress = it.animatedValue as Float
            rotationAngle = progress * 360f
            scale = 0.8f + 0.4f * Math.sin(progress * Math.PI * 2).toFloat()
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

    private fun createHeartPath(size: Float): Path {
        val path = Path()
        path.moveTo(0f, -0.25f * size)

        // Верхняя левая кривая
        path.cubicTo(
            -0.4f * size, -0.5f * size,
            -0.8f * size, 0.1f * size,
            0f, 0.5f * size
        )

        // Верхняя правая кривая
        path.cubicTo(
            0.8f * size, 0.1f * size,
            0.4f * size, -0.5f * size,
            0f, -0.25f * size
        )

        path.close()
        return path
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()
        canvas.translate(width / 2f, height / 2f)
        canvas.rotate(rotationAngle)
        canvas.scale(scale, scale)

        val size = minOf(width, height) * 0.3f
        val heart = createHeartPath(size)

        // Рисуем контур
        canvas.drawPath(heart, outlinePaint)

        // Рисуем заполнение
        canvas.drawPath(heart, heartPaint)

        canvas.restore()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.cancel()
    }
}

