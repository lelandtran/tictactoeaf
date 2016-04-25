package tictactoe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;


public class BoardOld {

	/*
	 * NOTES: The moves HashSet is used to  
	 */
	static final int BOARD_SIZE = 3;
	HashMap<Character, HashSet<Integer>> moves;
	char[][] board;
	
	public BoardOld(){
		board = new char[BOARD_SIZE][BOARD_SIZE];
		moves = new HashMap<Character, HashSet<Integer>>();
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = ' ';
			}
		}
	}
	
	public boolean move(char c, int x, int y) {
		if (x < 0 || x >= BOARD_SIZE){
			return false;
		}
		if (y < 0 || y >= BOARD_SIZE){
			return false;
		}
		if (board[x][y] == ' '){
			board[x][y] = c;
			int newMove = x*10+y;
			if(moves.get(c)==null){
				HashSet<Integer> valSet = new HashSet<Integer>();
				valSet.add(newMove);
				moves.put(c, valSet);
				System.out.println("put " + c + " in with val: " + moves.get(c));
			}
			else {
				moves.get(c).add(newMove);
			}
			return true;
		}
		return false;
	}
	
	public boolean canMove(){
		if (fullBoard()){
			return false;
		}
		for (Entry<Character,HashSet<Integer>> ent : moves.entrySet()){
			if (isWinner((char)ent.getKey())){
				return false;
			}
		}
		return true;
	}
	
	public boolean isWinner(char c){
		int boardsize = BOARD_SIZE;     // simply done to suppress warnings from comparing a final variable to a constant
		if (boardsize == 3){
			return isWinner3(c);
		}
		return isWinnerN(c);
	}
	
	/* TODO: Check for patterns in the moves hashmap for each character
		if there is a character that has BOARD_SIZE number of moves with
		the same ten's digit, one's digit, mirror digits, or digits
		add up to BOARD_SIZE-1, it is the winner
	*/
	public boolean isWinnerN(char c){
		
		return false;
	}
	
	/*
	 * Note: this algorithm only works for when BOARD_SIZE is 3 but it's more
	 * time-efficient than a general algorithm since it is O(BOARD_SIZE), that is,
	 * big-O of board size
	 */
	public boolean isWinner3(char c){
		HashSet<Integer> cMoves = moves.get(c);
		if(cMoves == null){
			return false;
		}
		if (cMoves.contains(0) && cMoves.contains(1) && cMoves.contains(2)){
			return true;
		}
		if (cMoves.contains(10) && cMoves.contains(11) && cMoves.contains(12)){
			return true;
		}
		if(cMoves.contains(20) && cMoves.contains(21) && cMoves.contains(22)){
			return true;
		}
		if(cMoves.contains(0) && cMoves.contains(10) && cMoves.contains(20)){
			return true;
		}
		if(cMoves.contains(1) && cMoves.contains(11) && cMoves.contains(21)){
			return true;
		}
		if(cMoves.contains(2) && cMoves.contains(12) && cMoves.contains(22)){
			return true;
		}
		if(cMoves.contains(0) && cMoves.contains(11) && cMoves.contains(22)){
			return true;
		}
		if(cMoves.contains(2) && cMoves.contains(11) && cMoves.contains(20)){
			return true;
		}
		return false;
	}
	
	public boolean fullBoard(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if (board[i][j] == ' ')
					return false;
			}
		}
		return true;
	}
	
	public void clearBoard(){
		moves.clear();
		for(int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				board[i][j] = ' ';
			}
		}
	}
	
	public void printBoard(){
		System.out.println(" "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]+" ");
		System.out.println("-----------");
		System.out.println(" "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]+" ");
		System.out.println("-----------");
		System.out.println(" "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]+" ");
	}
	
	public char[][] getBoard(){
		return board;
	}
	
	public static void main(String args[]){
		System.out.println("Printing board as a test");
		BoardOld b = new BoardOld();
		b.printBoard();
		b.move('x', 1, 1);
		System.out.println(b.move('o', 1, 1));
		b.printBoard();
		for (int i = 0; i < b.getBoard().length; i++){
			System.out.println(b.isWinner3('o'));
			for (int j = 0; j < b.getBoard()[i].length; j++){
				b.move('o', i, j);
			}
		}
		b.printBoard();
	}
}
