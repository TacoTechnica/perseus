package analysis.photo;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

/**
 * CVImageModifier.java 
 * (For now this is just a test, but might be converted 
 * 		later into a polished, more systematic class)
 */
public class CVImageModifier {

	/* LIMITS for HSV values.
	 * 
	 * These can be determined in two ways:
	 * 		1) Manually tweak to find the best ranges.
	 * 		2) Analyze image and base ranges on the background
	 * 
	 */
	Scalar lowerHSV = new Scalar(0, 0, 0);
	Scalar upperHSV = new Scalar(0, 0, 0);
	int length, width;
	
	util.FileHandler handler = null;

	public CVImageModifier(String path){
		handler = new util.FileHandler(path);
		length = handler.photo.rows();
		width = handler.photo.cols();
	}

	public double[][] getHueArray(){
		double hue[][] = new double[length][width];

		double hsv[];
		for (int xx = 0; xx < length; xx++)
			for (int yy = 0; yy < width; yy++){
				hsv = handler.photo.get(xx, yy);
				hue[xx][yy] = hsv[0];
			}
		
		return hue;
	}
	public double[][] getSaturationArray(){
		double saturation[][] = new double[length][width];

		double hsv[];
		for (int xx = 0; xx < length; xx++)
			for (int yy = 0; yy < width; yy++){
				hsv = handler.photo.get(xx, yy);
				saturation[xx][yy] = hsv[1];
			}
		
		return saturation;
	}
	public double[][] getValueArray(){
		double value[][] = new double[length][width];

		double hsv[];
		for (int xx = 0; xx < length; xx++)
			for (int yy = 0; yy < width; yy++){
				hsv = handler.photo.get(xx, yy);
				value[xx][yy] = hsv[2];
			}
		
		return value;
	}
}
