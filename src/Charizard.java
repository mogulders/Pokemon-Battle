
public class Charizard extends Pokemon {
	
	String type = "fire";
	int hp = super.getHealthPoints();
	String ember = "Ember";
	String flamethrower = "Flamethrower";
	boolean hasTypeAdvantage = false;
	int damage;
	
	
	@Override
	public int move1() {
		System.out.println("Ember!");
		int pp = 5;
		damage = 40;
		return damage;
	}
	@Override
	public int move2() {
		System.out.println("Flamethrower!");
		int pp = 5;
		damage = 60;
		return damage;
	}
	
	@Override
	public void getMoves() {
		System.out.println("Move 1: "+ ember + " does 40 damage without type advantage. "+ "\nMove 2: " + flamethrower +
				" does 60 damage without type advantage. ");
	}
	
	public String toString() {
		return "Charizard has " + hp + " hp, and is of type "+ type; 
	}
}
