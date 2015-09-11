import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TextHelper {
	private File file;
	private FileReader fr;
	private BufferedReader br;
	private Scanner in;
	
	public TextHelper() {
		in = new Scanner(System.in);
	}
	
	public void printImperialAquila() {
		try {
			//make a 'file' object
			file = new File("aquila.txt");
			//Get data from this file using a file reader
			fr = new FileReader(file);
			//To store the contents read via file reader
			br = new BufferedReader(fr);
			//Read br and store a line in 'data', print data
			String data;
			try {
				while (br.readLine() != null) {
					data = br.readLine();
					System.out.println(data);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getIntegerInRange(String prompt, int min, int max) {
		int selection = min - 1;
		
		do {
			System.out.println(prompt);
			try {
				selection = in.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("Invalid number entered.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (selection < min || selection > max);
		
		return selection;
	}
	
	public boolean getYesNo(String prompt) {
		while (true) {
			System.out.println(prompt);
			
			char selection = in.next().toLowerCase().charAt(0);
			if (selection == 'y') {
				return true;
			} else if (selection == 'n') {
				return false;
			} else {
				System.out.println("Invalid selection.");			}
		}
	}
}
