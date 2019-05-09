package com.example.chessandroid67;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

public class Watch extends AppCompatActivity  {

    String s;
    int i, j, p, q;
    ImageView[][] tiles = new ImageView[8][8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        TextView showLog = findViewById(R.id.showlog);

        Intent intent = getIntent();
        ArrayList<String> logMoves = intent.getStringArrayListExtra("logOfMoves");

        if (logMoves == null) {
            s = "nothing found";
        } else {
            s = logMoves.get(0);
        }

        for(int r = 0; r <= 7; r++) {
            for (int c = 0; c <= 7; c++) {
                String bID = "w" + r + "" + c;
                int resID = getResources().getIdentifier(bID, "id", getPackageName());
                tiles[r][c] = (ImageView) findViewById(resID);
            }
        }

        Button bList = findViewById(R.id.bList);

        bList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLog = new Intent(getApplicationContext(), Logs.class);
                startActivity(goToLog);
            }
        });

        Button homeP = findViewById(R.id.homeP);

        homeP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goToMain);
            }
        });

        Button nextBtn = findViewById(R.id.nextBtn);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Character.isDigit(s.charAt(0))){

                    i = Integer.parseInt(String.valueOf(s.charAt(0)));
                    j = Integer.parseInt(String.valueOf(s.charAt(1)));
                    p = Integer.parseInt(String.valueOf(s.charAt(2)));
                    q = Integer.parseInt(String.valueOf(s.charAt(3)));

                    s = s.substring(4);

                    makeMove(i, j, p, q);
                }
                else{
                    endGame(s);
                }
            }
        });
    }

    public boolean makeMove(int i,int j,int p,int q){

        ImageView tile1 = tiles[i][j];
        ImageView tile2 = tiles[p][q];


        tile2.setForeground(tile1.getForeground());
        tile1.setForeground(null);


        return true;
    }
    public void endGame(String end){
        Button nextBtn = findViewById(R.id.nextBtn);
        TextView replay = findViewById(R.id.showlog);
        String e = end.substring(s.length()-4);
        end = end.substring(0, s.length()-3);

        replay.setText(end);

        nextBtn.setClickable(false);

    }
}
