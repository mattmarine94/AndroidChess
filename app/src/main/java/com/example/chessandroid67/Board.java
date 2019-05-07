package com.example.chessandroid67;

public class Board {
	private int row = 8;
	private int colomn = 8;
	public Tile[][] board = new Tile[row][colomn];

	public void setBoard() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < colomn; j++) {
				board[i][j] = new Tile();
				board[i][j].setColor(i + j); 
				if(i == 0 && (j == 0 || j == 7)) {
					board[i][j].setPiece(new Rook(0));
				}
				if(i == 0 && (j == 1 || j == 6)) {
					board[i][j].setPiece(new Knight(0));
				}
				if(i == 0 && (j == 2 || j == 5)) {
					board[i][j].setPiece(new Bishop(0));
				}
				if(i == 0 && j == 4) {
					board[i][j].setPiece(new King(0));
				}
				if(i == 0 && j == 3 ) {
					board[i][j].setPiece(new Queen(0));
				}
				if(i == 1) {
					board[i][j].setPiece(new Pawn(0));
				}
				if(i == 6) {
					board[i][j].setPiece(new Pawn(1));
				}
				if(i == 7 && (j == 0 || j == 7)) {
					board[i][j].setPiece(new Rook(1));
				}
				if(i == 7 && (j == 1 || j == 6)) {
					board[i][j].setPiece(new Knight(1));
				}
				if(i == 7 && (j == 2 || j == 5)) {
					board[i][j].setPiece(new Bishop(1));
				}
				if(i == 7 && j == 4) {
					board[i][j].setPiece(new King(1));
				}
				if(i == 7 && j == 3 ) {
					board[i][j].setPiece(new Queen(1));
				}
				board[i][j].setFile(i+1);
				board[i][j].setRank(j+1);
			}
		}

	}
}
