package com.example.progressbar

class WaveProgressBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var wavePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#2196F3")
        style = Paint.Style.FILL
    }

    private var borderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#E0E0E0")
        style = Paint.Style.STROKE
        strokeWidth = 4f
    }

    private var textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        textSize = 48f
        textAlign = Paint.Align.CENTER
        typeface = Typeface.DEFAULT_BOLD
    }

    private var progress = 0f // 0.0 - 1.0
    private var waveAmplitude = 20f
    private var waveFrequency = 0.02f
    private var wavePhase = 0f
    private val wavePath = Path()
    private var animationValue = 0f
    private val animator = ValueAnimator.ofFloat(0f, 1f).apply {
        duration = 2000
        repeatCount = ValueAnimator.INFINITE
        interpolator = LinearInterpolator()
        addUpdateListener {
            animationValue = it.animatedValue as Float
            wavePhase = animationValue * 2 * Math.PI.toFloat()
            invalidate()
        }
    }

    fun setProgress(progress: Float) {
        this.progress = progress.coerceIn(0f, 1f)
        invalidate()
    }

    fun startAnimation() {
        animator.start()
    }

    fun stopAnimation() {
        animator.cancel()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width.toFloat()
        val height = height.toFloat()
        val centerX = width / 2
        val centerY = height / 2

        // Рисуем фон
        canvas.drawRoundRect(0f, 0f, width, height, 20f, 20f, borderPaint)

        // Высота волны в зависимости от прогресса
        val waveHeight = height * progress

        // Рисуем волну
        wavePath.reset()
        wavePath.moveTo(0f, height)

        for (x in 0 until width.toInt()) {
            val y = (height - waveHeight) +
                    Math.sin(waveFrequency * x + wavePhase).toFloat() * waveAmplitude
            wavePath.lineTo(x.toFloat(), y.coerceAtMost(height))
        }

        wavePath.lineTo(width, height)
        wavePath.close()

        canvas.drawPath(wavePath, wavePaint)

        // Рисуем текст прогресса
        val progressText = "${(progress * 100).toInt()}%"
        val textY = centerY - (textPaint.descent() + textPaint.ascent()) / 2
        canvas.drawText(progressText, centerX, textY, textPaint)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.cancel()
    }
}