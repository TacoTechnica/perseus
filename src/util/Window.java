package util;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window {

	JFrame frame;
	JLabel label;
	BufferedImage image;

	public Window(BufferedImage img, String title) {
		this.image = img;
		frame = new JFrame(title);
		frame.setResizable(true);
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon(img);
		label = new JLabel(icon);
		frame.add(label);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(new Input());
	}

	public void close() {
		frame.dispose();
	}

	public void setImage(BufferedImage img) {
		image = img;
		ImageIcon icon = new ImageIcon(img);
		frame.remove(label);
		label = new JLabel(icon);
		frame.add(label);
		frame.pack();
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setText(String text) {
		frame.setTitle(text);
		frame.pack();
	}
}
