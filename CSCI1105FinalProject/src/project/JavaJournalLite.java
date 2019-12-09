package project;
import java.util.Scanner;

/**
 * <h1>Java Journal Lite</h1>
 * Java Journal Lite is a temporary notebook written in java! With five
 * entries to work with, the user can write and preview different text
 * entries.
 * 
 * @author Alex Johnson
 * @since 12-09-2019
 * 
 */

public class JavaJournalLite {
	
	/**
	 * The main method acts as the main menu where the user can access
	 * separate entries.
	 * 
	 * <pre>
	 * Example:
	 * New entry name: New
	 * ^would make entries[0][0] as "New"
	 * 
	 * Select an entry designation to modify: 1
	 * ^would allow the user to rename then write in entries[0]
	 * </pre>
	 * 
	 * @param args Is an array of strings accepted from the command line.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[][] entries = {
				{"Entry 1", " "},
				{"Entry 2", " "},
				{"Entry 3", " "},
				{"Entry 4", " "},
				{"Entry 5", " "}};
		int entry = 0;
		String uInput = "";
		
		System.out.print("Welcome to Java Journal Lite!\n"
				+ "New entry name: ");
		entries[0][0] = input.nextLine();
		System.out.print("Entry -" + entries[0][0] + "- has been created.\n");
		write(entries, entry);
		
		while (!uInput.toLowerCase().equals("quit")) {
			System.out.print("==================================================\n"
					+ "Entry List:\n");
			for (int i = 0; i < entries.length; i++) {
				System.out.print("\t" + (i + 1) + " - " + entries[i][0] + "\n");
			}
			System.out.print("==================================================\n" + "Select an entry designation to modify (enter \"quit\" to exit): ");
			uInput = input.nextLine();
			
			while (!uInput.equals("1") && 
					!uInput.equals("2") && 
					!uInput.equals("3") && 
					!uInput.equals("4") && 
					!uInput.equals("5") && 
					!uInput.toLowerCase().equals("quit")) {
				System.out.print("Invalid input. Please enter a number between 1 and 5: ");
				uInput = input.nextLine();
			}
			
			if (!uInput.equals("quit"))
				entry = Integer.valueOf(uInput) - 1;
			
			if (!uInput.toLowerCase().equals("quit")) {
				System.out.print("Enter a new name or the same name for slot " + uInput + ": ");
				entries[entry][0] = input.nextLine();
			}
			
			if (!uInput.toLowerCase().equals("quit")) {
				write(entries, entry);
			}
		}
	}
	
	/**
	 * The write method allows the user to add text to existing entries while also displaying the text.
	 * 
	 * <pre>
	 * Example:
	 * Write something in -New-: Hello!
	 * ^would add the string "Hello!" to entries[0][1] the display as:
	 * -------------------------------------------------------
	 *  Hello!
	 * -------------------------------------------------------
	 * </pre>
	 * 
	 * @param entries Is the previous text data held in a temporary storage.
	 * @param entry Is the current entry that is selected.
	 */
	public static void write(String[][] entries, int entry) {
		
		Scanner input = new Scanner(System.in);
		String display = entries[entry][1];
		String uInput = "";
		int lineCount = 0;
		int wordLength = 1;
		
		System.out.print("--------------------------------------------------\n");
		
		for (int i = 0; i < display.length(); i++) {
			if (display.charAt(i) == ' ') {
				while (display.charAt(i + wordLength - 1) != ' ') {
					wordLength++;
				}

				if (wordLength + lineCount > 50) {
					System.out.println();
					lineCount = 0;
				}

				wordLength = 1;
			}

			System.out.print(display.charAt(i));

			lineCount++;
		}
		
		System.out.print("\n--------------------------------------------------\n");
		
		lineCount = 0;
		
		System.out.print("Write something in -" + entries[entry][0] + "- (enter \"quit\" to exit, or enter \"enter\" to insert a line): ");
		uInput = input.nextLine();
		
		while (!uInput.toLowerCase().equals("quit")) {
			
			if (uInput.toLowerCase().equals("enter")) {
				for (int i = 0; i < 51 - lineCount; i++)
					display += " ";
			}
			else
				display += uInput;
			
			lineCount = 0;
			
			System.out.print("--------------------------------------------------\n");
			
			for (int i = 0; i < display.length(); i++) {
				
				if (display.charAt(i) == ' ') {
					while (display.charAt(i + wordLength - 1) != ' ') {
						wordLength++;
					}

					if (wordLength + lineCount > 50) {
						System.out.println();
						lineCount = 0;
					}

					wordLength = 1;
				}

				System.out.print(display.charAt(i));

				lineCount++;
			}
			
			System.out.print("\n--------------------------------------------------\n");
			
			System.out.print("Write something in -" + entries[entry][0] + "-: ");
			uInput = input.nextLine();
			
		}
		
		entries[entry][1] += display;
	}
}
