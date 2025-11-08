package DiceRoller;

public class DiceRoll {
private int diceNumber;
private int diceSize;
private int modifier;
public DiceRoll(int diceNumber, int diceSize, int modifier) {
	super();
	this.diceNumber = diceNumber;
	this.diceSize = diceSize;
	this.modifier = modifier;
}
public int getDiceNumber() {
	return diceNumber;
}
public void setDiceNumber(int diceNumber) {
	this.diceNumber = diceNumber;
}
public int getDiceSize() {
	return diceSize;
}
public void setDiceSize(int diceSize) {
	this.diceSize = diceSize;
}
public int getModifier() {
	return modifier;
}
public void setModifier(int modifier) {
	this.modifier = modifier;
}


}
