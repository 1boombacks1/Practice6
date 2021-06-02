package ru.mirea.nikolaev.notebook

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.security.KeyPair

class MainActivity : AppCompatActivity() {

    private lateinit var editTextFileName: EditText
    private lateinit var editTextContent: EditText
    private lateinit var preferences: SharedPreferences
    val KEY_PATH = "last_file"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextFileName = findViewById(R.id.editTextFileName)
        editTextContent = findViewById(R.id.editTextContent)
        preferences = getPreferences(MODE_PRIVATE)

        if (preferences.getString(KEY_PATH,"") != "")
            getInfoFromLastFile()

    }

    fun onClickSave(view: View){
        val fileName = editTextFileName.text.toString()
        val content = editTextContent.text.toString()
        val file = File(application.filesDir, fileName)

        FileOutputStream(file).use {
            it.write(content.toByteArray())
        }
        preferences.edit().putString(KEY_PATH,fileName).apply()
    }

    fun getInfoFromLastFile(){
        val fileName = preferences.getString(KEY_PATH,"") as String
        val file = File(application.filesDir, fileName)
        val content = FileInputStream(file).bufferedReader().use { it.readText() }

        editTextFileName.setText(fileName)
        editTextContent.setText(content)
    }
}