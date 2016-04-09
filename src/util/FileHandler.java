package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileHandler {
	public static BufferedImage loadBufferedImage(String path) {
		try {
			return ImageIO.read(FileHandler.class.getResource(path));
		} catch(IllegalArgumentException e) {
			//e.printStackTrace();
			return null;
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void writeImage(BufferedImage image, String path) {
		try {
			ImageIO.write(image, "png", new File(path));
		} catch (IOException e) {
			// Not supposed to happen.
			e.printStackTrace();
		}
	}
	
	
}
