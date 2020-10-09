package com.example.pruebaenlacegs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {
    private final int DURACION_SPLASH = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ImageView image=findViewById(R.id.imageSplash);
        final String URL = "https://scontent.fsal1-1.fna.fbcdn.net/v/t1.0-9/118734704_3237214066325519_6827733383315861794_n.jpg?_nc_cat=100&_nc_sid=09cbfe&_nc_ohc=MzZ46uos6t4AX_2Y8g7&_nc_ht=scontent.fsal1-1.fna&oh=34abf2bb81129997ced089fbfd521a3e&oe=5FA40F6D";

        Glide.with(this)
                .load(URL)
                .error(R.drawable.enlace)
                .into(image);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }
}
