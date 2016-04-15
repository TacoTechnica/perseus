package analysis.photo;

import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import util.FileHandler;

public class Photo {

	Scalar lowerRGB = new Scalar(0, 0, 0);
	Scalar upperRGB = new Scalar(0, 0, 0);

	double[][] red, green, blue, luminance;
	public double rAvg, gAvg, bAvg, yAvg, rStDev, gStDev, bStDev, yStDev;

	int length = 60, width = 40, unit = 100;
	Section[][] section = null;

	String photoName, photoPath, filePath;

	public Photo(String photoName) {
		this.photoName = photoName;
		photoPath = "/Users/owencarter/Desktop/Research Expos/Perseus/Photos/" + photoName + ".jpg";
		filePath = "res/PhotoInfo/" + photoName + ".txt";
		Mat photo = FileHandler.readMatImage(photoPath);
		FileHandler.writeMatToFile(photo, filePath);
		//FileHandler.deleteFile(photoName);
	}
	
	private void makeSections(){
		double[][] tempRed = new double[red.length][red[0].length],
					tempGreen = new double[green.length][green[0].length],
					tempBlue = new double[blue.length][blue[0].length];

		for (int l = 0; l < length; l++)
			for (int w = 0; w < width; w++){
				for (int xx = l * unit; xx < (l + 1) * unit; xx++)
					for (int yy = w * unit; yy < (w + 1) * unit; yy++){
						//System.out.println(xx + " " + yy);
						tempRed[l][w] = red[xx][yy];
						tempGreen[l][w] = green[xx][yy];
						tempBlue[l][w] = blue[xx][yy];
					}
				section[l][w] = new Section(tempRed, tempGreen, tempBlue);
			}
	}

	private double[][][] loadRGBArray(Mat mat) {
		int width = mat.width() - 1;
		int height = mat.height() - 1;
		double rgb[][][] = new double[3][width][height];
		for (int xx = 0; xx < width; xx++) {
			for (int yy = 0; yy < height; yy++) {
				double[] tempHSB = mat.get(xx, yy);
				try{
					rgb[0][xx][yy] = tempHSB[0];
					rgb[1][xx][yy] = tempHSB[1];
					rgb[2][xx][yy] = tempHSB[2];
				} catch (NullPointerException e){
					return rgb;
				}
			}
		}
		return rgb;
	}

	public void display() {
		System.out.println(yAvg);
	}
	public void displaySections(){
		for (int l = 0; l < length; l++)
			for (int w = 0; w < width; w++)
				System.out.println(section[l][w].yAvg);
	}
}
