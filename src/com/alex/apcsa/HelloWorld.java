package com.alex.apcsa;

/**
 * 
 * @author alex <agentleader1@gmail.com>
 *
 */
public class HelloWorld {

	public static void main(String[] args) {
		println("Hello World!");
		printf(true, "My name is %s, and this is my basic HelloWorld starter program file.", "Alex");
		print("\nI hope you will find great help through this project repo.\nBut please do shoot me an email if you need help with AP-CS! lol");
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
