package com.example.clarity.core.ui

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = 0 // Temporary fix for build issue
)

val InterFont = GoogleFont("Inter")

val InterFontFamily = FontFamily(
    Font(googleFont = InterFont, fontProvider = provider)
)

val ClarityTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.41).sp
    ),
    titleLarge = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        fontSize = 34.sp,
        lineHeight = 41.sp,
        letterSpacing = 0.37.sp
    )
)
