package com.example.popularlibrariesapp.persistantsstorage

import android.content.Context
import android.util.Log
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

}