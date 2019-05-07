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
    int i, j, p, q;
    boolean gameStart = true;
    Board board = new Board();
    ImageButton[][] tiles = new ImageButton[8][8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        if(gameStart == true) {
            board.setBoard();
            gameStart = false;
        }

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
        TextView badMove = findViewById(R.id.badMove);
        String moves;
        if(badMove.getText().toString().equals("Illegal move, try again")){
            badMove.setText(null);
        }
        if(clickCount < 1){
            clickCount++;
            i = Integer.parseInt(String.valueOf(v.getTag().toString().charAt(1)));
            j = Integer.parseInt(String.valueOf(v.getTag().toString().charAt(2)));
            String disp = getDisplayMessage((String) playerMove.getText(), v.getTag().toString().substring(1), clickCount);
            playerMove.setText(disp);
        }
        else{
            p = Integer.parseInt(String.valueOf(v.getTag().toString().charAt(1)));
            q = Integer.parseInt(String.valueOf(v.getTag().toString().charAt(2)));
            if(player%2 == 0){
                moves = com.example.chessandroid67.Chess.game(board, i, j, p, q, "white");
            }
            else{
               moves = com.example.chessandroid67.Chess.game(board, i, j, p, q, "black");
            }
            if(moves == null){//illegal move
                if(player%2 == 0){
                    playerMove.setText(R.string.wMove);
                }
                else{
                    playerMove.setText(R.string.bMove);
                }
                badMove.setText(R.string.illegal);
                clickCount = 0;
            }
            else{//successful move
                makeMove(v, i, j, p, q, moves);
                clickCount = 0;

            }
        }

    }

    public boolean makeMove(View v, int i,int j,int p,int q, String moves){

        ImageButton tile1 = tiles[i][j];
        ImageButton tile2 = tiles[p][q];
        TextView playerMove = findViewById(R.id.playerMove);

        tile2.setForeground(tile1.getForeground());
        tile1.setForeground(null);

        if(player%2==0){
            player--;
            playerMove.setText(R.string.bMove);
        }
        else{
            player++;
            playerMove.setText(R.string.wMove);
        }
        return true;
    }

    public String getDisplayMessage(String a, String b, int count){
        String ret;
        if(clickCount == 1){
            ret = a + ": ";
        }
        else{
          ret = a;
        }
        int temp = Integer.parseInt(String.valueOf(b.charAt(1))) + 1;
        b = b.substring(0, 1) + temp;

        if(b.charAt(0) == '0'){
            b = "a" + b.substring(1);
        }
        if(b.charAt(0) == '1'){
            b = "b" + b.substring(1);
        }
        if(b.charAt(0) == '2'){
            b = "c" + b.substring(1);
        }
        if(b.charAt(0) == '3'){
            b = "d" + b.substring(1);
        }
        if(b.charAt(0) == '4'){
            b = "e" + b.substring(1);
        }
        if(b.charAt(0) == '5'){
            b = "f" + b.substring(1);
        }
        if(b.charAt(0) == '6'){
            b = "g" + b.substring(1);
        }
        if(b.charAt(0) == '7'){
            b = "h" + b.substring(1);
        }

        ret = ret + b + " -> ";
        return ret;
    }

}
