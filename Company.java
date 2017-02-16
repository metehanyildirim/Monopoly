
public class Company extends PropertySQ{

	public Company(String name, int price) {
		super(name, price);
	}

	@Override
	public String landedOn(Player player) {
		return null;
	}

	public String landedOnCompany(Player player , int dice){
		PlayerList pl = PlayerList.getInstance();
		Player otherplayer;
		if(player.name.equals(pl.players[0].name)){
			otherplayer = pl.players[1];
		} else {
			otherplayer = pl.players[0];
		}
		if(player.doesOwn(this)){
			return player.name + " has " + this.name;
		}
		if(this.isOwned){
			player.cash -= dice * 4;
			otherplayer.cash += dice * 4;
			return player.name + " paid rent for " + this.name;
		} else {
			player.buyProperty(this);
			return player.name + " bought " + this.name;
		}
	}
}
