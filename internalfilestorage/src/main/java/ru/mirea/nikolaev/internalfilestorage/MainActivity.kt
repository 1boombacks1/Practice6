package ru.mirea.nikolaev.internalfilestorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val fileName = "mirea.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = "Just text for Practice 6"
        val file = File(applicationContext.filesDir, fileName)
        FileOutputStream(file).use {
            it.write(text.toByteArray())
            Log.d("INFO", "Файл записан!")
        }
    }
}