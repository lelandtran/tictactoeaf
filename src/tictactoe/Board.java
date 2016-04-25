package tictactoe;


public class Board {

	static final int BOARD_SIZE = 3;
	char[][] board;
	Character winner;
	
	public Board(){
		board = new char[BOARD_SIZE][BOARD_SIZE];
		winner = null;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = ' ';
			}
		}
	}
	
	public boolean move(char c, int row, int col) {
		if (row < 0 || row >= BOARD_SIZE){
			return false;
		}
		if (col < 0 || col >= BOARD_SIZE){
			return false;
		}
		if (board[row][col] == ' '){
			board[row][col] = c;
			if (checkWin(c, row, col)){
				winner = new Character(c);
			}
			return true;
		}
		return false;
	}
	
	public boolean canMove(){
		if (isFullBoard()){
			return false;
		}
		if (winner != null){
			return false;
		}
		
		return true;
	}
	
	boolean checkWin(char c, int row, int col){
		if (verticalWin(c, row, col)){
			return true;
		}
		if (horizontalWin(c, row, col)){
			return true;
		}
		if ((row+col)==(BOARD_SIZE-1)){
			if (forwardDiagWin(c, row, col)){
				return true;
			}
		}
		if (row==col){
			if (backwardDiagWin(c, row, col)){
				return true;
			}
		}
		return false;
	}
	
	boolean verticalWin(char c, int row, int col){
		for (int i = 0; i < board.length; i++){
			if (board[i][col] != c){
				return false;
			}
		}
		return true;
	}
	
	boolean horizontalWin(char c, int row, int col){
		for (int j = 0; j < board[0].length; j++){
			if (board[row][j] != c){
				return false;
			}
		}
		return true;
	}
	
	boolean forwardDiagWin(char c, int row, int col){
		for (int i = 0; i < board.length; i++){
			int j = board[i].length-1-i;
			if (board[i][j] != c){
				return false;
			}
		}
		return true;
	}
	
	boolean backwardDiagWin(char c, int row, int col){
		for (int i = 0; i < board.length; i++){
			if (board[i][i] != c){
				return false;
			}
		}
		return true;
	}

	Character getWinner(){
		return winner;
	}

	
	public boolean isFullBoard(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if (board[i][j] == ' ')
					return false;
			}
		}
		return true;
	}
	
	
	public void clearBoard(){
		for(int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				board[i][j] = ' ';
			}
		}
		winner = null;
	}
	
	// TODO: Extend to different possible board sizes
	public void printBoard(){
		System.out.println(" "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]+" ");
		System.out.println("-----------");
		System.out.println(" "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]+" ");
		System.out.println("-----------");
		System.out.println(" "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]+" ");
	}
	
	public void printNBoard(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < BOARD_SIZE; i++){
			for (int j = 0; j < BOARD_SIZE; j++){
				System.out.print(" " + board[i][j] + " ");
				if (j != BOARD_SIZE-1){
					System.out.print("|");
				}
			}
			System.out.print("\n");
			if(i != BOARD_SIZE-1){
				for (int j = 0; j < BOARD_SIZE; j++){
					sb.append("----");
				}
				System.out.println(sb.toString());
				sb = new StringBuilder(); // supposedly the optimal way to clear a string builder 
			}
			
		}
	}
	
	public char[][] getBoard(){
		return board;
	}
	
	public static void main(String[] args){
		new Board().printNBoard();
	}
}
