/**
 * @author Daniel Cherdak
 * @author Matthew Kelly
 */

package com.example.chessandroid67;

public class Queen extends Piece {

	private char color;
	/**
	 * Constructor method for Queen piece, uses 
	 * @param player
	 * to organize whether the queen is white or black
	 */
	public Queen(int player) {
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
	 * Movement method for Queen
	 */
	public boolean checkBlackMovement(Tile[][] board, Prev lastMove, String color, int r, int c, boolean check) {
		for(int k = r+1; k < 8; k++) {
			if(board[k][c].hasPiece()) {
				if(board[k][c].getPiece().toString().charAt(0) == 'b') {
					break;
				}
				else {
					Piece temp = board[k][c].getPiece();
					board[k][c].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[k][c].getPiece());
					board[k][c].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
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
		for(int k = r-1; k >=0; k--) {
			if(board[k][c].hasPiece()) {
				if(board[k][c].getPiece().toString().charAt(0) == 'b') {
					break;
				}
				else {
					Piece temp = board[k][c].getPiece();
					board[k][c].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[k][c].getPiece());
					board[k][c].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
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
		for(int k = c+1; k < 8; k++) {
			if(board[r][k].hasPiece()) {
				if(board[r][k].getPiece().toString().charAt(0) == 'b') {
					break;
				}
				else {
					Piece temp = board[k][c].getPiece();
					board[r][k].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r][k].getPiece());
					board[r][k].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
				board[r][k].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r][k].getPiece());
				board[r][k].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		for(int k = c-1; k >= 0; k--) {
			
			if(board[r][k].hasPiece()) {
				if(board[r][k].getPiece().toString().charAt(0) == 'b') {
					break;
				}
				else {
					Piece temp = board[k][c].getPiece();
					board[r][k].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r][k].getPiece());
					board[r][k].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
				board[r][k].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r][k].getPiece());
				board[r][k].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		
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
		//can move in any direction
		for(int k = r+1; k < 8; k++) {
			if(board[k][c].hasPiece()) {
				if(board[k][c].getPiece().toString().charAt(0) == 'w') {
					break;
				}
				else {
					Piece temp = board[k][c].getPiece();
					board[k][c].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[k][c].getPiece());
					board[k][c].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
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
		for(int k = r-1; k >=0; k--) {
			if(board[k][c].hasPiece()) {
				if(board[k][c].getPiece().toString().charAt(0) == 'w') {
					break;
				}
				else {
					Piece temp = board[k][c].getPiece();
					board[k][c].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[k][c].getPiece());
					board[k][c].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
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
		for(int k = c+1; k < 8; k++) {
			if(board[r][k].hasPiece()) {
				if(board[r][k].getPiece().toString().charAt(0) == 'w') {
					break;
				}
				else {
					Piece temp = board[k][c].getPiece();
					board[r][k].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r][k].getPiece());
					board[r][k].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
				board[r][k].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r][k].getPiece());
				board[r][k].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		for(int k = c-1; k >= 0; k--) {
			
			if(board[r][k].hasPiece()) {
				if(board[r][k].getPiece().toString().charAt(0) == 'w') {
					break;
				}
				else {
					Piece temp = board[k][c].getPiece();
					board[r][k].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r][k].getPiece());
					board[r][k].setPiece(temp);
					
					if(check == false) {
						return false;
					}
					break;
				}
			}
			else {
				board[r][k].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r][k].getPiece());
				board[r][k].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		
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
		return color + "Q";
	}
}
