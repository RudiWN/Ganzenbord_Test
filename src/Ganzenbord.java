import java.util.*;


class ganzenbord {
	
	static int playerTurn;
	static int boardSpace;
	static boolean firstPlayer;
	static int playerInPut;
	static int totalRoll;
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		Player playerOne = new Player();
		Player playerTwo = new Player();
		Player playerThree = new Player();
//		Player playerFour = new Player();
//		Player playerFive = new Player();
//		Player playerSix = new Player();
		playerTurn = 1;
		boolean turnCheck = true;
		
		while(true) {
			
			while(turnCheck) {
				switch(playerTurn) {
				case 1:
					if(!playerOne.skipTurn && playerInPut != 1) {
						System.out.println("----------------------------------------------------------");
						System.out.println("Gans " + playerTurn + " staat op " + playerOne.playerPosition + " en is aan de beurt. Gooi je dobbelstenen (g)");
						turnCheck = false;
						break;
					}else if(playerOne.skipTurn || playerInPut == 1){
						playerOne.skipTurn(playerTurn);
					}
				case 2:
					if(!playerTwo.skipTurn && playerInPut != 2) {
						System.out.println("----------------------------------------------------------");
						System.out.println("Gans " + playerTurn + " staat op " + playerTwo.playerPosition + " en is aan de beurt. Gooi je dobbelstenen (g)");
						turnCheck = false;
						break;
					}else if(playerTwo.skipTurn || playerInPut == 2){
						playerTwo.skipTurn(playerTurn);
					}	
				case 3:
					if(!playerThree.skipTurn && playerInPut != 3) {
						System.out.println("----------------------------------------------------------");
						System.out.println("Gans " + playerTurn + " staat op " + playerThree.playerPosition + " en is aan de beurt. Gooi je dobbelstenen (g)");
						turnCheck = false;
						break;
					}else if(playerThree.skipTurn || playerInPut == 3){
						playerThree.skipTurn(playerTurn);
						}
					}
				}
					
			char playerInput = keyboard.next().charAt(0);
				
			if(playerInput == 'g') {
				Random random = new Random();
				int dieOne = random.nextInt(6) + 1;
				int dieTwo = random.nextInt(6) + 1;
				totalRoll = dieOne + dieTwo;
				
				System.out.println("Dobbelsteen 1: " + dieOne);
				System.out.println("Dobbelsteen 2: " + dieTwo);
				System.out.println("Totale worp: " + totalRoll);
				System.out.println();
				
				switch(playerTurn) {
				case 1:
					playerOne.playerPosition = playerOne.playerPosition + totalRoll;	
					playerOne.boardSpace(playerTurn);
					boardSpace = playerOne.playerPosition;
					break;
				case 2:
					playerTwo.playerPosition = playerTwo.playerPosition + totalRoll;
					playerTwo.boardSpace(playerTurn);
					boardSpace = playerTwo.playerPosition;
					break;
				case 3:
					playerThree.playerPosition = playerThree.playerPosition + totalRoll;
					playerThree.boardSpace(playerTurn);
					boardSpace = playerThree.playerPosition;
					break;
				}
			}
			
			if(boardSpace == 63) {
				break;
			}
			
			if(playerTurn < 3) {
				playerTurn++;
			}else {
				playerTurn = 1;
			}
			
			turnCheck = true;
		}
		keyboard.close();
	}	
}
