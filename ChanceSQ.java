
public class ChanceSQ extends ActionSQ {

	
	public ChanceSQ(String name) {
		super(name);
	}

	@Override
	public String pickACard(Player player) {
		ChanceList cl = ChanceList.getInstance(null);
		String thecard = cl.takeACard();
		return player.name + " draws " + controlCard(thecard, player);
	}
	
	private String controlCard(String thecard, Player player){
		if(thecard.equals("Advance to Go (Collect $200)")){
			advancetoGo(player);
		}
		if(thecard.equals("Advance to Leicester Square")){
			advancetoLeicester(player);
		}
		if(thecard.equals("Go back 3 spaces")){
			goBackSpaces(player);
		}
		if(thecard.equals("Pay poor tax of $15")){
			payTax(player);
		}
		if(thecard.equals("Your building loan matures – collect $150")){
			collectLoan(player);
		}
		if(thecard.equals("You have won a crossword competition - collect $100 ")){
			crossword(player);
		}
		return thecard;
	}
	
	private void advancetoGo(Player player){
		Player banker = PlayerList.getInstance().banker;
		player.position = 0;
		player.cash += 200;
		banker.cash -= 200;
	}
	
	private void advancetoLeicester(Player player){
		int firstpos = player.position;
		int leicester = 26;
		int dice = leicester - firstpos;
		if(dice < 0)
			dice += 40;
		player.rollTheDice(dice);
	}
	
	private void goBackSpaces(Player player){
		player.rollTheDice(-3);
		player.cash -= 200;
	}
	
	private void payTax(Player player){
		Player banker = PlayerList.getInstance().banker;
		player.cash -= 15;
		banker.cash += 15;
	}
	
	private void collectLoan(Player player){
		Player banker = PlayerList.getInstance().banker;
		player.cash += 150;
		banker.cash -= 150;
	}
	
	private void crossword(Player player){
		Player banker = PlayerList.getInstance().banker;
		player.cash += 100;
		banker.cash -= 100;
		
	}
}
