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
    MediaPlayer currentSound;
    int[] sounds;
    int[] soundsNames;
    int currentIndex = 0;
    int currentNameIndex = 0;
    private static String TAG = "LOGGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sounds = new int[] {R.raw.rain, R.raw.sea, R.raw.birds};
        soundsNames = new int[] {R.string.soundNameRain,
                                 R.string.soundNameSea,
                                 R.string.soundNameBirds};

        currentSound = MediaPlayer.create(this, sounds[currentIndex]);

        Button nextButton = (Button) findViewById(R.id.nextButton);
        Button prevButton = (Button) findViewById(R.id.prevButton);
        Button playButton = (Button) findViewById(R.id.playStopButton);
        final TextView playNow = (TextView) findViewById(R.id.playingNow);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.nextButton:
                        if (currentNameIndex<sounds.length - 1){currentNameIndex++;}
                        else currentNameIndex = 0;
                        Log.i(TAG, String.valueOf(currentNameIndex));
                        playNow.setText(soundsNames[currentNameIndex]);
                        break;

                    case R.id.prevButton:
                        if (currentNameIndex>0){currentNameIndex--;}
                        else currentNameIndex = soundsNames.length - 1;
                        Log.i(TAG, String.valueOf(currentNameIndex));
                        playNow.setText(soundsNames[currentNameIndex]);
                        break;

                    case R.id.playStopButton:
                        if(currentSound.isPlaying()){
                            currentSound.pause();
                            Log.d(TAG, "Stop");
                        }
                        else{
                            currentSound.start();
                            currentSound.setLooping(true);
                            Log.d(TAG, "Starting + Looping");
                        }
                        break;
                }
            }
        };

    Log.i(TAG, "App ready");
    nextButton.setOnClickListener(listener);
    prevButton.setOnClickListener(listener);
    playButton.setOnClickListener(listener);
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Log.d(TAG, "Setting works Fine");
                return true;
            case R.id.about:
                Log.d(TAG, "About works Fine");
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
