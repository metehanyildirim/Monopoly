
public class FreePark extends Square{

	public FreePark(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String landedOn(Player player) {
		return player.name + " advance to " + this.name;
	}

}
