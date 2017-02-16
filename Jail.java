
public class Jail extends Square{

	public Jail(String name) {
		super(name);
	}

	@Override
	public String landedOn(Player player) {
		player.jailcount++;
		player.position = 10;
		return player.name + " went to jail";
	}

}
