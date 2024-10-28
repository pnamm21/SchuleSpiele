package org.example.Diagramme;

import java.awt.*;

public class Diagram {

	public void draw(Graphics2D g) {
		// Task 1
//		g.drawLine(0,100,400,500);
//		g.drawLine(80,100,400,500);
//		g.drawLine(160,100,400,500);
//		g.drawLine(240,100,400,500);
//		g.drawLine(320,100,400,500);
//		g.drawLine(400,100,400,500);
//		g.drawLine(480,100,400,500);
//		g.drawLine(560,100,400,500);
//		g.drawLine(640,100,400,500);
//		g.drawLine(720,100,400,500);
//		g.drawLine(800,100,400,500);

		// Task 2
//		int x = 0;
//		g.drawLine(400,500,x,100);
//		for (int i = 0; i < 10; i++) {
//			x = x + 80;
//			g.drawLine(400,500,x,100);
//		}

//		for (int x = 0; x <= 800; x += 80) {
//			g.drawLine(400, 500, x, 100);
//		}

// Karos // Task 3
//		for (int i = 10; i <= 1000; i+=10) {
//			for (int j = 10; j <= 1000; j+=10) {
//				g.drawLine(i,0,i,j);
//				g.drawLine(0,j,i,j);
//			}
//		}
//		g.setBackground(Color.darkGray);
//		g.fillRect(0,0,2000,1000);
//		g.setColor(Color.white);
//		for (int y = 0; y < 1000; y+=20) {
//			for (int x = 0; x < 1000; x+=20) {
//				g.drawLine(0,y,1000,y);
//				g.drawLine(x,y,x,1000);
//			}
//		}

		// Task 4
//		g.setBackground(Color.darkGray);
//		g.fillRect(0,0,2000,1000);
//		g.setColor(Color.white);
//
//		for (int x = 0; x < 800; x+=20) {
//			g.drawLine(800,0,x,600);
//			g.drawLine(0,0,x,600);
//		}
	}
	public void drawMuster(Graphics2D g){
		// Task 5.1
//		g.setBackground(Color.darkGray);
//		g.fillRect(0,0,2000,1000);
//		g.setColor(Color.white);
//
//		int y = 50;
//		for (int x = 50; x < 1500; x+=50) {
//			g.drawLine(x,0,0,y);
//			y+=50;
//		}
//
//		int y1 = 75;
//		for (int x = 25; x < 1500; x+=25) {
//			g.drawLine(x,0,0,y1);
//			y1+=75;
//		}

		// Task 5.2
//		for (int y = 0; y <= 600 ; y+=20) {
//			g.drawLine(0,y,800,y-80);
//		}
//		for (int x = 0; x < 1200; x+=20) {
//			g.drawLine(x,0,x-400,600);
//		}
	}
	public void drawFan(Graphics2D g) {
//		for (int x = 0; x <= 800; x += 80) {
//			g.drawLine(400, 500, x, 100);
//		}
	}
	public void drawSomething(Graphics2D g) {
//		int x;
//		x = 0;
//		for (int i=0; i<=800; i+=80) {
//			x = x + 20;
//			g.drawLine(x,0,x-200, 600);
//		}
//		x = -200;
//		for (int i=0; i<50; i++) {
//			x = x + 20;
//			g.drawLine(x, 0, x+200, 600);
//		}
	}
	public void drawSomethingArray(Graphics2D g) {

		//		int[] x = {24, 94, 200, 331, 469, 600, 706, 776};
//		int[] y = {363, 243, 154, 106, 106, 154, 243, 363};
//
//		for (int i = 0; i < x.length; i++) {
//			g.drawLine(400, 500, x[i], y[i]);
//		}
//
//		for (int i = 0; i < x.length - 1; i++) {
//			g.drawLine(x[i], y[i++], x[i], y[i--]);
//		}


//		int[] z = {5,2,8};
//		int x = 0;
//		for (int i = 0; i < z.length; i++) {
//			x = x + z[i];
//			System.out.println(i);
//			System.out.println("---------------");
//			System.out.println(x);
//		}
//		System.out.println(x);


	}



}
