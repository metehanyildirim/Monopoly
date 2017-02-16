
public class Land extends PropertySQ {
	public double rent;
	
	public Land(String name, int price){
		super(name, price);
		if(price <= 2000)
			rent = (double)price * 40 / 100;
		else if(price <= 3000)
			rent = (double)price * 30 / 100;
		else
			rent = (double)price * 35 / 100;
	}

	@Override
	public String landedOn(Player player) {
		PlayerList pl = PlayerList.getInstance();
		Player otherplayer;
		if(player.name.equals(pl.players[0].name)){
			otherplayer = pl.players[1];
		} else {
			otherplayer = pl.players[0];
		}
		if(player.doesOwn(this))
			return player.name + " has " + this.name;
		if(this.isOwned){
			player.cash -= rent;
			otherplayer.cash += rent;
			return player.name + " paid rent for " + this.name;
		} else {
			player.buyProperty(this);
			return player.name + " bought " + this.name;
		}
	}
	
}
