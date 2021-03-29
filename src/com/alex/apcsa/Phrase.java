package com.alex.apcsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author alex <agentleader1@gmail.com>
 * @comment 2017 AP-CS FRQ #3
 * 
 */
public class Phrase {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		print("Insert String: ");
		String str = reader.readLine();
		print("Insert Phrase: ");
		String phrase = reader.readLine();
		int occ = -1;
		do {
			print("Insert Occurence: ");
			try {
				occ = Integer.parseInt(reader.readLine());
				if (occ < 0) {
					println("Invalid number, try again.");
				} else {
					break;
				}
			} catch (NumberFormatException ex) {
				println("Not a number, try again.");
			}
			println();
		} while (occ >= 0);
		Phrase phr = new Phrase(str);
		println("Index of the " + occ + "th occurence: " + phr.findNthOccurrence(phrase, occ));
		phr.replaceNthOccurence(phrase, occ, "dub");
		println("Replacing the " + occ + "th occurrence of the phrase with \"dub\": " + phr.toString());
		println("Last occurrence of the phrase: " + phr.findLastOccurrence(phrase));
		reader.close();
	}

	private String currentPhrase;

	public Phrase(String p) {
		currentPhrase = p;
	}

	/**
	 * @return Returns the index of the nth occurrence of str in the current phrase;
	 * @return -1 if the nth occurrence does not exist. Precondition: str.length() >
	 *         0 and n > 0 Postcondition: the current phrase is not modified.
	 * 
	 */
	public int findNthOccurrence(String str, int n) {
		if (toString().length() < str.length())
			return -1;
		int current = 1;
		int ind = -1;
		for (int i = 0; i < toString().length() - str.length() + 1; i++) {
			if (toString().substring(i, i + str.length()).equalsIgnoreCase(str)) {
				if (current == n) {
					ind = i;
					break;
				} else {
					current++;
				}
			}
		}
		return ind;
	}

	/**
	 * 
	 * @param str  Phrase to be replaced
	 * @param n    The occurrence of the phrase to be replaced
	 * @param repl The replacement string
	 */
	public void replaceNthOccurence(String str, int n, String repl) {
		int index = findNthOccurrence(str, n);
		if (index == -1)
			return;
		currentPhrase = currentPhrase.substring(0, index) + repl + currentPhrase.substring(index + str.length());
	}

	public int findLastOccurrence(String str) {
		boolean found = false;
		int last = 1;
		int ind = -1;
		if (findNthOccurrence(str, last) == -1)
			return ind;
		while (!found) {
			int i = findNthOccurrence(str, last + 1);
			if (i != -1) {
				last++;
				ind = i;
			} else {
				found = true;
			}
		}
		return ind;
	}

	@Override
	public String toString() {
		return currentPhrase;
	}

	public static void print(Object... objs) {
		for (Object obj : objs) {
			System.out.print(obj);
		}
	}

	public static void println(Object... objs) {
		if (objs.length <= 0) {
			System.out.println();
		} else {
			for (Object obj : objs) {
				System.out.println(obj);
			}
		}
	}

	public static void printf(boolean newLine, String format, Object... objs) {
		System.out.printf(format, objs);
		if (newLine)
			println();
	}
}
