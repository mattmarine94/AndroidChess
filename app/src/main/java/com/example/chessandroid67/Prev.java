package com.example.chessandroid67;

public class Prev {
	
	private Piece lastPiece;
	private int row;
	private int newrow;
	public Prev() {
		row = -1;
	}
	public void setLastMove(Piece lastPiece, int row, int newrow) {
		
		this.lastPiece = lastPiece;
		this.row = row;
		this.newrow = newrow;
		
	}
	
	public Piece getLastMove() {
		return lastPiece;
	}
	public int getRow() {
		return row;
	}
	public int getNewrow() {
		return newrow;
	}
}
