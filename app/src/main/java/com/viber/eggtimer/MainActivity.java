package com.viber.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SeekBar seekBar;
    public void buttonClicked(View view){
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        new CountDownTimer(seekBar.getProgress()*1000+100, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int)millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                Log.i("finish","timer all done");
            }
        }.start();
    }

    public void updateTimer(int secsLeft){
        textView=textView = (TextView) findViewById(R.id.textView);
        int mins=secsLeft/60;
        int secs=secsLeft-(mins*60);
        String timeTEx;
        String secsString = Integer.toString(secs);
        if (secs<=9){
            secsString="0"+secsString;
        }
        timeTEx=mins+":"+secsString;
        textView.setText(timeTEx);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        TextView textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        seekBar.setMax(600);
        seekBar.setProgress(30);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}