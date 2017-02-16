
public class TaxSQ extends Square{
	int tax;
	
	public TaxSQ(String name, int tax) {
		super(name);
		this.tax = tax;
	}

	@Override
	public String landedOn(Player player) {
		PlayerList pl = PlayerList.getInstance();
		player.cash -= tax;
		pl.banker.cash += tax;
		return player.name + " paid Tax";
	}

}
