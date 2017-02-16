import java.util.ArrayList;

public class Player {
	public int id; // ID of the player
	public int position; // Position of the player
	public int jailcount; // This is for the jail
	public int cash;
	public int cashBeforeBankrupt;
	String name;
	ArrayList<PropertySQ> owned = new ArrayList<PropertySQ>();
	
	public Player(int id){ // This constructor is for the player.
		this.id = id;
		position = 0;
		jailcount = 0;
		cash = 15000;
		name = "Player " + id;
	}
	
	public Player(){ // This constructor is for the banker.
		cash = 100000;
		name = "Banker";
	}
	
	public String rollTheDice(int dice){
		PlayerList pl = PlayerList.getInstance();
		if(isInJail()){
			String jailout = this.name + "\t" + dice + "\t" + (position + 1) + "\t" + 
					 pl.players[0].cash + "\t" + pl.players[1].cash + "\t" + this.name + " in jail (count=" + jailcount + ")";
			jailcount = (jailcount + 1) % 4;// When it is 3 it becomes 0 and Jail time is over.
			return jailout;
		}
		if(didPassGo(dice)){
			cash += 200;
			PlayerList.getInstance().banker.cash -= 200;
		}
		position = (position + dice) % 40;
		SquareList sl = SquareList.getInstance();
		Square sq = sl.squareList[position];
		String landedon;
		cashBeforeBankrupt = cash;
		if(sq instanceof Company){
			landedon = ((Company) sq).landedOnCompany(this, dice);
		} else {
			landedon = sq.landedOn(this);
		}
		if(isBankrupt()){
			if(pl.players[0].cash < 0){
				pl.players[0].cash = cashBeforeBankrupt;
			}
			if(pl.players[1].cash < 0){
				pl.players[1].cash = cashBeforeBankrupt;
			}
			owned.remove(owned.size() - 1);
			return this.name + "\t" + dice + "\t" + (position + 1) + "\t" + 
						pl.players[0].cash + "\t" + pl.players[1].cash + "\t" + this.name + " goes bankrupt";
		}
		return this.name + "\t" + dice + "\t" + (position + 1) + "\t" + 
						 pl.players[0].cash + "\t" + pl.players[1].cash + "\t" + landedon;
	}
	
	public int numOfRailRoads(){
		int counter = 0;
		for(PropertySQ ps : owned){
			if(ps instanceof RailRoad){
				counter++;
			}
		}
		return counter;
	}
	
	public void buyProperty(PropertySQ ps){
		if(!ps.isOwned){
			ps.isOwned = true;
			owned.add(ps);
			cash -= ps.price;
			Player banker = PlayerList.getInstance().banker;
			banker.cash += ps.price;
		}
	}
	
	public boolean doesOwn(PropertySQ property){
		for(PropertySQ ps : owned){
			if(ps.equals(property))
				return true;
		}
		return false;
	}
	
	public boolean didPassGo(int i){
		return (position + i) % 40 < position;
	}
	
	public boolean isInJail(){
		return jailcount != 0;
	}
	
	public boolean isBankrupt(){
		if(this.cash < 0)
			return true;
		return false;
	}
	
}
