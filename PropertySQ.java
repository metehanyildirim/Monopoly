
public abstract class PropertySQ extends Square{
	public boolean isOwned;
	public int price;
	
	public PropertySQ(String name, int price){
		super(name);
		isOwned = false;
		this.price = price;
	}
	
}
