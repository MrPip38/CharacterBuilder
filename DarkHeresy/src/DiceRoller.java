import java.util.Random;

public final class DiceRoller {
	private DiceRoller() {}
	
	public static int roll() {
		int sides = 10;
		Random random = new Random();
		return random.nextInt(sides) + 1;
	}
	
	public static int roll(int numDice) {
		int result = 0;
		int sides = 10;
		Random random = new Random();
		for (int i = 0; i < numDice; i++) {
			result += random.nextInt(sides) + 1;
		}
		return result;
	}
	
	/**
	 * Rolls dice and returns the result
	 * @param numDice The number of dice to roll.
	 * @param sides The number of sides for each die.
	 * @return The result of the dice rolls.
	 */
	public static int roll(int numDice, int sides) {
		int result = 0;
		Random random = new Random();
		for (int i = 0; i < numDice; i++) {
			result += random.nextInt(sides) + 1;
		}
		return result;
	}
}
