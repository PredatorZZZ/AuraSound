package com.company.predator.aurasound;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mySound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySound = MediaPlayer.create(this, R.raw.rain);
        Button nextButton = (Button) findViewById(R.id.nextButton);
        Button prevButton = (Button) findViewById(R.id.prevButton);
        Button playButton = (Button) findViewById(R.id.playStopButton);
        TextView playNow = (TextView) findViewById(R.id.playingNow);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.nextButton:
                        break;
                    case R.id.prevButton:
                        break;
                    case R.id.playStopButton:
                        mySound.start();
                        break;
                }

            }
        };
    nextButton.setOnClickListener(listener);
    prevButton.setOnClickListener(listener);
    playButton.setOnClickListener(listener);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
