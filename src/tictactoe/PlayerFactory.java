package tictactoe;

public class PlayerFactory {
	
	public static Player generate(String playerStr){
		if (playerStr.equals(Player.HUMAN)){
			return new Human();
		}
		if (playerStr.equals(Player.COMPUTER)){
			return new Computer();
		}
		
		return null;
		
	}
}
