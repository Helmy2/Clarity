package com.example.clarity.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clarity.core.ui.ClarityCard
import com.example.clarity.core.ui.ClarityTheme

@Composable
fun TaskItem(
    title: String,
    isCompleted: Boolean,
    onCompletedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    ClarityCard(modifier = modifier) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                modifier = Modifier.weight(1f)
            )
            Checkbox(checked = isCompleted, onCheckedChange = onCompletedChange)
        }
    }
}

@Preview(name = "Task Item")
@Composable
fun TaskItemPreview() {
    ClarityTheme {
        TaskItem(title = "My Task", isCompleted = false, onCompletedChange = {})
    }
}

@Preview(name = "Completed Task Item")
@Composable
fun CompletedTaskItemPreview() {
    ClarityTheme {
        TaskItem(title = "My Completed Task", isCompleted = true, onCompletedChange = {})
    }
}
