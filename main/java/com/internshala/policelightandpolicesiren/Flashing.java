package com.internshala.policelightandpolicesiren;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

import static android.view.animation.Animation.REVERSE;

public class Flashing extends AppCompatActivity {

    ImageView imageViewPoliceFlashing;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashing);
        getSupportActionBar().hide();

        imageViewPoliceFlashing = (ImageView)findViewById(R.id.imageViewActivity);
        startsiren();
        startLights();
    }

    public  void startsiren()
    {
        mediaPlayer = MediaPlayer.create(this,R.raw.police_siren);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }
    @SuppressLint("WrongConstant")
    public void startLights()
    {
        ObjectAnimator anim = ObjectAnimator.ofInt(imageViewPoliceFlashing,"BackgroundColor",Color.RED, Color.BLUE);

        anim.setDuration(120);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
    }

    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        super.onBackPressed();
    }
}
