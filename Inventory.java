import java.util.Random;

public class Inventory {
	
	private ArrayStack<Bun> buns;
	private ArrayStack<Patty> patties;
	private ArrayStack<Cheese> cheese;
	private ArrayStack<Onion> onions;
	private ArrayStack<Lettuce> lettuce;
	private ArrayStack<Tomato> tomatoes;
	
	public Inventory(){
		this.buns = new ArrayStack<Bun>();
		this.patties = new ArrayStack<Patty>();
		this.cheese = new ArrayStack<Cheese>();
		this.onions = new ArrayStack<Onion>();
		this.lettuce = new ArrayStack<Lettuce>();
		this.tomatoes = new ArrayStack<Tomato>();
	}
	
	public boolean makeBurger(){
		if(buns.isEmpty() || patties.isEmpty() || tomatoes.isEmpty() || onions.isEmpty() || lettuce.isEmpty())
			return false;
		else
		{
			buns.pop();
			patties.pop();
		
			onions.pop();
			lettuce.pop();
			tomatoes.pop();
		}
		return true;
	}
	
	public boolean makeCheeseBurger(){
		if(cheese.isEmpty() || buns.isEmpty() || patties.isEmpty() ||tomatoes.isEmpty()
				|| onions.isEmpty() || lettuce.isEmpty())
			return false;
		else
		{
			cheese.pop();
			buns.pop();
			patties.pop();
			cheese.pop();
			onions.pop();
			lettuce.pop();
			tomatoes.pop();
		}
		return true;
	}
	
	public boolean makeVeganBurger(){
		if(lettuce.size() < 2 || tomatoes.isEmpty() || onions.isEmpty())
			return false;
		else
		{
			lettuce.pop();
			lettuce.pop();
			tomatoes.pop();
			onions.pop();
		}
		return true;
	}
	
	public boolean makeNoOnionBurger(){
		if(buns.isEmpty() || patties.isEmpty() || tomatoes.isEmpty() || lettuce.isEmpty())
			return false;
		else
		{
			buns.pop();
			patties.pop();
			//onions.pop();
			lettuce.pop();
			tomatoes.pop();
		}
		return true;
	}
	
	public boolean makeNoOnionCheeseBurger(){
		if(cheese.isEmpty() || buns.isEmpty() || patties.isEmpty() ||tomatoes.isEmpty()
				 || lettuce.isEmpty())
			return false;
		else
		{
			cheese.pop();
			buns.pop();
			patties.pop();
			cheese.pop();
			//onions.pop();
			lettuce.pop();
			tomatoes.pop();
		}
		return true;
	}
	
	public boolean makeNoTomatoBurger(){
		if(buns.isEmpty() || patties.isEmpty() || onions.isEmpty() || lettuce.isEmpty())
			return false;
		else
		{
			buns.pop();
			patties.pop();
		
			onions.pop();
			lettuce.pop();
			//tomatoes.pop();
		}
		return true;
	}
	
	public void receiveShipment(int deliveryDate){
		Random rand = new Random();
		int numBuns = rand.nextInt(301) + 700;
		for (int i = 0; i < numBuns; i++){
			Bun b = new Bun();
			b.setExpirationDate(deliveryDate + 5);
			buns.push(b);
		}
		int numPatties = rand.nextInt(301) + 700;
		for (int i = 0; i < numPatties; i++){
			Patty p = new Patty();
			p.setExpirationDate(deliveryDate + 4);
			patties.push(p);
		}
		
		int numLettuce = rand.nextInt(301) + 700;
		for (int i = 0; i < numLettuce; i++){
			Lettuce l = new Lettuce();
			l.setExpirationDate(deliveryDate + 3);
			lettuce.push(l);
		}
		
		int numTomato = rand.nextInt(301) + 700;
		for (int i = 0; i < numTomato; i++){
			Tomato t = new Tomato();
			t.setExpirationDate(deliveryDate + 3);
			tomatoes.push(t);
		}
		
		int numOnion = rand.nextInt(301) + 700;
		for (int i = 0; i < numOnion; i++){
			Onion o = new Onion();
			o.setExpirationDate(deliveryDate + 5);
			onions.push(t);
		}
		
		int numCheese = rand.nextInt(301) + 700;
		for (int i = 0; i < numCheese; i++){
			Cheese c = new Cheese();
			c.setExpirationDate(deliveryDate + 2);
			cheese.push(c);
		}
	}
	private int sortCheese(int currentDate){
		FoodItem[] tempArray = new Cheese[cheese.size()];
		int wasteCheese = 0;
		for(int i = 0; i < tempArray.length; i++){
			tempArray[i] = cheese.pop();
		}
		selectionFoodSort(tempArray);
		for(int i = 0; i < tempArray.length; i++){
			Cheese c = (Cheese) tempArray[i];
			if(currentDate < c.getExpirationDate()){
				cheese.push(c);
			}
			else
				wasteCheese++;
		}
		return wasteCheese;
	}
	
	private int sortBuns(int currentDate){
		FoodItem[] tempArray = new Bun[buns.size()];
		int wasteBun = 0;
		for(int i = 0; i < tempArray.length; i++){
			tempArray[i] = buns.pop();
		}
		selectionFoodSort(tempArray);
		for(int i = 0; i < tempArray.length; i++){
			Bun b = (Bun) tempArray[i];
			if(currentDate < b.getExpirationDate()){
				buns.push(b);
			}
			else
				wasteBun++;
		}
		return wasteBun;
	}
	
	private int sortPatties(int currentDate){
		FoodItem[] tempArray = new Patty[patties.size()];
		int wastePatty = 0;
		for(int i = 0; i < tempArray.length; i++){
			tempArray[i] = patties.pop();
		}
		selectionFoodSort(tempArray);
		for(int i = 0; i < tempArray.length; i++){
			Cheese c = (Cheese) tempArray[i];
			if(currentDate < p.getExpirationDate()){
				patties.push(p);
			}
			else
				wastePatty++;
		}
		return wastePatty;
	}
	
	
	private int sortLettuce(int currentDate){
		FoodItem[] tempArray = new Lettuce[lettuce.size()];
		int wasteLettuce = 0;
		for(int i = 0; i < tempArray.length; i++){
			tempArray[i] = lettuce.pop();
		}
		selectionFoodSort(tempArray);
		for(int i = 0; i < tempArray.length; i++){
			Lettuce l = (Lettuce) tempArray[i];
			if(currentDate < l.getExpirationDate()){
				lettuce.push(l);
			}
			else
				wasteLettuce++;
		}
		return wasteLettuce;
	}
	
	private int sortTomatoes(int currentDate){
		FoodItem[] tempArray = new Tomato[tomatoes.size()];
		int wasteTomato = 0;
		for(int i = 0; i < tempArray.length; i++){
			tempArray[i] = tomatoes.pop();
		}
		selectionFoodSort(tempArray);
		for(int i = 0; i < tempArray.length; i++){
			Tomato t = (Tomato) tempArray[i];
			if(currentDate < t.getExpirationDate()){
				tomatoes.push(t);
			}
			else
				wasteTomato++;
		}
		return wasteTomato;
	}
	
	private int sortOnions(int currentDate){
		FoodItem[] tempArray = new Onion[onions.size()];
		int wasteOnion = 0;
		for(int i = 0; i < tempArray.length; i++){
			tempArray[i] = onions.pop();
		}
		selectionFoodSort(tempArray);
		for(int i = 0; i < tempArray.length; i++){
			Onion o = (Onion) tempArray[i];
			if(currentDate < o.getExpirationDate()){
				onions.push(o);
			}
			else
				wasteOnion++;
		}
		return wasteOnion;
	}
	
	public int[] sortInventory(int currentDate){
		int wasteCheese = sortCheese(currentDate);
		int wasteBun = sortBuns(currentDate);
		int wastePatty = sortPatties(currentDate);
		int wasteLettuce = sortLettuce(currentDate);
		int wasteTomato = sortTomatoes(currentDate);
		int wasteOnion = sortOnions(currentDate);
		int[] waste = {wasteCheese, wasteBun, wastePatty,
					wasteLettuce, wasteTomato, wasteOnion};
		return waste;
	}
	
	
}
