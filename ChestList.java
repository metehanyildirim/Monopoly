import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ChestList {
	private static ChestList singleton = null;
	Queue<String> chestList = new LinkedList<String>();
	
	public static ChestList getInstance(JSONArray jsonfile){
		if(singleton == null)
			singleton = new ChestList(jsonfile);
		return singleton;
	}
	
	
	private ChestList(JSONArray parser){
		Iterator<JSONObject> iterator = parser.iterator();
		while(iterator.hasNext()){
			String input = (String) iterator.next().get("item");
			chestList.add(input);
		}
	}
	
	public String takeACard(){
		String result = chestList.poll(); // Pull the card
		chestList.add(result); // Push it to the beginning.
		return result;
	}
}
