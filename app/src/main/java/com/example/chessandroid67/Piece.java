package com.example.chessandroid67;

public abstract class Piece {
	private Type type;
	private int player;
	
	public abstract boolean checkWhiteMovement(Tile[][] board, Prev lastMove, String color, int r, int c, boolean check);
	public abstract boolean checkBlackMovement(Tile[][] board, Prev lastMove, String color, int r, int c, boolean check);
	public abstract boolean isLegal(Tile[][] board, Prev lastMove, String color, String name, int i, int j, int p, int q);
	
	public void setPLayer(int x){
		player = x;
	}
	public int getPlayer() {
		return player;
	}
	public void setType(Type type) {
		this.type = type;
	
	}
	public Type getType() {
		return type;
	}
public static boolean wkCheck(Tile[][] board, Prev lastMove) {
		
		int p = 0;
		int q = 0;
		boolean move = false;
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				if(board[r][c].hasPiece()) {
					if(board[r][c].getPiece().toString().charAt(1) == 'K' && board[r][c].getPiece().toString().charAt(0) == 'w') {
						p = r;
						q = c;
					}
				}
			}
		}
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				if(board[r][c].hasPiece()) {
					if(board[r][c].getPiece().toString().charAt(0) == 'b') {
						char piece = board[r][c].getPiece().toString().charAt(1);
						
						move = checkMove(board, lastMove, "black", piece, r, c, p, q);
						
						if(move == true) {
							return true;
						}
					}
				}
				
			}
		}
		return move;
	}
	/**
	 * method to check if Black is in check
	 */
	public static boolean bkCheck(Tile[][] board, Prev lastMove) {
		
		int p = 0;
		int q = 0;
		boolean move = false;
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				if(board[r][c].hasPiece()) {
					if(board[r][c].getPiece().toString().charAt(1) == 'K' && board[r][c].getPiece().toString().charAt(0) == 'b') {
						p = r;
						q = c;
					}
				}
			}
		}
		
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				if(board[r][c].hasPiece()) {
					if(board[r][c].getPiece().toString().charAt(0) == 'w') {
						char piece = board[r][c].getPiece().toString().charAt(1);
						
						move = checkMove(board, lastMove, "white", piece, r, c, p, q);
						
						if(move == true) {
							return true;
						}
					}
				}
				
			}
		}
		return move;
	}
	public static boolean checkMove(Tile[][] board, Prev lastMove, String color, char piece, int i, int j, int p, int q){
		if(i == p && j == q || board[i][j].getPiece().toString().charAt(0) != color.charAt(0)){
			return false;
		}
		if(p > 7 || p < 0 || q > 7 || q < 0) {
			return false;
		}
		
		if(piece == 'P') {
			
			if(i+1 == p && j+1 == q && board[i][j+1].hasPiece() && color.charAt(0)=='w') {
				if(board[i][j+1].getPiece().toString().charAt(1) == 'P' && board[i][j+1].getPiece().toString().charAt(0) == 'b' && lastMove.getRow() != -1) {
					if(lastMove.getLastMove().equals(board[i][j+1].getPiece()) && lastMove.getRow() - lastMove.getNewrow() == 2) {
						return true;
					}
				}
			}
			if(i+1 == p && j-1 == q && board[i][j-1].hasPiece() && color.charAt(0)=='w') {
				if(board[i][j-1].getPiece().toString().charAt(1) == 'P' && board[i][j-1].getPiece().toString().charAt(0) == 'b' && lastMove.getRow() != -1) {
					if(lastMove.getLastMove().equals(board[i][j-1].getPiece()) && lastMove.getRow() - lastMove.getNewrow() == 2) {
						return true;
					}
				}
			}
			if(i-1 == p && j+1 == q && board[i][j+1].hasPiece() && color.charAt(0)=='b') {
				if(board[i][j+1].getPiece().toString().charAt(1) == 'P' && board[i][j+1].getPiece().toString().charAt(0) == 'w' && lastMove.getRow() != -1) {
					if(lastMove.getLastMove().equals(board[i][j+1].getPiece()) && lastMove.getNewrow() - lastMove.getRow() == 2) {
						return true;
					}
				}
			}
			if(i-1 == p && j-1 == q && board[i][j-1].hasPiece() && color.charAt(0)=='b') {
				if(board[i][j-1].getPiece().toString().charAt(1) == 'P' && board[i][j-1].getPiece().toString().charAt(0) == 'w' && lastMove.getRow() != -1) {
					if(lastMove.getLastMove().equals(board[i][j-1].getPiece()) && lastMove.getNewrow() - lastMove.getRow() == 2) {
						return true;
					}
				}
			}
			
			if(i == 1 && j == q && color.charAt(0) == 'w') {
				if(i+2 == p && j == q && board[i+1][j].hasPiece() == false && board[i+2][j].hasPiece() == false) {
					return true;
				}
				if(i+1 == p && j == q && board[i+1][j].hasPiece() == false) {
					return true;
				}
				return false;
			}
			if(i == 6 && j == q && color.charAt(0) == 'b') {
				if(i-2 == p && j == q && board[i-1][j].hasPiece() == false && board[i-2][j].hasPiece() == false) {
					return true;
				}
				if(i-1 == p && j == q && board[i-1][j].hasPiece() == false) {
					return true;
				}
				return false;
			}
			if((i+1 == p && j == q) && color.charAt(0) == 'w' && board[i+1][j].hasPiece() == false){
				return true;
			}
			if((i-1 == p && j == q) && color.charAt(0) == 'b' && board[i-1][j].hasPiece() == false){
				//check for piece on path
				return true;
			}
			//captures
			if(i+1 == p && (j+1 == q || j-1 == q) && color.charAt(0) == 'w') {
				if(board[p][q].hasPiece() == true) {
					return true;
				}
			}
			if(i-1 == p && (j+1 == q || j-1 == q) && color.charAt(0) == 'b') {
				if(board[p][q].hasPiece() == true) {
					return true;
				}
			}
			return false;
		}
		if(piece == 'R'){
			
			int m = i;
			int n = j;
			//moves Up
			if(i != p && p > i && j == q) {
				m++;
				for(int k = m; k < 8; k++) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					m++;
				}
			}
			//moves down
			m = i;
			n = j;
			if(i != p && p < i && j == q) {
				m--;
				for(int k = m; k >= 0; k--) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					m--;
				}
			}
			m = i;
			n = j;
			if(i == p && j != q && q > j) {
				n++;
				for(int k = n; k < 8; k++) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					n++;
				}
			}
			m = i;
			n = j;
			if(i == p && j != q && q < j) {
				n--;
				for(int k = n; k >= 0; k--) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					n--;
				}
			}
			return false;
		}
		if(piece == 'N'){
			if(i+1 == p && j+2 == q) {
				return true;
			}
			if(i+1 == p && j-2 == q) {
				return true;
			}
			if(i+2 == p && j+1 == q) {
				return true;
			}
			if(i+2 == p && j-1 == q) {
				return true;
			}
			if(i-1 == p && j+2 == q) {
				return true;
			}
			if(i-1 == p && j-2 == q) {
				return true;
			}
			if(i-2 == p && j+1 == q) {
				return true;
			}
			if(i-2 == p && j-1 == q) {
				return true;
			}
			
			return false;
			
		}
		if(piece == 'B'){
			
			int m = i;
			int n = j;
			//moves Up and right
			if(i != p && j != q && p > i && q > j) {
				m++;
				n++;
				for(int k = n; k < 8 && m < 8; k++) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					m++;
					n++;
				}
			}
			//moves down and left
			m = i;
			n = j;
			if(i != p && j != q && p < i && q < j) {
				m--;
				n--;
				for(int k = n; k >= 0 && m >= 0; k--) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					m--;
					n--;
				}
			}
			m = i;
			n = j;
			if(i != p && j != q && p > i && q < j) {
				m++;
				n--;
				for(int k = n; k >= 0 && m < 8; k--) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					m++;
					n--;
				}
			}
			m = i;
			n = j;
			if(i != p && j != q && p < i && q > j) {
				m--;
				n++;
				for(int k = n; k < 8 && m >=0; k++) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					m--;
					n++;
				}
			}
			return false;
		}
		if(piece == 'K'){
			//castling wK
			boolean check = false;
			if(i == 0 && j == 4 && p == i && q == j+2 && color.charAt(0) == 'w') {
				if(!board[i][j+1].hasPiece() && !board[i][j+2].hasPiece() && board[0][7].hasPiece()) {
					if(board[0][7].getPiece().toString().charAt(1) == 'R' && board[0][7].getPiece().toString().charAt(0) == 'w' && wkCheck(board, lastMove) == false) {
						board[i][j+1].setPiece(board[i][j].getPiece());
						board[i][j].removePiece();
						
						check = wkCheck(board, lastMove);
						board[i][j].setPiece(board[i][j+1].getPiece());
						board[i][j+1].removePiece();
						
						if(check == true) {
							return false; 
						}
						else {
							
							board[i][j+2].setPiece(board[i][j].getPiece());
							board[i][j].removePiece();
							
							check = wkCheck(board, lastMove);
							board[i][j].setPiece(board[i][j+2].getPiece());
							board[i][j+2].removePiece();
							
							if(check == true) {								
								return false;
							}
							else if(board[0][4].getFirstmove() == true && board[0][7].getFirstmove() == true) {								
								board[0][4].setFirstmove(false);
								board[0][7].setFirstmove(false);
								board[0][5].setPiece(board[0][7].getPiece());
								board[0][7].removePiece();
								return true;
							}
						}
						
					}
				}
			}

			if(i == 0 && j == 4 && p == i && q == j-2 && color.charAt(0) == 'w') {
				if(!board[i][j-1].hasPiece() && !board[i][j-2].hasPiece() && board[0][0].hasPiece()) {
					if(board[0][0].getPiece().toString().charAt(1) == 'R' && board[0][0].getPiece().toString().charAt(0) == 'w' && wkCheck(board, lastMove) == false) {
						
						board[i][j-1].setPiece(board[i][j].getPiece());
						board[i][j].removePiece();
						
						check = wkCheck(board, lastMove);
						board[i][j].setPiece(board[i][j-1].getPiece());
						board[i][j-1].removePiece();
						
						if(check == true) {
							return false; 
						}
						else {
							board[i][j-2].setPiece(board[i][j].getPiece());
							board[i][j].removePiece();
							
							check = wkCheck(board, lastMove);
							board[i][j].setPiece(board[i][j-2].getPiece());
							board[i][j-2].removePiece();
							
							if(check == true) {
								return false;
							}
							else {
								board[i][j-3].setPiece(board[i][j].getPiece());
								board[i][j].removePiece();
								
								check = wkCheck(board, lastMove);
								board[i][j].setPiece(board[i][j-3].getPiece());
								board[i][j-3].removePiece();
								
								if(check == true) {
									return false;
								}
								else if(board[0][4].getFirstmove() == true && board[0][0].getFirstmove() == true){
									board[0][4].setFirstmove(false);
									board[0][0].setFirstmove(false);
									board[0][3].setPiece(board[0][0].getPiece());
									board[0][0].removePiece();
									return true;
								}
							}
						}
						
					}
				}
			}
			//castling bK
			if(i == 7 && j == 4 && p == i && q == j+2 && color.charAt(0) == 'b') {
				if(!board[i][j+1].hasPiece() && !board[i][j+2].hasPiece() && board[7][7].hasPiece()) {
					if(board[7][7].getPiece().toString().charAt(1) == 'R' && board[7][7].getPiece().toString().charAt(0) == 'b' && bkCheck(board, lastMove) == false) {
						
						board[i][j+1].setPiece(board[i][j].getPiece());
						board[i][j].removePiece();
						
						check = bkCheck(board, lastMove);
						board[i][j].setPiece(board[i][j+1].getPiece());
						board[i][j+1].removePiece();
						
						if(check == true) {
							return false; 
						}
						else {
							board[i][j+2].setPiece(board[i][j].getPiece());
							board[i][j].removePiece();
							
							check = bkCheck(board, lastMove);
							board[i][j].setPiece(board[i][j+2].getPiece());
							board[i][j+2].removePiece();
							
							if(check == true) {
								return false;
							}
							else if(board[7][4].getFirstmove() == true && board[7][7].getFirstmove() == true){
								board[7][4].setFirstmove(false);
								board[7][7].setFirstmove(false);
								board[7][5].setPiece(board[7][7].getPiece());
								board[7][7].removePiece();
								return true;
							}
						}
					}
				}
			}
			if(i == 7 && j == 4 && p == i && q == j-2 && color.charAt(0) == 'b') {
				if(!board[i][j-1].hasPiece() && !board[i][j-2].hasPiece() && board[7][0].hasPiece()) {
					if(board[7][0].getPiece().toString().charAt(1) == 'R' && board[7][0].getPiece().toString().charAt(0) == 'b' &&  bkCheck(board, lastMove) == false) {
						
						board[i][j-1].setPiece(board[i][j].getPiece());
						board[i][j].removePiece();
						
						check = bkCheck(board, lastMove);
						board[i][j].setPiece(board[i][j-1].getPiece());
						board[i][j-1].removePiece();
						
						if(check == true) {
							return false; 
						}
						else {
							board[i][j-2].setPiece(board[i][j].getPiece());
							board[i][j].removePiece();
							
							check = bkCheck(board, lastMove);
							board[i][j].setPiece(board[i][j-2].getPiece());
							board[i][j-2].removePiece();
							
							if(check == true) {
								return false;
							}
							else {
								board[i][j-3].setPiece(board[i][j].getPiece());
								board[i][j].removePiece();
								
								check = bkCheck(board, lastMove);
								board[i][j].setPiece(board[i][j-3].getPiece());
								board[i][j-3].removePiece();
								
								if(check == true) {
									return false;
								}
								else if(board[7][4].getFirstmove() == true && board[7][0].getFirstmove() == true){
									board[7][4].setFirstmove(false);
									board[7][0].setFirstmove(false);
									board[7][3].setPiece(board[7][0].getPiece());
									board[7][0].removePiece();
									return true;
								}
							}
						}
						
					}
				}
			}
			if(i+1 == p && j == q){

				return true;
			}
			if(i == p && j+1 == q){
				return true;
			}
			if(i+1 == p && j+1 == q){
				return true;
			}
			if(i-1 == p && j == q){
				return true;
			}
			if(i == p && j-1 == q){
				return true;
			}
			if(i-1 == p && j-1 == q){
				return true;
			}
			if(i-1 == p && j+1 == q){
				return true;
			}
			if(i+1 == p && j-1 == q){
				return true;
			}
			return false;
		}
		if(piece == 'Q'){
			int m = i;
			int n = j;
			//moves Up and right
			if(i != p && j != q && p > i && q > j) {
				m++;
				n++;
				for(int k = n; k < 8 && m < 8; k++) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					m++;
					n++;
				}
			}
			//moves down and left
			m = i;
			n = j;
			if(i != p && j != q && p < i && q < j) {
				m--;
				n--;
				for(int k = n; k >= 0 && m >= 0; k--) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					m--;
					n--;
				}
			}
			m = i;
			n = j;
			if(i != p && j != q && p > i && q < j) {
				m++;
				n--;
				for(int k = n; k >= 0 && m < 8; k--) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					m++;
					n--;
				}
			}
			m = i;
			n = j;
			if(i != p && j != q && p < i && q > j) {
				m--;
				n++;
				for(int k = n; k < 8 && m >= 0; k++) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					m--;
					n++;
				}
			}
			m = i;
			n = j;
			if(i != p && p > i && j == q) {
				m++;
				for(int k = m; k < 8; k++) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					m++;
				}
			}
			m = i;
			n = j;
			if(i != p && p < i && j == q) {
				m--;
				for(int k = m; k >= 0; k--) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					m--;
				}
			}
			m = i;
			n = j;
			if(i == p && j != q && q > j) {
				n++;
				for(int k = n; k < 8; k++) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					n++;
				}
			}
			m = i;
			n = j;
			if(i == p && j != q && q < j) {
				n--;
				for(int k = n; k >= 0; k--) {
					if(m == p && n == q) {
						return true;
					}
					else if(board[m][n].hasPiece() == true) {
						return false;
					}
					n--;
				}
			}
			return false;
		}
		return false;
	}
}
