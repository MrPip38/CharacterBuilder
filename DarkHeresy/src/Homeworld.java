import java.util.ArrayList;

public abstract class Homeworld {
	protected ArrayList<Characteristic> characteristics;
	private int fateThreshold;
	private String homeworldBonus, mentalTrauma, homeworldName;
	private ArrayList<String> recBackgrounds;
	private World world;
	
	public Homeworld() {
		characteristics = new ArrayList<Characteristic>();
		recBackgrounds = new ArrayList<String>();
		fateThreshold = 0;
		homeworldBonus = "";
		mentalTrauma = "";
		homeworldName = "";		
	}
	
	public void setHomeworld() {
		TextHelper th = new TextHelper();
		String homeworldPrompt = "Select a homeworld:\n1. Feral World | 2. Forge World | 3. Highborn | 4. Hive World | 5. Shrine World | 6. Voidborn";
		int selection = th.getIntegerInRange(homeworldPrompt,  1,  6);
		
		switch (selection) {
		case 1:
			world = World.FERAL_WORLD;
			break;
		case 2:
			world = World.FORGE_WORLD;
			break;
		case 3:
			world = World.HIGHBORN;
			break;
		case 4:
			world = World.HIVE_WORLD;
			break;
		case 5:
			world = World.SHRINE_WORLD;
			break;
		case 6:
			world = World.VOIDBORN;
			break;
		default:
			world = World.FERAL_WORLD;
			break;
		}
		
		setHomeworldValues();
	}
	
	private void setFateThreshold(int subtractScore, int minValue) {
		fateThreshold = DiceRoller.roll(1,  5) - subtractScore;
		if (fateThreshold < minValue) { fateThreshold = minValue; }
	}
	
	private void setHomeworldValues() {
		switch (world) {
		case FERAL_WORLD:
			// Homeworld name
			
			// Homeworld Bonus
			
			// Signature Mental Trauma
			
			// Recommended backgrounds
			
			break;
		case FORGE_WORLD:
			// Homeworld name
			
			// Homeworld Bonus
			
			// Signature Mental Trauma
			
			// Recommended backgrounds
			
			break;
		case HIGHBORN:
			// Homeworld name
			
			// Homeworld Bonus
			
			// Signature Mental Trauma
			
			// Recommended backgrounds
			
			break;
		case HIVE_WORLD:
			// Homeworld name
			
			// Homeworld Bonus
			
			// Signature Mental Trauma
			
			// Recommended backgrounds
			
			break;
		case SHRINE_WORLD:
			// Homeworld name
			
			// Homeworld Bonus
			
			// Signature Mental Trauma
			
			// Recommended backgrounds
			
			break;
		case VOIDBORN:
			// Homeworld name
			
			// Homeworld Bonus
			
			// Signature Mental Trauma
			
			// Recommended backgrounds
			
			break;
		default:
			break;
		}
	}
	
	public void print() {
		TextHelper th = new TextHelper();
		th.printImperialAquila();
		StringBuilder s = new StringBuilder();
		s.append("Homeworld: " + this.getName() + "\n");
		s.append("Fate Threshold: " + this.getFate() + "\n");
		s.append("Homeworld Bonus: " + this.getHomeworldBonus() + "\n");
		s.append("Signature Mental Trauma: " + this.getTrauma() + "\n");
		s.append("Recommended Backgrounds: " + this.printRecBackgrounds() + "\n");
		s.append("Characteristics:\n" + this.printCharacteristics() + "\n");
	}
	
	public abstract void setCharacteristicScores();
	
	public World getWorld() { return this.world; }
	public String getName() { return this.homeworldName; }
	public int getFate() { return this.fateThreshold; }
	public String getHomeworldBonus() { return this.homeworldBonus; }
	public String getTrauma() { return this.mentalTrauma; }
	public ArrayList<String> getBRecBackgrounds() { return this.recBackgrounds; }
	
	private String printRecBackgrounds() {
		String s = "";
		for (int i = 0; i < this.recBackgrounds.size() - 1; i ++) {
			s += this.recBackgrounds.get(i) + ", ";
		}
		s += this.recBackgrounds.get(this.recBackgrounds.size() - 1);
		return s;
	}
	
	private String printCharacteristics() {
		String s = "| ";
		for (Characteristic c : this.characteristics) {
			s += c.getName() + " (" + c.getValue() + ") | ";
		}
		return s;
	}
}
