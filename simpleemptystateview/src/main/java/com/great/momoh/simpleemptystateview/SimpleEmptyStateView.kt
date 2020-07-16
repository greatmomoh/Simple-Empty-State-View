package com.great.momoh.simpleemptystateview

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.LinearLayout
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.simple_empty_state_view_layout.view.*

class SimpleEmptyStateView : LinearLayout {

    private var view: View
    private var actionButtonClickListener: ActionButtonClickListener? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        view = inflater.inflate(R.layout.simple_empty_state_view_layout, this, true)

        val a = context.obtainStyledAttributes(attrs, R.styleable.SimpleEmptyStateView, 0, 0)

        val emptyStateTitle: String? =
            a.getString(R.styleable.SimpleEmptyStateView_emptyStateTitleText)
        val emptyStateImageSrc: Drawable? =
            a.getDrawable(R.styleable.SimpleEmptyStateView_emptyStateImageSrc)
        val emptyStateCaption: String? =
            a.getString(R.styleable.SimpleEmptyStateView_emptyStateCaptionText)
        val emptyStateButtonText: String? =
            a.getString(R.styleable.SimpleEmptyStateView_emptyStateButtonText)

        val emptyStateButtonVisible: Boolean =
            a.getBoolean(R.styleable.SimpleEmptyStateView_isButtonVisible, false)
        val emptyStateTitleVisible: Boolean =
            a.getBoolean(R.styleable.SimpleEmptyStateView_isTitleVisible, true)

        a.recycle()

        if (emptyStateTitle != null) {
            title.text = emptyStateTitle
        }

        if (emptyStateTitleVisible) {
            title.visibility = View.VISIBLE
        } else {
            title.visibility = View.INVISIBLE
        }

        if (emptyStateImageSrc != null) {
            image.setImageDrawable(emptyStateImageSrc)
        } else {
            image.visibility = View.INVISIBLE
        }

        setCaption(emptyStateCaption)

        if (emptyStateButtonText != null) {
            next_button.text = emptyStateButtonText
        }

        if (emptyStateButtonVisible) {
            next_button.visibility = View.VISIBLE
        } else {
            next_button.visibility = View.GONE
        }

        next_button.setOnClickListener {
            actionButtonClickListener?.invoke()
        }

        val actionBtnBounceAnim =
            ObjectAnimator.ofFloat(image, "translationY", 0f, 25f, 0f)
        actionBtnBounceAnim.interpolator = AccelerateDecelerateInterpolator()
        actionBtnBounceAnim.duration = 3000
        actionBtnBounceAnim.repeatMode = ValueAnimator.RESTART
        actionBtnBounceAnim.repeatCount = ValueAnimator.INFINITE
        actionBtnBounceAnim.start()

    }

    var isButtonVisible: Boolean = false
        set(value) {
            field = value
            next_button.isVisible = value
        }

    var isTitleVisible: Boolean = false
        set(value) {
            field = value
            title.isVisible = value
        }

    fun setCaption(emptyStateCaption: String?) {
        if (emptyStateCaption != null) {
            caption.text = emptyStateCaption
        }
    }

    fun setActionBtnClickListener(actionButtonClickListener: ActionButtonClickListener) {
        this.actionButtonClickListener = actionButtonClickListener
    }


    interface ActionButtonClickListener {
        fun invoke()
    }
}