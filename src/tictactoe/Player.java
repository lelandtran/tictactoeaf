package tictactoe;

public abstract class Player {
	private Character sign;
	public static final String HUMAN = "human";
	public static final String COMPUTER = "computer";
	
	public abstract boolean move(Board b);
	
	public char getSign(){
		return sign;
	}
	
	public void setSign(char c){
		this.sign = c;
	}
}
