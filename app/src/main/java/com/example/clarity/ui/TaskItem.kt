package com.example.clarity.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clarity.core.ui.components.ClarityCard
import com.example.clarity.core.ui.components.ClarityCheckbox
import com.example.clarity.core.ui.components.ClarityIcon
import com.example.clarity.core.ui.components.ClarityText
import com.example.clarity.core.ui.theme.ClarityTheme
import com.example.clarity.core.ui.theme.shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskItem(
    title: String,
    isCompleted: Boolean,
    onCompletedChange: (Boolean) -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    val dismissState = rememberSwipeToDismissBoxState()

    LaunchedEffect(dismissState.targetValue) {
        if (dismissState.targetValue == SwipeToDismissBoxValue.EndToStart) {
            onDelete()
        }
    }

    SwipeToDismissBox(
        state = dismissState,
        modifier = modifier,
        backgroundContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = shapes.large)
                    .background(Color.Red.copy(alpha = 0.8f))
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.CenterEnd,
            ) {
                ClarityIcon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete",
                    tint = Color.White,
                )
            }
        },
        enableDismissFromStartToEnd = false
    ) {
        ClarityCard {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ClarityText(
                    text = title,
                    modifier = Modifier.weight(1f)
                )
                ClarityCheckbox(checked = isCompleted, onCheckedChange = onCompletedChange)
            }
        }
    }
}

@Preview(name = "Task Item")
@Composable
fun TaskItemPreview() {
    ClarityTheme {
        TaskItem(title = "My Task", isCompleted = false, onCompletedChange = {}, onDelete = {})
    }
}

@Preview(name = "Completed Task Item")
@Composable
fun CompletedTaskItemPreview() {
    ClarityTheme {
        TaskItem(
            title = "My Completed Task",
            isCompleted = true,
            onCompletedChange = {},
            onDelete = {})
    }
}
