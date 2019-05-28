package com.freetek.freeapp.greatgriotapp.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.freetek.freeapp.greatgriotapp.R;
import java.io.IOException;


public class ListenToAudioBook extends AppCompatActivity {

    private TextView name, chapterNo;

    private ImageView image, play, forward, backward;
    private SeekBar seek;

    private String key, chapter, bookName, url;

    MediaPlayer mediaPlayer;

    ProgressDialog dialog;

    private Runnable runnable;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_to_audio_book);


        Bundle bundle = getIntent().getExtras();
        key = bundle.getString("Key");
        chapter = bundle.getString("Chapter");
        bookName = bundle.getString("Book");
        url = bundle.getString("Url");


        name = (TextView) findViewById(R.id.name);
        chapterNo = (TextView) findViewById(R.id.chapterNo);

        image = (ImageView) findViewById(R.id.image);
        play = (ImageView) findViewById(R.id.play);
        forward = (ImageView) findViewById(R.id.forward);
        backward = (ImageView) findViewById(R.id.backward);

        seek = (SeekBar) findViewById(R.id.seek);

        dialog = ProgressDialog.show(this, "", "Loading. Please wait...", true);



        chapterNo.setText(chapter);
        name.setText(bookName);

        loadImage();


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    
                    changeSeekbar();

                    play.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                }else{
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.ic_play_circle_filled_black_24dp);
                }
            }
        });




        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {

            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    dialog.dismiss();

                    //seekbar
                    seek.setMax(mediaPlayer.getDuration());
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 20000);
            }
        });
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 20000);
            }
        });
    }

    private void changeSeekbar() {
        seek.setProgress(mediaPlayer.getCurrentPosition());

        if(mediaPlayer.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable, 1000);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_back_button, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.back_button:

                //back button has been pressed take user to main activity
                Intent main = new Intent(ListenToAudioBook.this, AudioBooksCategories.class);
                startActivity(main);
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void loadImage(){

    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

}
