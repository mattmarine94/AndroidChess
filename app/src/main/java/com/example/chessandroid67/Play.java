package com.example.chessandroid67;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageButton;

public class Play extends AppCompatActivity implements View.OnClickListener {

    int player = 2;
    int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        ImageButton[][] tiles = new ImageButton[8][8];
        for(int r = 0; r <= 7; r++) {
            for (int c = 0; c <= 7; c++) {
                String bID = "t" + r + "" + c;
                int resID = getResources().getIdentifier(bID, "id", getPackageName());
                tiles[r][c] = (ImageButton) findViewById(resID);
                tiles[r][c].setTag(bID);
                tiles[r][c].setOnClickListener(this);
            }
        }

    }
    @Override
    public void onClick(View v){
        TextView playerMove = findViewById(R.id.playerMove);

        playerMove.setText(v.getTag().toString());
    }
}
