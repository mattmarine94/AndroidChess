package com.example.chessandroid67;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPLay =  findViewById(R.id.btnPlay);
        Button btnWatch = findViewById(R.id.btnWatch);

        btnPLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToPlay = new Intent(getApplicationContext(), Play.class);
                startActivity(goToPlay);
            }
        });

        btnWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLog = new Intent(getApplicationContext(), Logs.class);
                startActivity(goToLog);
            }
        });
    }
}
