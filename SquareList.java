import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SquareList {
	
	public static SquareList singleton = new SquareList();
	public Square[] squareList = new Square[40];
	
	public static SquareList getInstance(){
		return singleton;
	}
	
	private SquareList(){
		
	}
	
	public void addLand(JSONArray thelist){
		Iterator<JSONObject> iterator = thelist.iterator();
		while(iterator.hasNext()){
			JSONObject square = iterator.next();
			int squareid = Integer.parseInt((String)square.get("id"));
			String name = (String)square.get("name");
			int cost = Integer.parseInt((String)square.get("cost"));
			squareList[squareid - 1] = new Land(name, cost);
		}
	}
	
	public void addRails(JSONArray thelist){
		Iterator<JSONObject> iterator = thelist.iterator();
		while(iterator.hasNext()){
			JSONObject square = iterator.next();
			int squareid = Integer.parseInt((String)square.get("id"));
			String name = (String)square.get("name");
			int cost = Integer.parseInt((String)square.get("cost"));
			squareList[squareid - 1] = new RailRoad(name, cost);
		}
	}
	
	public void addCompanies(JSONArray thelist){
		Iterator<JSONObject> iterator = thelist.iterator();
		while(iterator.hasNext()){
			JSONObject square = iterator.next();
			int squareid = Integer.parseInt((String)square.get("id"));
			String name = (String)square.get("name");
			int cost = Integer.parseInt((String)square.get("cost"));
			squareList[squareid - 1] = new Company(name, cost);
		}
	}
	
	public void addTaxSQs(){
		squareList[4] = new TaxSQ("Income Tax", 100);
		squareList[38] = new TaxSQ("Super Tax", 100);
		squareList[36] = new ChanceSQ("Chance");
		squareList[7] = new ChanceSQ("Chance");
		squareList[22] = new ChanceSQ("Chance");
		squareList[2] = new ChestSQ("Community Chest");
		squareList[17] = new ChestSQ("Community Chest");
		squareList[33] = new ChestSQ("Community Chest");
		
	}
	
	public void addJails(){
		squareList[10] = new Jail("Jail");
		squareList[30] = new Jail("Jail");
		squareList[20] = new FreePark("Free Parking");
		squareList[0] = new FreePark("GO");
		
	}
}
