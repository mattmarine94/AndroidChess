package com.example.chessandroid67;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Watch extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        TextView showLog = findViewById(R.id.showlog);

        Intent intent = getIntent();
        ArrayList<String> logMoves = intent.getStringArrayListExtra("logOfMoves");

        String s;
        if (logMoves == null) {
            s = "nothing found";
        } else {
            s = logMoves.get(0);
        }
        showLog.setText(s);

        Button nextBtn = findViewById(R.id.nextBtn);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
