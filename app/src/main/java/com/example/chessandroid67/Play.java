package com.example.chessandroid67;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Button;


public class Play extends AppCompatActivity implements View.OnClickListener {

    int player = 2;
    int clickCount = 0;
    int i, j, p, q;
    boolean gameStart = true;
    Board board = new Board();
    ImageButton[][] tiles = new ImageButton[8][8];
    boolean drawReq = false;
    int drawPlay = -1;
    int[] prevMove = new int[4];
    Piece tempP = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        if(gameStart) {
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
        Button resBtn = findViewById(R.id.resBtn);
        Button drawBtn = findViewById(R.id.drawBtn);
        Button undoBtn = findViewById(R.id.undoBtn);
        undoBtn.setTag("undo");
        Button aiBtn = findViewById(R.id.aiBtn);
        aiBtn.setTag("ai");

        undoBtn.setOnClickListener(this);
        aiBtn.setOnClickListener(this);

        //draw and resign from here on
        if(drawPlay > -1 && drawPlay != player){
            drawBtn.setClickable(true);
        }

        resBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Play.this);
                builder.setCancelable(true);
                builder.setTitle("Resignation");
                builder.setMessage("Would you like to resign?");

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Resign", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TextView playerMove = findViewById(R.id.playerMove);
                        resignClicked(playerMove);
                    }
                });
                builder.show();
            }
        });

        drawBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Play.this);
                builder.setCancelable(true);
                if(drawReq == false){
                    builder.setTitle("Draw proposal");
                    builder.setMessage("Would you like to request a Draw?");
                }
                else{
                    builder.setTitle("Draw request from other player");
                    builder.setMessage("would you like to accept the draw request?");
                }
                builder.setNegativeButton("Reject", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TextView badMove = findViewById(R.id.badMove);
                        dialog.cancel();
                        drawPlay = -1;
                        drawReq = false;
                        Button drawBtn = findViewById(R.id.drawBtn);
                        String dr = "DRAW";
                        badMove.setText(null);
                        drawBtn.setText(dr);
                        drawBtn.setBackgroundResource(android.R.drawable.btn_default);
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                              drawClicked();
                    }
                });
                builder.show();
            }
        });
    }



    @Override
    public void onClick(View v){
        TextView badMove = findViewById(R. id.badMove);
        TextView playerMove = findViewById(R.id.playerMove);
        String moves;

            if(v.getTag().toString().equals("undo")){
                undoClicked();
            }
            else if(v.getTag().toString().equals("ai")){

            }

            else{ //tile was clicked

            if (badMove.getText().toString().equals("Illegal move, try again")) {
                badMove.setText(null);
            }
            if (clickCount < 1) {
                clickCount++;
                i = Integer.parseInt(String.valueOf(v.getTag().toString().charAt(1)));
                j = Integer.parseInt(String.valueOf(v.getTag().toString().charAt(2)));
                String disp = getDisplayMessage((String) playerMove.getText(), v.getTag().toString().substring(1), clickCount);
                playerMove.setText(disp);
            }
            else {
                p = Integer.parseInt(String.valueOf(v.getTag().toString().charAt(1)));
                q = Integer.parseInt(String.valueOf(v.getTag().toString().charAt(2)));
                tempP = com.example.chessandroid67.Chess.getTempPiece(board, p, q);
                if (player % 2 == 0) {
                    moves = com.example.chessandroid67.Chess.game(board, i, j, p, q, "white");
                } else {
                    moves = com.example.chessandroid67.Chess.game(board, i, j, p, q, "black");
                }
                if (moves == null) {//illegal move
                    if (player % 2 == 0) {
                        playerMove.setText(R.string.wMove);
                    } else {
                        playerMove.setText(R.string.bMove);
                    }
                    badMove.setText(R.string.illegal);
                    clickCount = 0;
                } else {//successful move
                    if(drawReq && drawPlay == player){
                        Button drawBtn = findViewById(R.id.drawBtn);
                        drawBtn.setBackgroundResource(android.R.color.holo_green_light);
                        drawBtn.setText(R.string.draw2);
                        String s = "Other player REQUESTED a DRAW";
                        badMove.setText(s);
                        drawBtn.setClickable(true);
                    }
                    else{
                        drawPlay = -1;
                        Button drawBtn = findViewById(R.id.drawBtn);
                        String dr = "DRAW";
                        badMove.setText(null);
                        drawBtn.setText(dr);
                        drawBtn.setBackgroundResource(android.R.drawable.btn_default);
                        drawReq = false;
                    }
                    makeMove(v, i, j, p, q, moves);
                    clickCount = 0;
                }
            }}
        }

    public boolean makeMove(View v, int i,int j,int p,int q, String moves){
        ImageButton lastCapture = findViewById(R.id.lastCapture);
        prevMove[0] = i;
        prevMove[1] = j;
        prevMove[2] = p;
        prevMove[3] = q;
        lastCapture.setForeground(tiles[p][q].getForeground());

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

    public void resignClicked(TextView playerMove){

        if(player%2 ==0 ){
            playerMove.setText(R.string.bWin);
        }
        else{
            playerMove.setText(R.string.wWin);
        }

    }
    public void drawClicked(){
        TextView badMove = findViewById(R. id.badMove);
        Button drawBtn = findViewById(R.id.drawBtn);
        TextView playerMove = findViewById(R.id.playerMove);

        if(!drawReq && drawPlay == -1){
            drawReq = true;
            drawPlay = player;
            drawBtn.setText(R.string.pend);
            badMove.setText(R.string.sentreq);
            drawBtn.setClickable(false);
        }
        else if(drawReq && drawPlay > -1){
            playerMove.setText(null);
            playerMove.setText(R.string.draw);

        }

    }
    public void undoClicked(){
        ImageButton lastCapture = findViewById(R.id.lastCapture);
        TextView playerMove = findViewById(R.id.playerMove);

        com.example.chessandroid67.Chess.resetMoves(board, prevMove[0], prevMove[1], prevMove[2], prevMove[3], tempP);
        tiles[i][j].setForeground(tiles[p][q].getForeground());
        tiles[p][q].setForeground(lastCapture.getForeground());

        if(player%2 == 0){
            player--;
            playerMove.setText(R.string.bMove);
        }
        else{
            player++;
            playerMove.setText(R.string.wMove);
        }

    }
    public void aiClicked(){

    }


}
