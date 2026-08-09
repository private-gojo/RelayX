package dev.relayx.core.ui

import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

import android.os.Bundle
import android.webkit.WebView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import dev.relayx.core.AppConfig
import dev.relayx.core.BuildConfig
import dev.relayx.core.R
import dev.relayx.core.core.CoreNativeManager
import dev.relayx.core.ui.base.BaseComponentActivity
import dev.relayx.core.ui.compose.AppTopBar
import dev.relayx.core.ui.compose.SettingsMenuItem
import dev.relayx.core.ui.compose.VersionInfoBlock
import dev.relayx.core.util.Utils

class AboutActivity : BaseComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Composable
    override fun ScreenContent() {
        AboutScreen(onBackClick = { finish() })
    }
}

@Composable
fun ExpandableMenuItem(
    icon: Painter? = null,
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(if (expanded) 180f else 0f, label = "arrowRotation")

    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.height(24.dp).width(24.dp),
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(R.drawable.ic_expand_more_24dp),
                contentDescription = null,
                modifier = Modifier
                    .height(24.dp).width(24.dp)
                    .graphicsLayer { rotationZ = rotation }
            )
        }
        AnimatedVisibility(visible = expanded) {
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(start = 56.dp, end = 16.dp, bottom = 16.dp)
            )
        }
    }
}

@Composable
fun NestedExpandableMenuItem(
    icon: Painter? = null,
    title: String,
    items: List<Pair<String, String>>,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(if (expanded) 180f else 0f, label = "arrowRotation")

    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.height(24.dp).width(24.dp),
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(R.drawable.ic_expand_more_24dp),
                contentDescription = null,
                modifier = Modifier
                    .height(24.dp).width(24.dp)
                    .graphicsLayer { rotationZ = rotation }
            )
        }
        AnimatedVisibility(visible = expanded) {
            Column(modifier = Modifier.padding(start = 40.dp)) {
                items.forEach { (subTitle, subContent) ->
                    ExpandableMenuItem(title = subTitle, content = subContent)
                }
            }
        }
    }
}

@Composable
fun AboutScreen(onBackClick: () -> Unit) {
    val context = LocalContext.current
    var showOssDialog by remember { mutableStateOf(false) }
    var showPrivacyDialog by remember { mutableStateOf(false) }

    val libVersion = CoreNativeManager.getLibVersion()
    val versionText = "v${BuildConfig.VERSION_NAME} ($libVersion)"
    val appIdText = BuildConfig.APPLICATION_ID

    Scaffold(
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
        topBar = {
            AppTopBar(
                title = stringResource(R.string.title_about),
                onBackClick = onBackClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            NestedExpandableMenuItem(
                title = "What's New",
                items = listOf(
                    "v1.5" to "Placeholder changelog for v1.5",
                    "v1.4" to "Placeholder changelog for v1.4",
                    "v1.3" to "Placeholder changelog for v1.3",
                    "v1.2" to "Placeholder changelog for v1.2",
                    "v1.1" to "Placeholder changelog for v1.1",
                    "v1.0" to "Placeholder changelog for v1.0"
                )
            )

            SettingsMenuItem(
                icon = painterResource(R.drawable.ic_source_code_24dp),
                title = stringResource(R.string.title_source_code),
                onClick = { Utils.openUri(context, "https://github.com/private-gojo/RelayX") }
            )
            SettingsMenuItem(
                icon = painterResource(R.drawable.license_24px),
                title = stringResource(R.string.title_oss_license),
                onClick = { showOssDialog = true }
            )
            SettingsMenuItem(
                icon = painterResource(R.drawable.ic_privacy_24dp),
                title = stringResource(R.string.title_privacy_policy),
                onClick = { showPrivacyDialog = true }
            )

            NestedExpandableMenuItem(
                title = "Developer",
                items = listOf(
                    "Role" to "Independent Developer & Network Researcher",
                    "Credits" to "Placeholder credits content",
                    "License" to "Placeholder license content",
                    "Community" to "Placeholder community content"
                )
            )

            VersionInfoBlock(
                versionText = versionText,
                appIdText = appIdText
            )
        }

        if (showOssDialog) {
            AlertDialog(
                onDismissRequest = { showOssDialog = false },
                title = { Text(stringResource(R.string.title_oss_license)) },
                text = {
                    AndroidView(
                        factory = { ctx ->
                            WebView(ctx).apply {
                                loadUrl("file:///android_asset/open_source_licenses.html")
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 300.dp)
                    )
                },
                confirmButton = {
                    TextButton(onClick = { showOssDialog = false }) {
                        Text(stringResource(android.R.string.ok))
                    }
                },
                containerColor = MaterialTheme.colorScheme.surface,
                modifier = Modifier.padding(bottom = 60.dp)
            )
        }

        if (showPrivacyDialog) {
            AlertDialog(
                onDismissRequest = { showPrivacyDialog = false },
                title = { Text(stringResource(R.string.title_privacy_policy)) },
                text = {
                    Text(
                        text = "Placeholder privacy policy content.",
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 300.dp)
                    )
                },
                confirmButton = {
                    TextButton(onClick = { showPrivacyDialog = false }) {
                        Text(stringResource(android.R.string.ok))
                    }
                },
                containerColor = MaterialTheme.colorScheme.surface,
                modifier = Modifier.padding(bottom = 60.dp)
            )
        }
    }
}
