/**
 * 
 */
package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class TicTacToeAF {

	public static final String INCORRECT_USAGE = "Incorrect usage";
	public static final String IO_ERROR = "There was an io error. Try running the program again.";
	public static final String THANK_YOU = "Thank you for playing!";
	public static final char PLAYER1SIGN = 'x';
	public static final char PLAYER2SIGN = 'o';
	public static final String PLAYER_STR = "Player ";
	public static Map<Character, String> signToPlayerStr;
	public static Map<String, Character> playerStrToSign;
	
	static {
		initPlayerSignMap();
	}

	public static void main(String[] args)  {
		
		try {
			Player player1 = null;
			Player player2 = null;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			player1 = getPlayerFromInput(br, 1);			
			player2 = getPlayerFromInput(br, 2);
			
			player1.setSign(PLAYER1SIGN);
			player2.setSign(PLAYER2SIGN);
			
			System.gc();  // garbage collect current buffered reader

			Board board = new Board();
			boolean turn = true;
			System.out.println("Instructions: ");
			System.out.println("To place a move, enter <row> <column>");
			System.out.println("e.g. '0 0' is the top left corner, '1 1' is the middle, '2 2' is the bottom right corner.");
			board.printNBoard();
			
			while(true){
				if(board.canMove()){
					Player currentPlayer = turn ? player1 : player2;
					String currentPlayerStr = PLAYER_STR + (turn ? 1 : 2);
					System.out.println("It is " + currentPlayerStr + "'s turn.");
					if (!currentPlayer.move(board)){
						System.out.println("Invalid move. Please try again");
						continue;
					}
					turn ^= true; // toggle turn
					board.printNBoard();
				}
				else {
					Character winningSign = board.getWinner();
					winningSign = winningSign == null ? null : winningSign;
					String winningPlayer = signToPlayerStr.get(board.getWinner());
					if (winningPlayer == null){
						System.out.println("It's a draw!");
					}
					else {
						System.out.println("The winner is " + winningPlayer);
					}
					break;
				}
			}
			System.out.println(THANK_YOU);
		} catch (IOException e){
			System.out.println(IO_ERROR);
		}
	}
	
	private static Player getPlayerFromInput(BufferedReader br, int playerId) throws IOException{
		Player player = null;
		char playerSign = playerStrToSign.get(PLAYER_STR + playerId);
		System.out.println("Will " + PLAYER_STR + playerId + " ("+ playerSign +"'s) be human or computer?");
		String playerHorC = br.readLine().toLowerCase();
		player = PlayerFactory.generate(playerHorC);
		while (player == null){
			System.out.println("Please either type HUMAN or COMPUTER (case-insensitive).");
			System.out.println("Will " + PLAYER_STR + playerId + " ("+ playerSign +"'s) be human or computer?");
			playerHorC = br.readLine().toLowerCase();
			player = PlayerFactory.generate(playerHorC);
		}
		return player;
	}
	
	private static void initPlayerSignMap(){
		signToPlayerStr = new HashMap<>();
		playerStrToSign = new HashMap<>();
		signToPlayerStr.put(PLAYER1SIGN, PLAYER_STR + 1);
		signToPlayerStr.put(PLAYER2SIGN, PLAYER_STR + 2);
		playerStrToSign.put(PLAYER_STR + 1, PLAYER1SIGN);
		playerStrToSign.put(PLAYER_STR + 2, PLAYER2SIGN);
	}
		

}
