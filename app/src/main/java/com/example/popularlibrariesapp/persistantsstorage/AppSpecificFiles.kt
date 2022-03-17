package com.example.popularlibrariesapp.persistantsstorage

import android.content.Context
import android.os.Build
import android.os.storage.StorageManager
import android.util.Log
import androidx.core.content.getSystemService
import java.io.File

fun appSpecificFiles(context: Context) {
    val content = "ГикБрейнс"
    val fileName = "gb.txt"

    val file = File(context.cacheDir, fileName)

    file.outputStream().use { stream ->
        stream.write(content.toByteArray())
        Log.d("Files", "Запись файла успешно завершена")
    }

    file.inputStream().use {
        Log.d("Files", "Чтение файла: ${it.readBytes().toString(Charsets.UTF_8)}")
    }

    // Storage Manager
    val storageManager = context.getSystemService<StorageManager>()!!
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val filesDirSize = storageManager.getAllocatableBytes(storageManager.getUuidForPath(context.filesDir))
        Log.d("Files", "Размер filesDir: $filesDirSize")
    }

}