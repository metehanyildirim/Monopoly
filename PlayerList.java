
public class PlayerList {

	private static PlayerList singleton = null;
	public Player[] players = new Player[2];
	public Player banker;
	
	public static PlayerList getInstance() {
	      if(singleton == null)
	    	  singleton = new PlayerList();
	      return singleton;
	}
	
	private PlayerList(){
		players[0] = new Player(1);
		players[1] = new Player(2);
		banker = new Player();
	}
}
