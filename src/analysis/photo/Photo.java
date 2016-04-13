package analysis.photo;

import org.opencv.core.Mat;

import util.FileHandler;

public class Photo {

	CVImageModifier photoModifier = null;
	// int length, width;
	double[][] hue, saturation, value;
	double hAvg, sAvg, vAvg, hStDev, sStDev, vStDev;

	public Photo(String path) {
		photoModifier = new CVImageModifier();
		// length = photo.width;
		// width = photo.length;

		Mat photo = FileHandler.readMatImage(path);
		double[][][] hsbArray = photoModifier.loadHSBArray(photo);
		hue = hsbArray[0];
		saturation = hsbArray[1];
		value = hsbArray[2];
		getStats();
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
