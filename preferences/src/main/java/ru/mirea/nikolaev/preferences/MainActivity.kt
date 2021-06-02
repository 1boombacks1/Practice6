package ru.mirea.nikolaev.preferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var preferences: SharedPreferences
    val SAVED_TEXT = "saved_text"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        preferences =  getPreferences(MODE_PRIVATE)
    }

    fun onClickSave(view: View){
        val editor = preferences.edit()
        editor.putString(SAVED_TEXT, editText.text.toString())
        editor.apply()
        Toast.makeText(this,"Сохранено!", Toast.LENGTH_SHORT).show()
    }

    fun onClickLoad(view: View){
        val text = preferences.getString(SAVED_TEXT, "Empty")
        textView.text = text
    }
}