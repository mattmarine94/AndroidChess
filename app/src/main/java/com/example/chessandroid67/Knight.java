/**
 * @author Daniel Cherdak
 * @author Matthew Kelly
 */
package com.example.chessandroid67;

public class Knight extends Piece {

	private char color;
	/**
	 * Constructor method for Knight piece, uses 
	 * @param player
	 * to organize whether the knight is white or black
	 */
	public Knight(int player) {
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
	 * standard movement method for piece
	 */
	public boolean checkBlackMovement(Tile[][] board, Prev lastMove, String color, int r, int c, boolean check) {
		if(r+1 < 8 && c+2 < 8) {
			if(board[r+1][c+2].hasPiece()) {
				if(board[r+1][c+2].getPiece().toString().charAt(0) == 'w') {
					Piece temp = board[r+1][c+2].getPiece();
					board[r+1][c+2].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r+1][c+2].getPiece());
					board[r+1][c+2].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r+1][c+2].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r+1][c+2].getPiece());
				board[r+1][c+2].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r+1 < 8 && c-2 >= 0) {
			if(board[r+1][c-2].hasPiece()) {
				if(board[r+1][c-2].getPiece().toString().charAt(0) == 'w') {
					Piece temp = board[r+1][c-2].getPiece();
					board[r+1][c-2].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r+1][c-2].getPiece());
					board[r+1][c-2].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r+1][c-2].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r+1][c-2].getPiece());
				board[r+1][c-2].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			
		}
		if(r+2 < 8 && c+1 < 8) {
			if(board[r+2][c+1].hasPiece()) {
				if(board[r+2][c+1].getPiece().toString().charAt(0) == 'w') {
					Piece temp = board[r+2][c+1].getPiece();
					board[r+2][c+1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r+2][c+1].getPiece());
					board[r+2][c+1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r+2][c+1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r+2][c+1].getPiece());
				board[r+2][c+1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			
		}
		if(r+2 < 8 && c-1 >= 0) {
			if(board[r+2][c-1].hasPiece()) {
				if(board[r+2][c-1].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r+2][c-1].getPiece();
					board[r+2][c-1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r+2][c-1].getPiece());
					board[r+2][c-1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r+2][c-1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r+2][c-1].getPiece());
				board[r+2][c-1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			
		}
		if(r-1 >= 0 && c+2 < 8) {
			if(board[r-1][c+2].hasPiece()) {
				if(board[r-1][c+2].getPiece().toString().charAt(0) == 'w') {
					Piece temp = board[r-1][c+2].getPiece();
					board[r-1][c+2].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r-1][c+2].getPiece());
					board[r-1][c+2].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r-1][c+2].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r-1][c+2].getPiece());
				board[r-1][c+2].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			
		}
		if(r-1 >= 0 && c-2 >= 0) {
			if(board[r-1][c-2].hasPiece()) {
				if(board[r-1][c-2].getPiece().toString().charAt(0) == 'w') {
					Piece temp = board[r-1][c-2].getPiece();
					board[r-1][c-2].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r-1][c-2].getPiece());
					board[r-1][c-2].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r-1][c-2].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r-1][c-2].getPiece());
				board[r-1][c-2].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			
		}
		if(r-2 >= 0 && c+1 < 8) {
			if(board[r-2][c+1].hasPiece()) {
				if(board[r-2][c+1].getPiece().toString().charAt(0) == 'w') {
					Piece temp = board[r-2][c+1].getPiece();
					board[r-2][c+1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r-2][c+1].getPiece());
					board[r-2][c+1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r-2][c+1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r-2][c+1].getPiece());
				board[r-2][c+1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			
		}
		if(r-2 >= 0 && c-1 >= 0) {
			if(board[r-2][c-1].hasPiece()) {
				if(board[r-2][c-1].getPiece().toString().charAt(0) == 'w') {
					Piece temp = board[r-2][c-1].getPiece();
					board[r-2][c-1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = bkCheck(board, lastMove);
					board[r][c].setPiece(board[r-2][c-1].getPiece());
					board[r-2][c-1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r-2][c-1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = bkCheck(board, lastMove);
				board[r][c].setPiece(board[r-2][c-1].getPiece());
				board[r-2][c-1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			
		}
		return true;
	}
	public boolean checkWhiteMovement(Tile[][] board, Prev lastMove, String color, int r, int c, boolean check) {
		//can move in "L" movements two linearly away then perpendicularly one square
		if(r+1 < 8 && c+2 < 8) {
			if(board[r+1][c+2].hasPiece()) {
				if(board[r+1][c+2].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r+1][c+2].getPiece();
					board[r+1][c+2].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r+1][c+2].getPiece());
					board[r+1][c+2].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r+1][c+2].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r+1][c+2].getPiece());
				board[r+1][c+2].removePiece();
				
				if(check == false) {
					return false;
				}
			}
		}
		if(r+1 < 8 && c-2 >= 0) {
			if(board[r+1][c-2].hasPiece()) {
				if(board[r+1][c-2].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r+1][c-2].getPiece();
					board[r+1][c-2].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r+1][c-2].getPiece());
					board[r+1][c-2].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r+1][c-2].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r+1][c-2].getPiece());
				board[r+1][c-2].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			
		}
		if(r+2 < 8 && c+1 < 8) {
			if(board[r+2][c+1].hasPiece()) {
				if(board[r+2][c+1].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r+2][c+1].getPiece();
					board[r+2][c+1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r+2][c+1].getPiece());
					board[r+2][c+1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r+2][c+1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r+2][c+1].getPiece());
				board[r+2][c+1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			
		}
		if(r+2 < 8 && c-1 >= 0) {
			if(board[r+2][c-1].hasPiece()) {
				if(board[r+2][c-1].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r+2][c-1].getPiece();
					board[r+2][c-1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r+2][c-1].getPiece());
					board[r+2][c-1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r+2][c-1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r+2][c-1].getPiece());
				board[r+2][c-1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			
		}
		if(r-1 >= 0 && c+2 < 8) {
			if(board[r-1][c+2].hasPiece()) {
				if(board[r-1][c+2].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r-1][c+2].getPiece();
					board[r-1][c+2].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r-1][c+2].getPiece());
					board[r-1][c+2].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r-1][c+2].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r-1][c+2].getPiece());
				board[r-1][c+2].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			
		}
		if(r-1 >= 0 && c-2 >= 0) {
			if(board[r-1][c-2].hasPiece()) {
				if(board[r-1][c-2].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r-1][c-2].getPiece();
					board[r-1][c-2].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r-1][c-2].getPiece());
					board[r-1][c-2].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r-1][c-2].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r-1][c-2].getPiece());
				board[r-1][c-2].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			
		}
		if(r-2 >= 0 && c+1 < 8) {
			if(board[r-2][c+1].hasPiece()) {
				if(board[r-2][c+1].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r-2][c+1].getPiece();
					board[r-2][c+1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r-2][c+1].getPiece());
					board[r-2][c+1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r-2][c+1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r-2][c+1].getPiece());
				board[r-2][c+1].removePiece();
				
				if(check == false) {
					return false;
				}
			}
			
		}
		if(r-2 >= 0 && c-1 >= 0) {
			if(board[r-2][c-1].hasPiece()) {
				if(board[r-2][c-1].getPiece().toString().charAt(0) == 'b') {
					Piece temp = board[r-2][c-1].getPiece();
					board[r-2][c-1].setPiece(board[r][c].getPiece());
					board[r][c].removePiece();
					
					check = wkCheck(board, lastMove);
					board[r][c].setPiece(board[r-2][c-1].getPiece());
					board[r-2][c-1].setPiece(temp);
					
					if(check == false) {
						return false;
					}
				}
			}
			else{
				board[r-2][c-1].setPiece(board[r][c].getPiece());
				board[r][c].removePiece();
				
				check = wkCheck(board, lastMove);
				board[r][c].setPiece(board[r-2][c-1].getPiece());
				board[r-2][c-1].removePiece();
				
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
		return color + "N";
	}
}
