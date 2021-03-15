package org.tensorflow.lite.examples.detection

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.click)

        image.setOnClickListener{
            val intent = Intent(this,
                    Class.forName("org.tensorflow.lite.examples.detection.LoginActivity"))
            startActivity(intent)
        }

        speechOutput()
    }

    private fun speechOutput(){
        val micAct = MicrophoneActivity()
        micAct.main()
    }
}
