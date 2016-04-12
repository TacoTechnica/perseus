package util;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/** FileHandler.java
 * 
 * Just a utility that centralizes file handling into one class, 
 * making it more easier and more systematic.
 */
public class FileHandler {
	public Mat photo = new Mat();

	public FileHandler(String path){
		photo = Imgcodecs.imread(
				FileHandler.class.getClass().getResource(path).getPath()
				);
	}

	public static void writeMatImage(String path, Mat image) {
		Imgcodecs.imwrite(path, image);
	}



}
