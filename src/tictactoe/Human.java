package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Human extends Player {

	public static final String INVALID_MOVE = ("Please enter numbers between 0 and " + (Board.BOARD_SIZE-1));
	@Override
	public boolean move(Board b) {
		// TODO Auto-generated method stub
		return moveFromInput(b);
	}
	
	public boolean moveFromInput(Board b){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true){
			System.out.println("To place an '" + this.getSign() + "', enter <row> <column> e.g. 1 2");
			
			try {
				String moveStr = br.readLine();
				StringTokenizer st = new StringTokenizer(moveStr);
				if (st.countTokens() != 2){
					System.out.println(INVALID_MOVE);
					continue;
				}
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				
				if (row < 0 || row >= Board.BOARD_SIZE){
					System.out.println(INVALID_MOVE);
					continue;
				}
				if (col < 0 || col >= Board.BOARD_SIZE){
					System.out.println(INVALID_MOVE);
					continue;
				}
				return b.move(this.getSign(), row, col);
				
			} catch (IOException e){
				System.out.println(TicTacToeAF.IO_ERROR);
				continue;
			}
			catch (NumberFormatException e){
				System.out.println(INVALID_MOVE);
				continue;
			}
		}
	}

}
