package com.example.chessandroid67;

public class Tile {

	private int color, rank, file;
	private boolean holdsPiece = false;
	private Piece piece;
	private boolean firstMove = false;

	public void setPiece(Piece piece) {
		this.piece = piece;
		holdsPiece = true;
	}
	public void removePiece() {
		piece = null;
		holdsPiece = false;
	}
	public void setColor(int x) {
		color = x;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getFile() {
		return file;
	}
	public void setFile(int file) {
		this.file = file;
	}
	public Piece getPiece() {
		return piece;
	}
	public boolean hasPiece() {
		
		return holdsPiece;
	}
	public void setFirstmove(boolean firstMove) {
		this.firstMove = firstMove;
	}
	public boolean getFirstmove() {
		return firstMove;
	}
}
