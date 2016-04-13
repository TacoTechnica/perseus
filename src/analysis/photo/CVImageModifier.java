package analysis.photo;

import org.opencv.core.Mat;
import org.opencv.core.Scalar;

/**
 * CVImageModifier.java (For now this is just a test, but might be converted
 * later into a polished, more systematic class)
 */
public class CVImageModifier {

	/*
	 * LIMITS for HSV values.
	 * 
	 * These can be determined in two ways: 1) Manually tweak to find the best
	 * ranges. 2) Analyze image and base ranges on the background
	 * 
	 */
	Scalar lowerHSV = new Scalar(0, 0, 0);
	Scalar upperHSV = new Scalar(0, 0, 0);

	public double[][][] loadHSBArray(Mat mat) {
		int width = mat.width() - 1;
		int height = mat.height() - 1;
		double hsb[][][] = new double[3][width][height];
		for (int xx = 0; xx < width; xx++) {
			for (int yy = 0; yy < height; yy++) {
				double[] tempHSB = mat.get(xx, yy);
				try{
					hsb[0][xx][yy] = tempHSB[0];
					hsb[1][xx][yy] = tempHSB[1];
					hsb[2][xx][yy] = tempHSB[2];
				} catch (NullPointerException e){
					return hsb;
				}
			}
		}
		return hsb;
	}

	public double[][] loadHueArray(Mat mat) {
		return loadHSBArray(mat)[0];
	}

	public double[][] loadSaturationArray(Mat mat) {
		return loadHSBArray(mat)[1];
	}

	public double[][] loadValueArray(Mat mat) {
		return loadHSBArray(mat)[2];
	}
	/*
	 * public double[][] getHueArray(){ double hue[][] = new
	 * double[length][width];
	 * 
	 * double hsv[]; for (int xx = 0; xx < length; xx++) for (int yy = 0; yy <
	 * width; yy++){ hsv = handler.photo.get(xx, yy); hue[xx][yy] = hsv[0]; }
	 * 
	 * return hue; } public double[][] getSaturationArray(){ double
	 * saturation[][] = new double[length][width];
	 * 
	 * double hsv[]; for (int xx = 0; xx < length; xx++) for (int yy = 0; yy <
	 * width; yy++){ hsv = handler.photo.get(xx, yy); saturation[xx][yy] =
	 * hsv[1]; }
	 * 
	 * return saturation; } public double[][] getValueArray(){ double value[][]
	 * = new double[length][width];
	 * 
	 * double hsv[]; for (int xx = 0; xx < length; xx++) for (int yy = 0; yy <
	 * width; yy++){ hsv = handler.photo.get(xx, yy); value[xx][yy] = hsv[2]; }
	 * 
	 * return value; }
	 */
}