public class RailRoad extends PropertySQ{
	
	
	@Override
	public String landedOn(Player player) {
		PlayerList pl = PlayerList.getInstance();
		Player otherplayer;
		if(player.name.equals(pl.players[0].name)){
			otherplayer = pl.players[1];
		} else {
			otherplayer = pl.players[0];
		}
		if(player.doesOwn(this)){ // If the property is owned by the player
			return player.name + " has " + this.name;// himself then just return.
		}
		
		if(this.isOwned){
			int rent = calcRent(player);
			player.cash -= rent;
			otherplayer.cash += rent;
			return player.name + " paid rent for " + this.name;
		} else {
			player.buyProperty(this);
			return player.name + " bought " + this.name;
		}
	}
	
	public RailRoad(String name, int price) {
		super(name, price);
	}
	
	public int calcRent(Player player){
		PlayerList players = PlayerList.getInstance();
		if(player.equals(players.players[0])){
			return players.players[1].numOfRailRoads()*25;
		} else {
			return players.players[0].numOfRailRoads()*25;
		}
	}
}
