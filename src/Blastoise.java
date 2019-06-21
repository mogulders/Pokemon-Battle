
public class Blastoise extends Pokemon {
	
	Blastoise() {
		super("water",120);
		
		// TODO Auto-generated constructor stub
	}

	String type = "water";
	int hp = getNewHP();
	String waterGun = "Water Gun";
	String hydroPump = "Hydro Pump";
	boolean hasTypeAdvantage = false;
	int damage;
	
	
	
	@Override
	public int move1() {
		System.out.println("Water Gun!");
		int pp = 5;
		damage = 40;
		return damage;
	}
	@Override
	public int move2() {
		System.out.println("Hydro Pump!");
		int pp = 5;
		damage = 60;
		return damage;
	}
	
	@Override
	public void getMoves() {
		System.out.println("Move 1: "+ waterGun + " does 40 damage without type advantage. "+ "\nMove 2: " + hydroPump +
				" does 60 damage without type advantage. ");
	}
	
	public String toString() {
		return "Blastoise, " + getNewHP() +" "+ type; 
	}
	
	@Override
	public String toStringDuringBattle() {
		return "Blastoise,";
	}
}
