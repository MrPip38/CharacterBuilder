
public class Characteristic {
	private int value, startingValue;
	private final int NUMDICEROLLSNORMAL = 2;
	private final int NUMDICEROLLSMODIFIED = 3;
	private String name;
	
	public Characteristic(String name, int startingValue) {
		this.name = name;
		this.startingValue = startingValue;
		this.value = startingValue;
	}
	
	public void rollForValue() {
		int result = 0;
		for (int i = 0; i < NUMDICEROLLSNORMAL; i++) {
			result += DiceRoller.roll();
		}
		this.value = this.startingValue + result;
	}
	
	public void rollForValue(char modifier) {
		int result = 0;
		int[] rolls = new int[NUMDICEROLLSMODIFIED];
		int min = 11, max = 0;
		
		for (int i = 0; i < rolls.length; i++) {
			rolls[i] = DiceRoller.roll();
			result += rolls[i];
			if (rolls[i] < min) { min = rolls[i]; }
			if (rolls[i] > max) { max = rolls[i]; }
		}
		
		if (modifier == '+') { result -= min; }
		if (modifier == '-') { result -= max; }
		
		this.value = this.startingValue + result;
	}
	
	public int getValue() { return value; }
	public void setValue (int value) {this.value = value; }
	public String getName() { return name; }
	public int getStartValue() { return this.startingValue; }
	public void setStartingValue (int value) {
		this.startingValue = value;
		this.value = value;
	}
}
