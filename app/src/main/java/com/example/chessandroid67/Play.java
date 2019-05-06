package com.example.chessandroid67;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Play extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        TextView playerMove = findViewById(R.id.playerMove);
        playerMove.setText(R.string.wMove);
    }
}
