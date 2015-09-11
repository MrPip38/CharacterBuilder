
public class Character {
	Homeworld homeworld;
	int creationMethod;
	
	public Character() {
		getCreationType();
		createHomeworld();
	}
	
	private void getCreationType() {
		TextHelper th = new TextHelper();
		String prompt = "Select a character creation method (1. Roll for stats | 2. Allocate points)";
		this.creationMethod = th.getIntegerInRange(prompt, 1, 2);
	}
	
	private void createHomeworld() {
		if (creationMethod == 1) {
			homeworld = new HomeworldFast();
		} else {
			homeworld = new HomeworldComplex();
		}
		
		homeworld.setHomeworld();
		homeworld.setCharacteristicScores();
	}
	
	public void printCharacter() {
		homeworld.print();
	}
}
