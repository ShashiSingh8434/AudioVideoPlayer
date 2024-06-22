package com.example.audiovideoplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final String MSG = "com.example.audiovideoplayer,MSG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void audioIntent(View view){
        Intent intent = new Intent(this,AudioPlayer.class);
        EditText editText = findViewById(R.id.name);
        String send = editText.getText().toString();
        intent.putExtra(MSG,send);
        startActivity(intent);
    }
    public void videoIntent(View view){
        Intent intent = new Intent(this,VideoPlayer.class);
        EditText editText = findViewById(R.id.name);
        String send = editText.getText().toString();
        intent.putExtra(MSG,send);
        startActivity(intent);
    }
}