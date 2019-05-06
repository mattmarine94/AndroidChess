/**
 * @author Daniel Cherdak
 * @author Matthew Kelly
 */
package com.example.chessandroid67;

public class King extends Piece {
	private boolean check = false;
	
	private char color;
	/**
	 * Constructor method for King piece, uses 
	 * @param player
	 * to organize whether the king is white or black
	 */
	public King(int player) {
		super.setPLayer(player);
		if(getPlayer()%2 == 0 ) {
			color = 'w';
		}else {
			color = 'b';
		}
	}
	public boolean isLegal(Tile[][] board, Prev lastMove, String color, String name, int i, int j, int p, int q) {
		if(checkMove(board, lastMove, color, name.charAt(1), i, j, p, q) == true) {
			return true;
		}
		return false;
	}
	/**
	 * standard movement method of a king
	 */
	public boolean checkBlackMovement(Tile[][] board, Prev lastMove, String color, int r, int c, boolean check) {
		if(r+1 < 8) {
			if(board[r+1][c].hasPiece()) {
				if(board[r+1][c].getPiece().toString().charAt(0) == 'w') {
					Piece temp = board[r+1][c].getPiece();
					board[r+1][c].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r+1][c].getPiece());
					board[r+1][c].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r+1][c].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r+1][c].getPiece());
				board[r+1][c].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r-1 >= 0) {
			if(board[r-1][c].hasPiece()) {
				if(board[r-1][c].getPiece().toString().charAt(0) == 'w') {
					Piece temp = board[r-1][c].getPiece();
					board[r-1][c].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r-1][c].getPiece());
					board[r-1][c].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
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
		if(c+1 < 8) {
			if(board[r][c+1].hasPiece()) {
				if(board[r][c+1].getPiece().toString().charAt(0) == 'w') {
					Piece temp = board[r][c+1].getPiece();
					board[r][c+1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r][c+1].getPiece());
					board[r][c+1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r][c+1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r][c+1].getPiece());
				board[r][c+1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(c-1 >= 0) {
			if(board[r][c-1].hasPiece()) {
				if(board[r][c-1].getPiece().toString().charAt(0) == 'w') {
					Piece temp = board[r][c-1].getPiece();
					board[r][c-1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r][c-1].getPiece());
					board[r][c-1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r][c-1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r][c-1].getPiece());
				board[r][c-1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r+1 < 8 && c+1 < 8) {
			if(board[r+1][c+1].hasPiece()) {
				if(board[r+1][c+1].getPiece().toString().charAt(0) == 'w') {
					Piece temp = board[r+1][c+1].getPiece();
					board[r+1][c+1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r+1][c+1].getPiece());
					board[r+1][c+1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r+1][c+1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r+1][c+1].getPiece());
				board[r+1][c+1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r+1 < 8 && c-1 >= 0) {
			if(board[r+1][c-1].hasPiece()) {
				if(board[r+1][c-1].getPiece().toString().charAt(0) == 'w') {
					Piece temp = board[r+1][c-1].getPiece();
					board[r+1][c-1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r+1][c-1].getPiece());
					board[r+1][c-1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r+1][c-1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r+1][c-1].getPiece());
				board[r+1][c-1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r-1 >= 0 && c+1 < 8) {
			if(board[r-1][c+1].hasPiece()) {
				if(board[r-1][c+1].getPiece().toString().charAt(0) == 'w') {
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
			else{
				board[r-1][c+1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r-1][c+1].getPiece());
				board[r-1][c+1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r-1 >= 0 && c-1 >= 0) {
			if(board[r-1][c-1].hasPiece()) {
				if(board[r-1][c-1].getPiece().toString().charAt(0) == 'w') {
					Piece temp = board[r-1][c-1].getPiece();
					board[r-1][c-1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r-1][c+1].getPiece());
					board[r-1][c+1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r-1][c+1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r-1][c+1].getPiece());
				board[r-1][c+1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean checkWhiteMovement(Tile[][] board, Prev lastMove, String color, int r, int c, boolean check) {
		if(r+1 < 8) {
			if(board[r+1][c].hasPiece()) {
				if(board[r+1][c].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r+1][c].getPiece();
					board[r+1][c].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r+1][c].getPiece());
					board[r+1][c].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
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
		if(r-1 >= 0) {
			if(board[r-1][c].hasPiece()) {
				if(board[r-1][c].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r-1][c].getPiece();
					board[r-1][c].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r-1][c].getPiece());
					board[r-1][c].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r-1][c].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r-1][c].getPiece());
				board[r-1][c].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(c+1 < 8) {
			if(board[r][c+1].hasPiece()) {
				if(board[r][c+1].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r][c+1].getPiece();
					board[r][c+1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r][c+1].getPiece());
					board[r][c+1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r][c+1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r][c+1].getPiece());
				board[r][c+1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(c-1 >= 0) {
			if(board[r][c-1].hasPiece()) {
				if(board[r][c-1].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r][c-1].getPiece();
					board[r][c-1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r][c-1].getPiece());
					board[r][c-1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r][c-1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r][c-1].getPiece());
				board[r][c-1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r+1 < 8 && c+1 < 8) {
			if(board[r+1][c+1].hasPiece()) {
				if(board[r+1][c+1].getPiece().toString().charAt(0) == 'b') {
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
			else{
				board[r+1][c+1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r+1][c+1].getPiece());
				board[r+1][c+1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r+1 < 8 && c-1 >= 0) {
			if(board[r+1][c-1].hasPiece()) {
				if(board[r+1][c-1].getPiece().toString().charAt(0) == 'b') {
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
			else{
				board[r+1][c-1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r+1][c-1].getPiece());
				board[r+1][c-1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r-1 >= 0 && c+1 < 8) {
			if(board[r-1][c+1].hasPiece()) {
				if(board[r-1][c+1].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r-1][c+1].getPiece();
					board[r-1][c+1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r-1][c+1].getPiece());
					board[r-1][c+1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r-1][c+1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r-1][c+1].getPiece());
				board[r-1][c+1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r-1 >= 0 && c-1 >= 0) {
			if(board[r-1][c-1].hasPiece()) {
				if(board[r-1][c-1].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r-1][c-1].getPiece();
					board[r-1][c-1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r-1][c+1].getPiece());
					board[r-1][c+1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r-1][c+1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r-1][c+1].getPiece());
				board[r-1][c+1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * method that is called if the king is put in check, flips the boolean check to true
	 */
	public boolean incheck() {
		check = true;
		return check;
	}
	/**
	 * method to flip boolean to false, ei: king is not in check
	 */
	public void outcheck() {
		check = false;
	}
	/**
	 * standard toString method. Used for  displaying the color and type of piece on the board
	 */
	public String toString() {
		return color + "K";
	}
}
