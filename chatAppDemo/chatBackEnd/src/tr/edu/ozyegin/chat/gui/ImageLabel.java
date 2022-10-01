package tr.edu.ozyegin.chat.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.MediaTracker;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLabel extends Label implements Runnable {
	private static Image im;
	private MediaTracker mt;
	private String path;

	public ImageLabel(Image m) {
		mt = new MediaTracker(this);
		im = m;
		mt.addImage(im, 0);

	}

	public ImageLabel() {
		try {			
			path = "notconnected.png";
			im = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// **//METHODS
	public void run() {
		try {
			mt.waitForID(0);
		} catch (InterruptedException ie) {
			System.out.println("The loading process for an image was interrupted");
		}
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		g.drawImage(im, 40, 5, 50, 50, this);
	}

	public Image getIm() {
		return im;
	}

	public static void setIm(Image image) {
		im = image;
	}

}