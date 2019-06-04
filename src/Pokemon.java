
public abstract class Pokemon {
	int hp = 175;
	String type;
	//may not need both booleans as they may opperate in exact same way remember to remove getters/setters with also may not need to set speed
	boolean hasTypeAdvantage;
	int move;
	
	public void setMove(int mov) {
		move = mov;
	}
	public int getMove() {
		return move;
	}
	
	public int getHealthPoints() {
		return 175;
	}
	
	public String getType() {
		return type;
	}
	
	public void decreaseHP(int dam) {
		hp -= dam;
	}
	public int getNewHP() {
		return hp;
	}
	
	public void setTypeAdvantage(boolean ty) {
		hasTypeAdvantage = ty;
	}
	public boolean getTypeAdvantage() {
		return hasTypeAdvantage;
	}
	
	
	
	
	public abstract void getMoves();
	public abstract int move1();
	public abstract int move2();

	
}
