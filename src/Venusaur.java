
public class Venusaur extends Pokemon {
	
	Venusaur() {
		super("leaf",120);
		// TODO Auto-generated constructor stub
	}

	String type = "leaf";
	int hp = getNewHP();
	String vineWhip = "Vine Whip";
	String solarBeam = "Solar Beam";
	int speed;
	boolean hasTypeAdvantage = false;
	int damage;
	
	
	@Override
	public int move1() {
		System.out.println("Vine Whip!");
		int pp = 5;
		damage = 40;
		return damage;
	}
	@Override
	public int move2() {
		System.out.println("Solar Beam!");
		int pp = 5;
		damage = 60;
		return damage;
	}
	
	@Override
	public void getMoves() {
		System.out.println("Move 1: "+ vineWhip + " does 40 damage without type advantage. "+ "\nMove 2: " + solarBeam +
				" does 60 damage without type advantage. ");
	}
	//how do i set the speed for each pokemon object
	//i need to put that within the typeadvantage if loops
	public void setSpeed(int s) {
		speed=s;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public String toString() {
		return "Venusaur, " + getNewHP() +" "+ type; 
	}
	
	@Override
	public String toStringDuringBattle() {
		return "Venusaur,";
	}
	
}
