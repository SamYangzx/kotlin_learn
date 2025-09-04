package com.example.kotlinlearn.util

import android.util.Log

/**
 * 自定义日志工具类
 * 支持打印代码行数、方法名、文件名，仅在 Debug 模式下输出日志
 */
object LogUtil {

    private const val DEFAULT_TAG_NAME = "yzx"
    private const val MAX_LOG_LENGTH = 4000  // Android 单条 Logcat 日志最大长度

    // 是否启用日志打印（仅在 Debug 模式下打印）
    private val isDebugEnabled = true;

    /**
     * 默认 TAG 为调用者类名
     */
    fun d(message: String) {
        log(Log.DEBUG, null, message, getCallerInfo())
    }

    fun e(message: String) {
        log(Log.ERROR, null, message, getCallerInfo())
    }

    fun i(message: String) {
        log(Log.INFO, null, message, getCallerInfo())
    }

    fun w(message: String) {
        log(Log.WARN, null, message, getCallerInfo())
    }

    /**
     * 可自定义 TAG
     */
    fun d(tag: String, message: String) {
        log(Log.DEBUG, tag, message, getCallerInfo())
    }

    fun e(tag: String, message: String) {
        log(Log.ERROR, tag, message, getCallerInfo())
    }

    fun i(tag: String, message: String) {
        log(Log.INFO, tag, message, getCallerInfo())
    }

    fun w(tag: String, message: String) {
        log(Log.WARN, tag, message, getCallerInfo())
    }

    /**
     * 核心日志打印方法
     */
    private fun log(priority: Int, tag: String?, message: String, callerInfo: CallerInfo?) {
        if (!isDebugEnabled) return

        val finalTag = tag ?: callerInfo?.className ?: DEFAULT_TAG_NAME
        val logMessage = buildLogMessage(callerInfo, message)

        // Logcat 单条日志有长度限制，超长需拆分打印
        if (logMessage.length < MAX_LOG_LENGTH) {
            Log.println(priority, finalTag, logMessage)
        } else {
            // 拆分长日志（简单处理，按长度切分）
            var index = 0
            while (index < logMessage.length) {
                val end = minOf(index + MAX_LOG_LENGTH, logMessage.length)
                Log.println(priority, finalTag, logMessage.substring(index, end))
                index = end
            }
        }
    }

    /**
     * 构造日志信息，包含调用位置信息
     */
    private fun buildLogMessage(callerInfo: CallerInfo?, message: String): String {
        return if (callerInfo != null) {
            // 格式：[文件名:行号 方法名] → 消息
//            "[${callerInfo.fileName}:${callerInfo.lineNumber} ${callerInfo.methodName}] → $message"
            "[${callerInfo.methodName}:${callerInfo.lineNumber}] $message"
        } else {
            message
        }
    }

    /**
     * 获取调用者信息：类名、方法名、行号、文件名
     * 注意：由于 JVM 内联优化，可能需要关闭某些优化或使用 @JvmInline 等技巧，这里提供常用可靠方式
     */
    private fun getCallerInfo(): CallerInfo? {
        val elements = Thread.currentThread().stackTrace
        // 常见调用栈结构（不同 Kotlin/Java 版本可能略有不同）
        // 0: getStackTrace
        // 1: getCallerInfo()
        // 2: log() 方法
        // 3: d(), e() 等公开方法
        // 4: 用户调用处（我们需要的调用者）

        for (i in 4 until elements.size) {
            val element = elements[i]
            val className = element.className
            // 过滤掉本工具类自己的调用栈，找到真正的调用者
            if (className != LogUtil::class.java.name && !className.startsWith("android.") &&
                !className.startsWith("java.") && !className.startsWith("kotlin.")
            ) {
                val simpleClassName = className.substringAfterLast('.')
                val methodName = element.methodName
                val fileName = element.fileName ?: "Unknown"
                val lineNumber = element.lineNumber

                return CallerInfo(
                    className = simpleClassName,
                    methodName = methodName,
                    fileName = fileName,
                    lineNumber = lineNumber
                )
            }
        }
        return null
    }

    /**
     * 调用者信息数据类
     */
    private data class CallerInfo(
        val className: String,
        val methodName: String,
        val fileName: String,
        val lineNumber: Int
    )
}