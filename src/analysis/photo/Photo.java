package analysis.photo;

import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import util.FileHandler;

public class Photo {

	Scalar lowerHSV = new Scalar(0, 0, 0);
	Scalar upperHSV = new Scalar(0, 0, 0);

	double[][] hue, saturation, value;
	double hAvg, sAvg, vAvg, hStDev, sStDev, vStDev;

	public Photo(String path) {
		Mat photo = FileHandler.readMatImage(path);
		double[][][] hsbArray = loadHSBArray(photo);
		hue = hsbArray[0];
		saturation = hsbArray[1];
		value = hsbArray[2];
		getStats();
	}

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

	private void getStats() {
		hAvg = core.Statistics.getAvg(hue);
		sAvg = core.Statistics.getAvg(saturation);
		vAvg = core.Statistics.getAvg(value);
		hStDev = core.Statistics.getStDev(hue);
		sStDev = core.Statistics.getStDev(saturation);
		vStDev = core.Statistics.getStDev(value);
	}
	//private double getVioletRedRatio();

	public void display() {
		System.out.println(vAvg);
	}
}
