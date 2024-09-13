package com.atech.dict.ui.theme

import android.content.Context

actual class isSystemInDarkTheme(
    private val context: Context
) {
    actual fun isSystemInDarkTheme(): Boolean {
        return context.resources.configuration.uiMode and
                android.content.res.Configuration.UI_MODE_NIGHT_MASK == android.content.res.Configuration.UI_MODE_NIGHT_YES
    }
}