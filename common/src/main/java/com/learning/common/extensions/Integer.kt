package com.learning.common.extensions

import android.content.res.Resources
import android.util.DisplayMetrics

fun Int.toPx() :Int
{
    val metrics = Resources.getSystem().displayMetrics

    return (this * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
}