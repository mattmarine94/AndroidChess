package com.example.chessandroid67;

public class Chess {

    public static String game(Board chessboard, int i, int j, int p, int q, String color) {
        String ret = null;
        Prev lastMove = new Prev();
        Tile board[][] = chessboard.board;
        boolean isCheck = false;
        boolean isCheckmate = false;

        if(color.equals("undo")){



            return "undo";
        }


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

            if (name.charAt(1) == 'K' && (q - i == 2 || i - q == 2)) {
                if (isCheck == true) {
                    return null;
                }
            }

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


                if (isCheck == true) {
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
                                }
                            }
                        }
                        if (i + 1 == p && j - 1 == q && board[i][j - 1].hasPiece() && color.charAt(0) == 'w') {
                            if (board[i][j - 1].getPiece().toString().charAt(1) == 'P' && board[i][j - 1].getPiece().toString().charAt(0) == 'b' && lastMove.getRow() != -1) {
                                if (lastMove.getLastMove().equals(board[i][j - 1].getPiece()) && lastMove.getRow() - lastMove.getNewrow() == 2) {
                                    board[i][j + 1].removePiece();
                                }
                            }
                        }
                        if (i - 1 == p && j + 1 == q && board[i][j + 1].hasPiece() && color.charAt(0) == 'b') {
                            if (board[i][j + 1].getPiece().toString().charAt(1) == 'P' && board[i][j + 1].getPiece().toString().charAt(0) == 'w' && lastMove.getRow() != -1) {
                                if (lastMove.getLastMove().equals(board[i][j + 1].getPiece()) && lastMove.getNewrow() - lastMove.getRow() == 2) {
                                    board[i][j + 1].removePiece();
                                }
                            }
                        }
                        if (i - 1 == p && j - 1 == q && board[i][j - 1].hasPiece() && color.charAt(0) == 'b') {
                            if (board[i][j - 1].getPiece().toString().charAt(1) == 'P' && board[i][j - 1].getPiece().toString().charAt(0) == 'w' && lastMove.getRow() != -1) {
                                if (lastMove.getLastMove().equals(board[i][j - 1].getPiece()) && lastMove.getNewrow() - lastMove.getRow() == 2) {
                                    board[i][j + 1].removePiece();
                                }
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
                lastMove.setLastMove(board[p][q].getPiece(), i, p);
                //successful move
                ret = "move";
                return ret;

            }

            return null;
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
                        continue;
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
    }
