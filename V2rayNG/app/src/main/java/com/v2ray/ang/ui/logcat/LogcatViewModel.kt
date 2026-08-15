package dev.relayx.core.ui.logcat
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

import android.app.Application
import dev.relayx.core.AppConfig
import dev.relayx.core.R
import dev.relayx.core.ui.base.BaseViewModel
import dev.relayx.core.util.LogUtil
import dev.relayx.core.util.Utils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException

class LogcatViewModel(application: Application) : BaseViewModel(application) {
    private val logsetsAll: MutableList<String> = mutableListOf()
    private var currentFilter: String = ""
    private var currentLevelFilter: Char? = null

    private val _filteredLogs = MutableStateFlow<List<String>>(emptyList())
    val filteredLogs: StateFlow<List<String>> = _filteredLogs.asStateFlow()

    fun loadLogcat() {
        launchLoading {
            try {
                val lst = LinkedHashSet<String>()
                lst.add("logcat")
                lst.add("-d")
                lst.add("-v")
                lst.add("time")
                lst.add("-s")
                lst.add("GoLog,${AppConfig.ANG_PACKAGE},AndroidRuntime,System.err")
                val process = Runtime.getRuntime().exec(lst.toTypedArray())
                val allText = process.inputStream.bufferedReader().use { it.readLines() }.reversed()

                logsetsAll.clear()
                logsetsAll.addAll(allText)
                applyFilter()
            } catch (e: Exception) {
                LogUtil.e(AppConfig.TAG, "Failed to get logcat", e)
            }
        }
    }

    fun copyLogcat() {
        val all = filteredLogs.value.joinToString("\n")
        Utils.setClipboard(app, all)
        toast(R.string.toast_success)
    }

    fun clearLogcat() {
        try {
            val lst = LinkedHashSet<String>()
            lst.add("logcat")
            lst.add("-c")
            val process = Runtime.getRuntime().exec(lst.toTypedArray())
            process.waitFor()

            logsetsAll.clear()
            _filteredLogs.value = emptyList()
        } catch (e: Exception) {
            LogUtil.e(AppConfig.TAG, "Failed to clear logcat", e)
        }
    }

    fun filterByLevel(level: Char?) {
        currentLevelFilter = level
        applyFilter()
    }

    fun filter(content: String?) {
        currentFilter = content?.trim() ?: ""
        applyFilter()
    }

    private fun applyFilter() {
        var result: List<String> = logsetsAll
        if (currentLevelFilter != null) {
            result = result.filter { line ->
                val slashIndex = line.indexOf('/')
                slashIndex > 0 && line[slashIndex - 1] == currentLevelFilter
            }
        }
        if (currentFilter.isNotEmpty()) {
            result = result.filter { it.contains(currentFilter) }
        }
        _filteredLogs.value = result
    }
}