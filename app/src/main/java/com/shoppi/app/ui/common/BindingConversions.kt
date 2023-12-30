package com.shoppi.app.ui.common

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.databinding.BindingConversion

@BindingConversion
fun convertToColorDrawble(color: String): Drawable {
    return ColorDrawable(Color.parseColor(color))
}