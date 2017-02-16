import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try{
			Object properties = parser.parse(new FileReader("property.json"));
			Object list = parser.parse(new FileReader("list.json"));
			JSONObject propertyList = (JSONObject)properties;
			JSONObject thelist = (JSONObject)list;
			JSONParse ps = new JSONParse(propertyList, thelist);
			Scanner in = new Scanner(new FileReader(args[0]));
			Commands commands = new Commands(in);
		} catch(Exception e){
			e.printStackTrace();
		}

	}

}
