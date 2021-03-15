/*********************************************************************
MIT License

Copyright (c) 2021 EyeLead

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

************************************************************************/
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

class MicActivity : AppCompatActivity() {

    private lateinit var displayText : TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mic)

        displayText = findViewById(R.id.Output)

        speechOutput()
    }

    private fun speechOutput(){
        val micAct = MicrophoneActivity()
        micAct.specific()
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
                    if(displayText.text == "no"){
                        val intent = Intent(this,
                                Class.forName("org.tensorflow.lite.examples.detection.DetectorActivity"))
                        startActivity(intent)
                    }
                    if(displayText.text == "yes"){
                        val intent = Intent(this,
                                Class.forName("org.tensorflow.lite.examples.detection.WhatActivity"))
                        startActivity(intent)
                    }
                }
        }
    }
}
