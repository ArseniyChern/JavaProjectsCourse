import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Block extends Rectangle{
	Image  pic;
	int dx = 3;
	int dy = -3;
	Rectangle left, right;
	boolean destroyed = false;
	boolean powerup = false;
	Block(int a, int b, int w, int h, String s){
		x = a;
		y = b;
		width = w;
		height = h;
		left = new Rectangle(a-1, b, 1, h);
		right = new Rectangle(a+w+1, b, 1, h);
		try {
			pic =  ImageIO.read(new File(
					"/Users/arseniychernykh/Documents/Courses/Projects In Java/[2] Game/Section 2/Project2 Source Code/src/"+s));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g, Component c){
		if(!destroyed)
			g.drawImage(pic, x, y, width, height, c);
	}
}
