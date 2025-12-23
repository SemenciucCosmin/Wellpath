package com.wellpath.er.domain.extensions

import android.content.Context
import android.widget.Toast
import com.wellpath.er.domain.model.ToastLength

actual fun showToast(
    context: Any?,
    message: String,
    length: ToastLength,
) {
    Toast.makeText(
        context as? Context ?: return,
        message,
        when (length) {
            ToastLength.LONG -> Toast.LENGTH_LONG
            ToastLength.SHORT -> Toast.LENGTH_SHORT
        }
    ).show()
}