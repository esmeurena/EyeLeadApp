package org.tensorflow.lite.examples.detection;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechSynthesizer;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;

public class MicrophoneActivity {
    public void main() {
        SpeechConfig speechConfig = SpeechConfig.fromSubscription("17446fa9300740eda8b6f7dfd3383903", "eastus");
        AudioConfig audioConfig = AudioConfig.fromDefaultSpeakerOutput();

        SpeechSynthesizer synthesizer = new SpeechSynthesizer(speechConfig, audioConfig);
        synthesizer.SpeakText("Hi! Welcome to EyeLead.");
    }

    void userProfile(){
        SpeechConfig speechConfig = SpeechConfig.fromSubscription("17446fa9300740eda8b6f7dfd3383903", "eastus");
        AudioConfig audioConfig = AudioConfig.fromDefaultSpeakerOutput();

        SpeechSynthesizer synthesizer = new SpeechSynthesizer(speechConfig, audioConfig);
        synthesizer.SpeakText("Please say your name to create your profile.");
    }

    void specific(){
        SpeechConfig speechConfig = SpeechConfig.fromSubscription("17446fa9300740eda8b6f7dfd3383903", "eastus");
        AudioConfig audioConfig = AudioConfig.fromDefaultSpeakerOutput();

        SpeechSynthesizer synthesizer = new SpeechSynthesizer(speechConfig, audioConfig);
        synthesizer.SpeakText("Are you looking for something specific?");
    }

    void what(){
        SpeechConfig speechConfig = SpeechConfig.fromSubscription("17446fa9300740eda8b6f7dfd3383903", "eastus");
        AudioConfig audioConfig = AudioConfig.fromDefaultSpeakerOutput();

        SpeechSynthesizer synthesizer = new SpeechSynthesizer(speechConfig, audioConfig);
        synthesizer.SpeakText("What are you looking for?");
    }
}
