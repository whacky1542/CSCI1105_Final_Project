# CSCI1105_Final_Project

## Description:
Java Journal Lite is a program that simulates a temporary journal that allows the user to enter text into 5 separate text entry locations.

## Purpose:
As a final project for my CSCI 1105 class at Southwest Technical College, this program showcases most of what I learned throughout the class in a single project.

## How to use:
Simply follow the prompts to use this straight foward program.

## Code Example:
This is an example of how the program displays user written text back to the user with lines the length of 50 characters without cutting apart words.
```
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
```
