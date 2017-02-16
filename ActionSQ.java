
public abstract class ActionSQ extends Square{

	
	public ActionSQ(String name) {
		super(name);
	}

	public abstract String pickACard(Player player);
	
	@Override
	public String landedOn(Player player){
		return pickACard(player);
	}
}
