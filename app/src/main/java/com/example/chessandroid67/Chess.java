package com.example.chessandroid67;

import android.widget.ImageButton;

public class Chess {

    public static String game(Board chessboard, int i, int j, int p, int q, String color, Prev lastMove, ImageButton tiles[][]) {
        String ret = null;
        Tile board[][] = chessboard.board;
        boolean isCheck = false;
        boolean isCheckmate = false;


        if (color.equals("white")) {
            //player white
            isCheck = whiteInCheck(board, lastMove);
        }
        else if (color.equals("black")) {
            //player Black
            isCheck = blackInCheck(board, lastMove);
        }
            //get piece

            if (board[i][j].hasPiece() == false) {
                return null;
            }

            String name = board[i][j].getPiece().toString().trim();

            if (board[i][j].getPiece().isLegal(board, lastMove, color, name, i, j, p, q) == true) {

                if (board[p][q].hasPiece()) {
                    if (board[p][q].getPiece().getPlayer() == board[i][j].getPiece().getPlayer()) {
                        return null;
                    }
                }

                Piece temp = null;
                boolean check = board[p][q].hasPiece();
                if (check == true) {
                    temp = board[p][q].getPiece();
                    board[p][q].setPiece(board[i][j].getPiece());
                    board[i][j].removePiece();
                }
                if (check == false) {
                    board[p][q].setPiece(board[i][j].getPiece());
                    board[i][j].removePiece();

                }


                    if (color.charAt(0) == 'w') {
                        if (whiteInCheck(board, lastMove) == true) {
                            if (check == false) {
                                board[i][j].setPiece(board[p][q].getPiece());
                                board[p][q].removePiece();
                            }
                            else {
                                board[i][j].setPiece(board[p][q].getPiece());
                                board[p][q].setPiece(temp);
                            }
                            return null;
                        }
                    } else if (color.charAt(0) == 'b') {
                        if (blackInCheck(board, lastMove) == true) {
                            if (check == false) {
                                board[i][j].setPiece(board[p][q].getPiece());
                                board[p][q].removePiece();
                            } else {
                                board[i][j].setPiece(board[p][q].getPiece());
                                board[p][q].setPiece(temp);
                            }
                            return null;
                        }
                    }
                    //removes pawn from en passant
                    if (board[p][q].getPiece().toString().charAt(1) == 'P') {
                        if (i + 1 == p && j + 1 == q && board[i][j + 1].hasPiece() && color.charAt(0) == 'w') {
                            if (board[i][j + 1].getPiece().toString().charAt(1) == 'P' && board[i][j + 1].getPiece().toString().charAt(0) == 'b' && lastMove.getRow() != -1) {
                                if (lastMove.getLastMove().equals(board[i][j + 1].getPiece()) && lastMove.getRow() - lastMove.getNewrow() == 2) {
                                    board[i][j + 1].removePiece();
                                    tiles[i][j+1].setForeground(null);
                                }
                            }
                        }
                        if (i + 1 == p && j - 1 == q && board[i][j - 1].hasPiece() && color.charAt(0) == 'w') {
                            if (board[i][j - 1].getPiece().toString().charAt(1) == 'P' && board[i][j - 1].getPiece().toString().charAt(0) == 'b' && lastMove.getRow() != -1) {
                                if (lastMove.getLastMove().equals(board[i][j - 1].getPiece()) && lastMove.getRow() - lastMove.getNewrow() == 2) {
                                    board[i][j-1].removePiece();
                                    tiles[i][j-1].setForeground(null);
                                }
                            }
                        }
                        if (i - 1 == p && j + 1 == q && board[i][j + 1].hasPiece() && color.charAt(0) == 'b') {
                            if (board[i][j + 1].getPiece().toString().charAt(1) == 'P' && board[i][j + 1].getPiece().toString().charAt(0) == 'w' && lastMove.getRow() != -1) {
                                if (lastMove.getLastMove().equals(board[i][j + 1].getPiece()) && lastMove.getNewrow() - lastMove.getRow() == 2) {
                                    board[i][j + 1].removePiece();
                                    tiles[i][j+1].setForeground(null);
                                }
                            }
                        }
                        if (i - 1 == p && j - 1 == q && board[i][j - 1].hasPiece() && color.charAt(0) == 'b') {
                            if (board[i][j - 1].getPiece().toString().charAt(1) == 'P' && board[i][j - 1].getPiece().toString().charAt(0) == 'w' && lastMove.getRow() != -1) {
                                if (lastMove.getLastMove().equals(board[i][j - 1].getPiece()) && lastMove.getNewrow() - lastMove.getRow() == 2) {
                                    board[i][j-1].removePiece();
                                    tiles[i][j-1].setForeground(null);
                                }
                            }
                        }
                    }
                if (board[p][q].getPiece().toString().charAt(1) == 'P' && color.charAt(0) == 'w' && p == 7) {
                   ret = "promotion";
                   return ret;
                }
                if (board[p][q].getPiece().toString().charAt(1) == 'P' && color.charAt(0) == 'b' && p == 0) {
                    ret = "promotion";
                    return ret;
                }
                //checkmate and check
                if(color.equals("white")){
                    //player white
                    isCheck = blackInCheck(board, lastMove);
                    isCheckmate = checkmate(board, lastMove, "black");

                    if(isCheck == true) {
                        //look for checkmate
                        if(isCheckmate == false) {
                            lastMove.setLastMove(board[p][q].getPiece(), i, p);
                            return "check";
                        }
                    }
                    if(isCheckmate == true) {
                        return "checkmate";
                    }
                }
                if(color.equals("black")){
                    //player white
                    isCheck = whiteInCheck(board, lastMove);
                    isCheckmate = checkmate(board, lastMove, "white");

                    if(isCheck == true) {
                        //look for checkmate
                        if(isCheckmate == false) {
                            lastMove.setLastMove(board[p][q].getPiece(), i, p);
                            return "check";
                        }
                    }
                    if(isCheckmate == true) {
                        return "checkmate";
                    }
                }

                lastMove.setLastMove(board[p][q].getPiece(), i, p);
                //successful move
                ret = "move";
                return ret;

            }

            return null;
        }
    public static boolean checkmate(Tile[][] board, Prev lastMove, String color) {

        boolean check = true;

        if(color.charAt(0) == 'w') {

            for(int r = 0; r < 8; r++) {
                for(int c = 0; c < 8; c++) {
                    if(board[r][c].hasPiece()) {
                        if(board[r][c].getPiece().toString().charAt(0) == 'w') {

                            if(board[r][c].getPiece().checkWhiteMovement(board, lastMove, color, r, c, check) == false) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
        if(color.charAt(0) == 'b') {

            for(int r = 0; r < 8; r++) {
                for(int c = 0; c < 8; c++) {
                    if(board[r][c].hasPiece()) {
                        if(board[r][c].getPiece().toString().charAt(0) == 'b') {

                            if(board[r][c].getPiece().checkBlackMovement(board, lastMove, color, r, c, check) == false) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
        /**
         * method used to change a pawn to an other piece of the same color
         */

        public static boolean whiteInCheck (Tile[][]board, Prev lastMove){

            int p = 0;
            int q = 0;
            boolean move = false;
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    if (board[r][c].hasPiece()) {
                        if (board[r][c].getPiece().toString().charAt(1) == 'K' && board[r][c].getPiece().toString().charAt(0) == 'w') {
                            p = r;
                            q = c;
                        }
                    }
                }
            }
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    if (board[r][c].hasPiece()) {
                        if (board[r][c].getPiece().toString().charAt(0) == 'b') {
                            String name = board[r][c].getPiece().toString();

                            move = board[r][c].getPiece().isLegal(board, lastMove, "black", name, r, c, p, q);

                            if (move == true) {
                                return true;
                            }
                        }
                    }

                }
            }
            return move;
        }
        public static boolean blackInCheck (Tile[][]board, Prev lastMove){

            int p = 0;
            int q = 0;
            boolean move = false;
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    if (board[r][c].hasPiece()) {
                        if (board[r][c].getPiece().toString().charAt(1) == 'K' && board[r][c].getPiece().toString().charAt(0) == 'b') {
                            p = r;
                            q = c;
                        }
                    }
                }
            }

            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    if (board[r][c].hasPiece()) {
                        if (board[r][c].getPiece().toString().charAt(0) == 'w') {
                            String name = board[r][c].getPiece().toString();

                            move = board[r][c].getPiece().isLegal(board, lastMove, "white", name, r, c, p, q);

                            if (move == true) {
                                return true;
                            }
                        }
                    }

                }
            }
            return move;
        }
    public static Piece getTempPiece(Board chessboard, int i, int j){
            Tile[][] board = chessboard.board;
            Piece temp = null;
            temp = board[i][j].getPiece();
            return temp;
    }
    public static void resetMoves(Board chessboard, int i, int j, int p, int q, Piece tempP){
        Tile[][] board = chessboard.board;
        board[i][j].setPiece(board[p][q].getPiece());
        board[p][q].removePiece();
        if(tempP != null){
            board[p][q].setPiece(tempP);

        }
    }
    public static String autoMove(Board chessboard, String color, Prev lastMove, ImageButton tiles[][]){
        Tile[][] board = chessboard.board;
        String temp = null;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].hasPiece()){
                    if(board[i][j].getPiece().getPlayer() == 0 && color.equals("white")){
                        for(int p = 0; p < 8; p++){
                            for(int q = 0; q < 8; q++){
                                temp = game(chessboard, i, j, p, q, color, lastMove, tiles);
                                if(temp != null){
                                    String ret = i+""+j+""+p+""+q+temp;
                                    return ret;
                                }
                            }
                        }
                    }
                    else if(board[i][j].getPiece().getPlayer() == 1 && color.equals("black")){
                        for(int p = 0; p < 8; p++){
                            for(int q = 0; q < 8; q++){
                                temp = game(chessboard, i, j, p, q, color, lastMove, tiles);
                                if(temp != null){
                                    String ret = i+""+j+""+p+""+q+temp;
                                    return ret;
                                }
                            }
                        }
                    }
                }

            }
        }
        return null;
    }
}
