package org.tensorflow.lite.examples.detection
import android.content.Intent
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_vr)

        val voiceButton = findViewById<ImageView>(R.id.click)

        speechOutput()
        voiceButton.setOnClickListener{
            val intent = Intent(this,
                    Class.forName("org.tensorflow.lite.examples.detection.MicActivity"))
            startActivity(intent)
        }
    }

    private fun speechOutput(){
        val micAct = MicrophoneActivity()
        micAct.userProfile()
    }
}