package com.alex.apcsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author alex <agentleader1@gmail.com>
 *
 */
public class PhraseInString {

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
		println("Index of the " + occ + "th occurence: " + indexOfOccurenceOfPhraseInString(0, occ, 0, str, phrase));
		reader.close();
	}

	public static int indexOfOccurenceOfPhraseInString(int currentOcc, int finalOcc, int currentInd, String str,
			String phrase) {
		if (str.substring(currentInd, currentInd + phrase.length()).equalsIgnoreCase(phrase)) {
			if (currentOcc + 1 == finalOcc) {
				return currentInd;
			} else {
				return indexOfOccurenceOfPhraseInString(currentOcc + 1, finalOcc, currentInd + 1, str, phrase);
			}
		}
		if (str.substring(currentInd).length() < phrase.length()) {
			return -1;
		} else {
			return indexOfOccurenceOfPhraseInString(currentOcc, finalOcc, currentInd + 1, str, phrase);
		}
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
