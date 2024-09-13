package com.atech.dict.ui.theme

import com.jthemedetecor.OsThemeDetector

private fun systemInDarkTheme(): Boolean {
    val osThemeDetector = OsThemeDetector.getDetector()
    return osThemeDetector.isDark
}

actual class isSystemInDarkTheme {
    actual fun isSystemInDarkTheme(): Boolean {
        return systemInDarkTheme()
    }
}