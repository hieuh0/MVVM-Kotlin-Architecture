package com.nta.mvvm_kotlin.utils.extension

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.graphics.Rect
import android.view.HapticFeedbackConstants
import android.view.View
import android.view.ViewTreeObserver

fun View.beInvisibleIf(beInvisible: Boolean) = if (beInvisible) beInvisible() else beVisible()

fun View.beVisibleIf(beVisible: Boolean) = if (beVisible) beVisible() else beGone()

fun View.beGoneIf(beGone: Boolean) = beVisibleIf(!beGone)

fun View.beInvisible() {
    visibility = View.INVISIBLE
}

fun View.beVisible() {
    visibility = View.VISIBLE
}

fun View.beGone() {
    visibility = View.GONE
}

fun View.beGoneWithAnimation() {
    animate().translationX(-width.toFloat()).alpha(0f).setDuration(ANIM_DURATION)
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                beGone()
            }
        })
}


fun View.disappear(duration: Long) {
    animate().alpha(0f).setDuration(duration).setListener(object : Animator.AnimatorListener {
        override fun onAnimationRepeat(p0: Animator?) {
        }

        override fun onAnimationEnd(p0: Animator?) {
            beGone()
        }

        override fun onAnimationCancel(p0: Animator?) {
        }

        override fun onAnimationStart(p0: Animator?) {
        }
    })
}

fun View.appear(duration: Long) {
    animate().alpha(1f).setDuration(duration).setListener(object : Animator.AnimatorListener {
        override fun onAnimationRepeat(p0: Animator?) {
        }

        override fun onAnimationEnd(p0: Animator?) {

        }

        override fun onAnimationCancel(p0: Animator?) {
        }

        override fun onAnimationStart(p0: Animator?) {
            beVisible()
        }
    })
}

fun View.onGlobalLayout(callback: () -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            viewTreeObserver.removeOnGlobalLayoutListener(this)
            callback()
        }
    })
}

fun View.isVisible() = visibility == View.VISIBLE

fun View.isInvisible() = visibility == View.INVISIBLE

fun View.isGone() = visibility == View.GONE

fun View.performHapticFeedback() = performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)

fun View.listenSoftKeyboard(callback: (() -> Unit)? = null) {
    this.viewTreeObserver.addOnGlobalLayoutListener {
        val r = Rect()
        getWindowVisibleDisplayFrame(r)
        val heightDiff: Int = rootView.height - r.bottom
        if (heightDiff < rootView.height * 0.15) {
            callback?.invoke()
        } else {

        }
    }
}

const val ANIM_DURATION = 250L
