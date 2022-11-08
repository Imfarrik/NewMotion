package com.example.myapplicationnewmotion.helper.adapter

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class TaskPageTransformer(
    private val mPageMargin: Int,
    private val mPageTopMargin: Int,
    private val mOffset: Int
) : ViewPager2.PageTransformer {

    constructor(mPageMargin: Int) : this(mPageMargin, 0, 0)

    companion object {
        private const val MIN_ALPHA = 0.6f
        private const val MIN_SCALE = 0.8f
    }

    override fun transformPage(view: View, position: Float) {
        // Sets the horizontal location of this view relative to its horizontal position.
        view.translationX = getTranslationX(position)

        // Sets the vertical location of this view relative to its horizontal position.
        view.scaleY = getScaleY(position)
    }

    private fun getTranslationX(position: Float): Float { // Modify the default slide transitionX
        return position * (2 * mOffset + mPageMargin)
    }

    private fun getTranslationY(position: Float): Float {
        return when {
            position < -1 -> { // [-Infinity,-1)
                // This page is way off-screen to the left.
                mPageTopMargin.toFloat()
            }
            position > 1 -> { // (1,+Infinity]
                // This page is way off-screen to the right.
                mPageTopMargin.toFloat()
            }
            else -> { // [-1,1]
                // Modify the default slide transitionY
                val sqt = position * position
                mPageTopMargin * sqt / (2.0f * (sqt - abs(position)) + 1.0f)
            }
        }
    }

    private fun getScaleY(position: Float): Float {
        return when {
            position < -1 -> { // [-Infinity,-1)
                // This page is way off-screen to the left.
                0.8f
            }
            position > 1 -> { // (1,+Infinity]
                // This page is way off-screen to the right.
                0.8f
            }
            else -> { // [-1,1]
                // Modify the default slide transitionY
                val sqt = position * position
                MIN_SCALE + -0.2f * abs(position) + 0.2f
            }
        }
    }

    private fun getAlpha(position: Float): Float {
        return when {
            position < -1 -> { // [-Infinity,-1)
                // This page is way off-screen to the left.
                MIN_ALPHA
            }
            position > 1 -> { // (1,+Infinity]
                // This page is way off-screen to the right.
                MIN_ALPHA
            }
            else -> { // [-1,1]
                // Modify the default alpha
                MIN_ALPHA + -0.4f * abs(position) + 0.4f
            }
        }
    }

}