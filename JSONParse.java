import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;


public class JSONParse {
	JSONObject propertyList;
	JSONObject list;
	
	public JSONParse(JSONObject propertyList, JSONObject list){
		this.propertyList = propertyList;
		this.list = list;
		parseProperties();
		parseChance();
		parseChest();
	}
	
	public void parseProperties(){
		JSONArray landlist = (JSONArray) propertyList.get("1");
		JSONArray raillist = (JSONArray) propertyList.get("2");
		JSONArray companylist = (JSONArray) propertyList.get("3");
		SquareList sl = SquareList.getInstance();
		sl.addLand(landlist);
		sl.addRails(raillist);
		sl.addCompanies(companylist);
		sl.addTaxSQs();
		sl.addJails();
	}
	
	public void parseChance(){
		JSONArray thelist = (JSONArray)list.get("chanceList");
		ChanceList cl = ChanceList.getInstance(thelist); // This creates a chanceList singleton queue
	}
	
	public void parseChest(){
		JSONArray thelist = (JSONArray)list.get("communityChestList");
		ChestList cl = ChestList.getInstance(thelist); // This creates a chestlist queue
	}
	
}
