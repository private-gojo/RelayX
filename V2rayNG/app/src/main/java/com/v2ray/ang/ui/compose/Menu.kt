package dev.relayx.core.ui.compose
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun <T> AppDropdownMenuItems(
    items: List<T>,
    labelRes: (T) -> Int,
    onSelected: (T) -> Unit
) {
    items.forEach { item ->
        DropdownMenuItem(
            text = { Text(stringResource(labelRes(item))) },
            onClick = { onSelected(item) }
        )
    }
}
