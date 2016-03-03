package com.company.predator.aurasound;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mySound;
    private static String TAG;

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

    public boolean onOptionsItemSelected(MenuItem item) {
//        TextView playNow = (TextView) findViewById(R.id.playingNow);
        switch (item.getItemId()){
            case R.id.settings:
//                playNow.setText("Settings option");
                Log.d(TAG, "Setting works Fine");

                return true;
            case R.id.about:
//                playNow.setText("About option");
                Log.d(TAG, "About works Fine");
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
