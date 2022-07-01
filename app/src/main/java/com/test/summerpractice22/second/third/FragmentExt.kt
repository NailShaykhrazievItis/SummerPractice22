package com.test.summerpractice22.second.third

import android.view.View
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(
    message: String,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_LONG
) {
    Snackbar.make(
        this,
        message,
        duration
    ).show()
}
