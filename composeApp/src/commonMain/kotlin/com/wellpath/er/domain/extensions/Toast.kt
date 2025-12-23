package com.wellpath.er.domain.extensions

import com.wellpath.er.domain.model.ToastLength

/**
 * Expect function to show platform specific toast
 */
expect fun showToast(context: Any?, message: String, length: ToastLength)