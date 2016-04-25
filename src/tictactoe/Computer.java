package tictactoe;

public class Computer extends Player {

	@Override
	public boolean move(Board b) {
		System.out.println("Computer is thinking...");
		int randRow = (int)(Math.random()*Board.BOARD_SIZE);
		int randCol = (int)(Math.random()*Board.BOARD_SIZE);
		while (!b.move(this.getSign(), randRow, randCol)){
			randRow = (int)(Math.random()*Board.BOARD_SIZE);
			randCol = (int)(Math.random()*Board.BOARD_SIZE);
		}
		System.out.println("Computer chooses " + randRow + " " + randCol);
		return true;
		// TODO Auto-generated method stub

	}

}
