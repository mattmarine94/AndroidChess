/**
 * @author Daniel Cherdak
 * @author Matthew Kelly
 */
package com.example.chessandroid67;

public class Bishop extends Piece {

	private char color;
	/**
	 * Constructor method for Bishop piece, uses 
	 * @param player
	 * to organize whether the bishop is white or black
	 */
	public Bishop(int player) {
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
	 * movement method of a bishop
	 */
	public boolean checkBlackMovement(Tile[][] board, Prev lastMove, String color, int r, int c, boolean check) {
		int l = c+1;
		for(int k = r+1; k < 8 && l < 8; k++) {
			
			if(board[k][l].hasPiece()) {
				if(board[k][l].getPiece().toString().charAt(0) == 'b') {
					break;
				}
				else {
					Piece temp = board[k][l].getPiece();
					board[k][l].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[k][l].getPiece());
					board[k][l].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
				board[k][l].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[k][l].getPiece());
				board[k][l].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			l++;
		}
		l = c-1;
		for(int k = r+1; k < 8 && l >= 0; k++) {
			if(board[k][l].hasPiece()) {
				if(board[k][l].getPiece().toString().charAt(0) == 'b') {
					break;
				}
				else {
					Piece temp = board[k][l].getPiece();
					board[k][l].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[k][l].getPiece());
					board[k][l].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
				board[k][l].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[k][l].getPiece());
				board[k][l].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			l--;
		}
		l = c-1;
		for(int k = r-1; k >= 0 && l >= 0; k--) {
			if(board[k][l].hasPiece()) {
				if(board[k][l].getPiece().toString().charAt(0) == 'b') {
					break;
				}
				else {
					Piece temp = board[k][l].getPiece();
					board[k][l].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[k][l].getPiece());
					board[k][l].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
				board[k][l].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[k][l].getPiece());
				board[k][l].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			l--;
		}
		l = c+1;
		for(int k = r-1; k >= 0 && l < 8; k--) {
			if(board[k][l].hasPiece()) {
				if(board[k][l].getPiece().toString().charAt(0) == 'b') {
					break;
				}
				else {
					Piece temp = board[k][l].getPiece();
					board[k][l].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[k][l].getPiece());
					board[k][l].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
				board[k][l].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[k][l].getPiece());
				board[k][l].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			l++;
		}
		return true;
	}
	public boolean checkWhiteMovement(Tile[][] board, Prev lastMove, String color, int r, int c, boolean check) {
		//can move in diagonal directions
		int l = c+1;
		for(int k = r+1; k < 8 && l < 8; k++) {
			if(board[k][l].hasPiece()) {
				if(board[k][l].getPiece().toString().charAt(0) == 'w') {
					break;
				}
				else {
					Piece temp = board[k][l].getPiece();
					board[k][l].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[k][l].getPiece());
					board[k][l].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
				board[k][l].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[k][l].getPiece());
				board[k][l].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			l++;
		}
		l = c-1;
		for(int k = r+1; k < 8 && l >= 0; k++) {
			if(board[k][l].hasPiece()) {
				if(board[k][l].getPiece().toString().charAt(0) == 'w') {
					break;
				}
				else {
					Piece temp = board[k][l].getPiece();
					board[k][l].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[k][l].getPiece());
					board[k][l].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
				board[k][l].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[k][l].getPiece());
				board[k][l].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			l--;
		}
		l = c-1;
		for(int k = r-1; k >= 0 && l >= 0; k--) {
			if(board[k][l].hasPiece()) {
				if(board[k][l].getPiece().toString().charAt(0) == 'w') {
					break;
				}
				else {
					Piece temp = board[k][l].getPiece();
					board[k][l].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[k][l].getPiece());
					board[k][l].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
				board[k][l].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[k][l].getPiece());
				board[k][l].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			l--;
		}
		l = c+1;
		for(int k = r-1; k >= 0 && l < 8; k--) {
			if(board[k][l].hasPiece()) {
				if(board[k][l].getPiece().toString().charAt(0) == 'w') {
					break;
				}
				else {
					Piece temp = board[k][l].getPiece();
					board[k][l].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[k][l].getPiece());
					board[k][l].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
				board[k][l].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[k][l].getPiece());
				board[k][l].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			l++;
		}
		return true;
	}
	/**
	 * standard toString method. Used for  displaying the color and type of piece on the board
	 */
	public String toString() {
		return color + "B";
	}

}
