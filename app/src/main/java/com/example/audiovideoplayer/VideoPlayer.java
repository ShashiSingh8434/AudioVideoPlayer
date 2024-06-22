package com.example.audiovideoplayer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VideoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video_player);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.MSG);
        TextView textView = findViewById(R.id.videoIntro);
        textView.setText("Welcome! " + name);

        VideoView videoView = findViewById(R.id.alphaVideo);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.roar);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.alphaVideo), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}