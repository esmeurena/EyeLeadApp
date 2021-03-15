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
