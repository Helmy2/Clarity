package com.example.clarity.core.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.clarity.core.ui.theme.ClarityTheme

@Composable
fun ClarityIcon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = ClarityTheme.colors.onSurface
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Preview
@Composable
fun ClarityIconPreview() {
    ClarityIcon(
        imageVector = Icons.Default.AccountCircle,
        contentDescription = "Account"
    )
}

