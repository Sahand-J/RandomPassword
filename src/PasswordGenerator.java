import java.util.Random;

/**
 * Class to generate random 16 character sized password Password is generated in
 * the console 1/3/18 console output, GUI improvement will be made later
 * 
 * @author sahand-j
 */
public class PasswordGenerator {

	private int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private String letters = "abcdefghijklmnopqrstuvwxyz";
	private String CapLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String symbols = "!#$%&@";

	/**
	 * returns random number between desired range source
	 * https://www.mkyong.com/java/java-generate-random-integers-in-a-range/
	 * 
	 * @param min
	 *            minimum int range
	 * @param max
	 *            max int range
	 * @return random number between input range
	 */
	private static int getRandomNumberInRange(int min, int max) {
		if (min >= max)
			throw new IllegalArgumentException("max must be greater than min");

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	/**
	 * main method to output random password
	 * 
	 * @return random password 16 characters in size
	 */
	private String PasswordOutput() {
		String password = "";
		int i = 0;

		while (password.length() < 16) {
			int r = getRandomNumberInRange(0, 21);
			if (r % 2 == 0) { // lower case letters
				if (r < letters.length() + 1) {
					password += letters.substring(r, r + 1);
				}
			}
			if (r % 3 == 0) { // upper case letters
				password += CapLetters.substring(i, i + 1);
			}

			if (r % 7 == 0) { // numbers
				if (r < numbers.length) {
					{
						password += numbers[r];
					}
				}
				if (r % 4 == 0 || i % 5 == 0 || i % 6 == 0) { // symbols
					if (r < symbols.length() + 1) {
						password += symbols.substring(r, r + 1);
					}
				}
			}
			i++;
		}
		return password;
	}

	/**
	 * main method to execute program
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		PasswordGenerator p = new PasswordGenerator();
		System.out.println(p.PasswordOutput());
	}

}
