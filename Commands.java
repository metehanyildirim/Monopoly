import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Commands {
	ArrayList<String> commands = new ArrayList<String>();
	ArrayList<String> output = new ArrayList<String>();
	public Commands(Scanner in){
		while(in.hasNext()){
			commands.add(in.nextLine());
		}
		commands.add("show()");
		parseCommands();
	}
	
	public void parseCommands(){
		PlayerList pl = PlayerList.getInstance();
		Player player1 = pl.players[0]; // Player 1
		Player player2 = pl.players[1]; // Player 2
		for(String command : commands){
			if(command.equals("show()")){
				output.add("-----------------------------------------------------------------------------------------------------------");
				String owned = "";
				for(PropertySQ own : player1.owned)
					owned += "," + own.name;
				if(!owned.isEmpty())
					owned = owned.substring(1);
				output.add(player1.name + "\t" + player1.cash + "\thave: " + owned);
				owned = "";
				for(PropertySQ own : player2.owned)
					owned += "," + own.name;
				if(!owned.isEmpty())
					owned = owned.substring(1);
				output.add(player2.name + "\t" + player2.cash + "\thave: " + owned);
				output.add(pl.banker.name + "\t" + pl.banker.cash);
				if(player1.cash < player2.cash){
					output.add("Winner Player 2");
				} else if(player1.cash > player2.cash){
					output.add("Winner Player 1");
				} else{
					output.add("Draw");
				}
				output.add("-----------------------------------------------------------------------------------------------------------");
			} else {
				StringTokenizer st = new StringTokenizer(command, ";");
				String playername = st.nextToken();
				int dice = Integer.parseInt(st.nextToken());
				if(playername.equals(player1.name)){
					output.add(player1.rollTheDice(dice));
					if(output.get(output.size() - 1).contains(" goes bankrupt")){
						break;
					}
				} else {
					output.add(player2.rollTheDice(dice));
					if(output.get(output.size() - 1).contains(" goes bankrupt")){
						break;
					}
				}
			}
		}
		output.add("-----------------------------------------------------------------------------------------------------------");
		String owned = "";
		for(PropertySQ own : player1.owned)
			owned += "," + own.name;
		if(!owned.isEmpty())
			owned = owned.substring(1);
		output.add(player1.name + "\t" + player1.cash + "\thave: " + owned);
		owned = "";
		for(PropertySQ own : player2.owned)
			owned += "," + own.name;
		if(!owned.isEmpty())
			owned = owned.substring(1);
		output.add(player2.name + "\t" + player2.cash + "\thave: " + owned);
		output.add(pl.banker.name + "\t" + pl.banker.cash);
		if(player1.cash < player2.cash){
			output.add("Winner Player 2");
		} else if(player1.cash > player2.cash){
			output.add("Winner Player 1");
		} else{
			output.add("Draw");
		}
		output.add("-----------------------------------------------------------------------------------------------------------");
		try {
			writeToFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeToFile() throws FileNotFoundException{
		PrintWriter writer = new PrintWriter("output.txt");
		for(String s : output){
			writer.println(s);
		}
		writer.close();
	}
}
