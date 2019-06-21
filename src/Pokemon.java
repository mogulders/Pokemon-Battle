
public abstract class Pokemon {
	int hp;
	String type;
	boolean hasFainted;
	boolean hasTypeAdvantage;
	boolean goesFirst;
	int move;
	
	Pokemon(String type, int hp){
		this.type=type;
		this.hp = hp;
	}
	
	public void setMove(int mov) {
		move = mov;
	}
	public int getMove() {
		return move;
	}
	
	/*public int getHealthPoints() {
		return 175;
	}*/
	
	public String getType() {
		return type;
	}
	
	public void decreaseHP(int dam) {
		hp -= dam;
	}
	public int getNewHP() {
		return hp;
	}
	
	abstract public String toStringDuringBattle();
	
	public void setTypeAdvantage(boolean ty) {
		hasTypeAdvantage = ty;
	}
	
	public void goesFirst(boolean first) {
		goesFirst=first;
	}
	
	public boolean getTypeAdvantage() {
		return hasTypeAdvantage;
	}
	
	public void hasFainted(boolean faint) {
		hasFainted=faint;
	}
	
	public abstract void getMoves();
	public abstract int move1();
	public abstract int move2();

	
}
