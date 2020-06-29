
public class Player {

	int playerPosition;
	int skipCount;
	boolean skipTurn;
	boolean firstPlayer;
	
	public void boardSpace(int playerTurn) {
		boolean boardSpaceCheck = true;
		
		while(boardSpaceCheck) {
			switch(playerPosition) {
			case 6:
				System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + " en rent over de brug! Ga verder naar 12.");
				playerPosition = 12;
				System.out.println("Gans " + playerTurn + " staat nu op plaats " + playerPosition);
				boardSpaceCheck = false;
				break;
			case 10:
				System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + " en mag nogmaals " + ganzenbord.totalRoll + " stappen lopen!");
				playerPosition = playerPosition + ganzenbord.totalRoll;

				if(ganzenbord.totalRoll == 10 && playerPosition == 20) {
					boardSpaceCheck = false;
					System.out.println("Gans " + playerTurn + " staat nu op plaats " + playerPosition + "!");
				}
				break;
			case 19:
				System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + " en slaapt in de de herberg. Sla 1 beurt over.");
				skipTurn = true;
				skipCount = 1;
				boardSpaceCheck = false;
				break;
			case 20:
				System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + " en mag nogmaals " + ganzenbord.totalRoll + " stappen lopen!");
				playerPosition = playerPosition + ganzenbord.totalRoll;
				break;
			case 30:
				System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + " en mag nogmaals " + ganzenbord.totalRoll + " stappen lopen!");
				playerPosition = playerPosition + ganzenbord.totalRoll;
				break;
			case 31:
				if(!ganzenbord.firstPlayer) {
					System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + " en valt in de put! Een andere speler moet je redden!");
					
					ganzenbord.firstPlayer = true;
					ganzenbord.playerInPut = ganzenbord.playerTurn;
				}else {
					System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + " en helpt Gans " + ganzenbord.playerInPut + " uit de put!");
					System.out.println("Gans " + ganzenbord.playerInPut + " mag weer verder spelen!");
					
					ganzenbord.firstPlayer = false;
					ganzenbord.playerInPut = 0;
				}
				boardSpaceCheck = false;
				break;
			case 40:
				System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + " en mag nogmaals " + ganzenbord.totalRoll + " stappen lopen!");
				playerPosition = playerPosition + ganzenbord.totalRoll;
				break;
			case 42:
				System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + " en is verdwaald in de doolhof. Ga terug naar 39.");
				playerPosition = 39;
				System.out.println("Gans " + playerTurn + " staat nu op plaats " + playerPosition);
				boardSpaceCheck = false;
				break;
			case 50:
				System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + " en mag nogmaals " + ganzenbord.totalRoll + " stappen lopen!");
				playerPosition = playerPosition + ganzenbord.totalRoll;
				break;
			case 52:
				System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + " en zit in de gevangenis! Sla 3 beurten over.");
				skipTurn = true;
				skipCount = 3;
				boardSpaceCheck = false;
				break;
			case 58:
				System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + " en komt te overlijdden. Ga terug naar start (0).");
				playerPosition = 0;
				System.out.println("Gans " + playerTurn + " staat nu op plaats " + playerPosition);
				boardSpaceCheck = false;
				break;
			case 60:
				System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + " en mag nogmaals " + ganzenbord.totalRoll + " stappen lopen!");
				playerPosition = playerPosition + ganzenbord.totalRoll;
				break;
			case 63:
				System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + " en heeft de finish gehaald!"); 
				System.out.println("Gans " + playerTurn + " heeft gewonnen!");
				boardSpaceCheck = false;
				break;			
			default:
				if(playerPosition > 63) {
					System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition);
					int posVerschil = playerPosition - 63;
					playerPosition = 63 - posVerschil;
					System.out.println("Gans " + playerTurn + " wordt vanaf plaats 63, " + posVerschil + " plaats(en) teruggeplaatst naar plaats " + playerPosition);
				}else {
				    System.out.println("Gans " + playerTurn + " staat op plaats " + playerPosition + ", niks aan de hand.");
				    boardSpaceCheck = false;
				}
			    break;
			}
		}
	}
	
	public void skipTurn(int turn) {
		if(skipCount > 0) {
			System.out.println("----------------------------------------------------------");
			System.out.println("Gans " + ganzenbord.playerTurn + " slaat " + skipCount + " beurt(en) over!");
		}
	
			if(skipCount == 1) {
				skipCount = skipCount - 1;
				skipTurn = false;
					
				if(ganzenbord.playerTurn < 3) {
					ganzenbord.playerTurn++;
				}else {
					ganzenbord.playerTurn = 1;
				}		
			}else if(skipCount == 2 || skipCount == 3) {
				skipCount = skipCount - 1;
					
				if(ganzenbord.playerTurn < 3) {
					ganzenbord.playerTurn++;
				}else {
					ganzenbord.playerTurn = 1;
				}
			}
			
			if(ganzenbord.playerInPut > 0) {
				System.out.println("----------------------------------------------------------");
				System.out.println("Gans " + ganzenbord.playerTurn + " zit nog vast in de put en slaat zijn beurt over!");
				
				if(ganzenbord.playerTurn < 3) {
					ganzenbord.playerTurn++;
				}else {
					ganzenbord.playerTurn = 1;
				}
			}
	}
}

