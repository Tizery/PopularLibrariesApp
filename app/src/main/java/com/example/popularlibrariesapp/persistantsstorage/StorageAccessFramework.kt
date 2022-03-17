package com.example.popularlibrariesapp.persistantsstorage

import android.graphics.BitmapFactory
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts

fun storageAccessFramework(activity: ComponentActivity) {
    val getContent = activity.registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->

        uri ?: return@registerForActivityResult

        val parcelFileDescriptor = activity.contentResolver.openFileDescriptor(uri, "r")
        val fileDescriptor = parcelFileDescriptor?.fileDescriptor
        val bmp = BitmapFactory.decodeFileDescriptor(fileDescriptor)
        Log.d("SAF", "URI выбранного файла: $uri, размер: ${bmp.width}x${bmp.height}")
    }
    getContent.launch(arrayOf("*/*"))
}