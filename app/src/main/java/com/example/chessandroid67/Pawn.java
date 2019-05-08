/**
 * @author Daniel Cherdak
 * @author Matthew Kelly
 */
package com.example.chessandroid67;


public class Pawn extends Piece {
	
	private char color;
	/**
	 * Constructor method for Pawn piece, uses 
	 * @param player
	 * to organize whether the pawn is white or black
	 */
	public Pawn(int player) {
		super.setPLayer(player);
		if(getPlayer()%2 == 0 ) {
			color = 'w';
		}else {
			color = 'b';
		}
	}
	/**
	 * attack method 
	 */
	public void attack(String s){
		//attacks diagonally
	}

	public void promte(String s) {
		//find out what piece was written after the move and promote to said piece
		//also possible to initialize new piece and delete old pawn
	}
	/**
	 * default promotion of piece to queen type
	 */
	public void promote() {
		//promote to queen
	}
	public boolean isLegal(Tile[][] board, Prev lastMove, String color, String name, int i, int j, int p, int q) {
		if(checkMove(board, lastMove, color, name.charAt(1), i, j, p, q) == true) {
			return true;
		}
		return false;
	}
	/**
	 *standard movement method for pawn
	 */
	public boolean checkBlackMovement(Tile[][] board, Prev lastMove, String color, int r, int c, boolean check) {
		if(r-1 >= 0) {
			if(!board[r-1][c].hasPiece()) {
				board[r-1][c].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r-1][c].getPiece());
				board[r-1][c].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r-1 >= 0 && c+1 < 8) {
			if(!board[r-1][c+1].hasPiece() && board[r][c+1].hasPiece() && lastMove.getRow()!= -1) {
				if(board[r][c+1].getPiece().toString().charAt(1) == 'P' && lastMove.getLastMove().equals(board[r][c+1].getPiece()) ) {
					if(board[r][c+1].getPiece().toString().charAt(0) == 'w') {
						Piece temp = board[r][c+1].getPiece();
						board[r-1][c+1].setPiece(board[r][c].getPiece());
						board[r][c].removePiece();
						
						check = bkCheck(board, lastMove);
						board[r][c].setPiece(board[r-1][c+1].getPiece());
						board[r][c+1].setPiece(temp);
						
						if(check == false) {
							return false;
						}
					}
				}
			}
		}
		if(r-1 >= 0 && c-1 >= 0 && c+1 < 8) {
			if(!board[r-1][c-1].hasPiece() && board[r][c-1].hasPiece() && lastMove.getRow()!= -1) {
				if(board[r][c-1].getPiece().toString().charAt(1) == 'P' && lastMove.getLastMove().equals(board[r][c+1].getPiece()) ) {
					if(board[r][c-1].getPiece().toString().charAt(0) == 'w') {
						Piece temp = board[r][c-1].getPiece();
						board[r-1][c-1].setPiece(board[r][c].getPiece());
						board[r][c].removePiece();
					
						check = bkCheck(board, lastMove);
						board[r][c].setPiece(board[r-1][c-1].getPiece());
						board[r][c-1].setPiece(temp);
					
						if(check == false) {
							return false;
						}
					}
				}
			}
		}
		if(r == 7) {
			if(!board[r-1][c].hasPiece() && !board[r-2][c].hasPiece()) {
				int k = r-2;
				board[k][c].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[k][c].getPiece());
				board[k][c].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r-1 >= 0 && c+1 < 8) {
			if(board[r-1][c+1].hasPiece()) {
				Piece temp = board[r-1][c+1].getPiece();
				board[r-1][c+1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
			
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r-1][c+1].getPiece());
				board[r-1][c+1].setPiece(temp);
			
				if(check == false) {
					return false;
				}
			}
		}
		if(r-1 >= 0 && c-1 >= 0) {
			if(board[r-1][c-1].hasPiece()) {
				Piece temp = board[r-1][c-1].getPiece();
				board[r-1][c-1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
			
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r-1][c-1].getPiece());
				board[r-1][c-1].setPiece(temp);
				
				if(check == false) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean checkWhiteMovement(Tile[][] board, Prev lastMove, String color, int r, int c, boolean check) {
		//if Enpassant == true can either move one step forward or two, if false can only move one square forward
		if(r+1 < 8) {
			if(!board[r+1][c].hasPiece()) {
				board[r+1][c].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r+1][c].getPiece());
				board[r+1][c].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r+1 < 8 && c+1 < 8) {
			if(!board[r+1][c+1].hasPiece() && board[r][c+1].hasPiece() && lastMove.getRow()!= -1) {
				if(board[r][c+1].getPiece().toString().charAt(1) == 'P' && lastMove.getLastMove().equals(board[r][c+1].getPiece()) ) {
					if(board[r][c+1].getPiece().toString().charAt(0) == 'b') {
						Piece temp = board[r][c+1].getPiece();
						board[r+1][c+1].setPiece(board[r][c].getPiece());
						board[r][c].removePiece();
						
						check = wkCheck(board, lastMove);
						board[r][c].setPiece(board[r+1][c+1].getPiece());
						board[r][c+1].setPiece(temp);
						
						if(check == false) {
							return false;
						}
					}
				}
			}
		}
		if(r+1 < 8 && c-1 >= 0 && c+1 < 8) {
			if(!board[r+1][c-1].hasPiece() && board[r][c-1].hasPiece() && lastMove.getRow()!= -1) {
				if(board[r][c-1].getPiece().toString().charAt(1) == 'P' && lastMove.getLastMove().equals(board[r][c+1].getPiece()) ) {
					if(board[r][c-1].getPiece().toString().charAt(0) == 'b') {
						Piece temp = board[r][c-1].getPiece();
						board[r+1][c-1].setPiece(board[r][c].getPiece());
						board[r][c].removePiece();
					
						check = wkCheck(board, lastMove);
						board[r][c].setPiece(board[r+1][c-1].getPiece());
						board[r][c-1].setPiece(temp);
					
						if(check == false) {
							return false;
						}
					}
				}
			}
		}
		if(r == 1) {
			if(!board[r+1][c].hasPiece() && !board[r+2][c].hasPiece()) {
				int k = r+2;
				board[k][c].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[k][c].getPiece());
				board[k][c].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r+1 < 8 && c+1 < 8) {
			if(board[r+1][c+1].hasPiece()) {
				Piece temp = board[r+1][c+1].getPiece();
				board[r+1][c+1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
			
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r+1][c+1].getPiece());
				board[r+1][c+1].setPiece(temp);
			
				if(check == false) {
					return false;
				}
			}
		}
		if(r+1 < 8 && c-1 >= 0) {
			if(board[r+1][c-1].hasPiece()) {
				Piece temp = board[r+1][c-1].getPiece();
				board[r+1][c-1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
			
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r+1][c-1].getPiece());
				board[r+1][c-1].setPiece(temp);
			
				if(check == false) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * standard toString method. Used for  displaying the color and type of piece on the board
	 */
	public String toString() {
		return color + "P";
	}
}
