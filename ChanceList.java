import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ChanceList {
	
	private static ChanceList singleton = null;
	Queue<String> chanceList = new LinkedList<String>();
	
	public static ChanceList getInstance(JSONArray jsonfile){
		if(singleton == null)
			singleton = new ChanceList(jsonfile);
		return singleton;
	}
	
	
	private ChanceList(JSONArray parser){
		Iterator<JSONObject> iterator = parser.iterator();
		while(iterator.hasNext()){
			String input = (String) iterator.next().get("item");
			chanceList.add(input);
		}
	}
	
	public String takeACard(){
		String result = chanceList.poll(); // Pull the card
		chanceList.add(result); // Push it to the beginning.
		return result;
	}
}
