import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public abstract class Square {
	public String name;
	
	public abstract String landedOn(Player player);
	
	public Square(String name){
		this.name = name;
	}
}
