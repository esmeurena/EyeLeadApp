package org.tensorflow.lite.examples.detection

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class WhatActivity : AppCompatActivity() {

    private lateinit var displayText : TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what)

        displayText = findViewById(R.id.Output)

        speechOutput()
    }

    private fun speechOutput(){
        val micAct = MicrophoneActivity()
        micAct.what()
    }

    @SuppressLint("QueryPermissionsNeeded") //this may cause problems later, we'll see
    fun getSpeechInput(v: View){
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

        if(intent.resolveActivity(packageManager) != null)
            startActivityForResult(intent, 10)
        else
            Toast.makeText(this, "your device doesn't support: SPEECH INPUT", Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            10 ->
                if(resultCode == Activity.RESULT_OK && data != null) {
                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    displayText.text = result!![0]
                    val intent = Intent(this,
                            Class.forName("org.tensorflow.lite.examples.detection.DetectorActivity"))
                    startActivity(intent)
                }
        }
    }
}