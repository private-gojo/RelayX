package dev.relayx.core.ui.shortcut
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import dev.relayx.core.core.CoreServiceManager
import dev.relayx.core.core.LauncherManager
import dev.relayx.core.ui.base.BaseComponentActivity

class ScSwitchActivity : BaseComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Composable
    override fun ScreenContent() {
        LaunchedEffect(Unit) {
            moveTaskToBack(true)
            if (CoreServiceManager.isRunning()) {
                LauncherManager.stopService(this@ScSwitchActivity)
            } else {
                LauncherManager.startServiceFromToggle(this@ScSwitchActivity)
            }
            finish()
        }
    }
}
