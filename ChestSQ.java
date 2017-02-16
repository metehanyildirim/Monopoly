
public class ChestSQ extends ActionSQ{

	public ChestSQ(String name) {
		super(name);
	}

	@Override
	public String pickACard(Player player) {
		ChestList cl = ChestList.getInstance(null);
		String thecard = cl.takeACard();
		return player.name + " draws " + controlCard(thecard, player);
	}
	
	private String controlCard(String thecard, Player player){
		if(thecard.equals("Advance to Go (Collect $200)")){
			advancetoGo(player);
		}
		if(thecard.equals("Bank error in your favor – collect $75")){
			getPaid(player, 75);
		}
		if(thecard.equals("Doctor's fees – Pay $50")){
			SariCizmeliMehmetAga(player, 50);
		}
		if(thecard.equals("It is your birthday Collect $10 from each player")){
			birthday(player);
		}
		if(thecard.equals("Grand Opera Night – collect $50 from every player for opening night seats")){
			opera(player);
		}
		if(thecard.equals("Income Tax refund – collect $20")){
			getPaid(player, 20);
		}
		if(thecard.equals("Life Insurance Matures – collect $100")){
			getPaid(player, 100);
		}
		if(thecard.equals("Pay Hospital Fees of $100")){
			SariCizmeliMehmetAga(player, 100);
		}
		if(thecard.equals("Pay School Fees of $50")){
			SariCizmeliMehmetAga(player, 50);
		}
		if(thecard.equals("You inherit $100")){
			getPaid(player, 100);
		}
		if(thecard.equals("From sale of stock you get $50")){
			getPaid(player, 50);
		}
		return thecard;
	}
	
	private void advancetoGo(Player player){
		player.position = 0;
		player.cash += 200;
	}
	
	private void SariCizmeliMehmetAga(Player player, int cash){
		player.cash -= cash;
		PlayerList.getInstance().banker.cash += cash;
	}
	
	private void getPaid(Player player, int cash){
		player.cash += cash;
		PlayerList.getInstance().banker.cash -= cash;
	}
	
	private void birthday(Player player){
		PlayerList pl = PlayerList.getInstance();
		if(pl.players[0].equals(player)){
			player.cash += 10;
			pl.players[1].cash -= 10;
		} else {
			player.cash += 10;
			pl.players[0].cash -= 10;
		}
	}
	
	private void opera(Player player){
		PlayerList pl = PlayerList.getInstance();
		if(pl.players[0].equals(player)){
			player.cash += 50;
			pl.players[1].cash -= 50;
		} else {
			player.cash += 50;
			pl.players[0].cash -= 50;
		}
	}

}
