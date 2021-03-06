package com.alex.apcs.projects.recursion;

import java.awt.Color;
import java.awt.Font;

//? A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 
 * @author Alex Chiang <agentleader1@gmail.com>
 *
 */
public class RecursiveCircles extends JPanel {

	private static final long serialVersionUID = -587499556685543548L;

	public RecursiveCircles() {
		setSize(640, 480);
		setBackground(Color.WHITE);
		setVisible(true);
	}

	@Override
	public void paintComponent(Graphics window) {
		super.paintComponent(window);
		window.setColor(Color.ORANGE);
		window.setFont(new Font("TAHOMA", Font.BOLD, 12));

		window.drawString("Lab21a", 20, 40);
		window.drawString("Drawing Circles Using Recursion ", 20, 80);
		drawCircles(window, 10, 10);
	}

	public void drawCircles(Graphics window, int x, int y) {
		// base case
		window.setColor(Color.BLUE);

		window.drawOval(90 + x, 90 + y, 20 + x, 20 + x);
		
		if (x < 90 || y < 90)
			drawCircles(window, x + 10, y + 10);
	}
}