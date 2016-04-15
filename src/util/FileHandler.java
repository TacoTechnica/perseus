package util;

import java.io.*;
import java.util.ArrayList;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/** FileHandler.java
 * 
 * Just a utility that centralizes file handling into one class, 
 * making it more easier and more systematic.
 */
public class FileHandler {

	public static Mat readMatImage(String path) {
		return Imgcodecs.imread(path);
	}
	
	public static String[] readFile(String path, int lineMin, int lineMax){
		int lineNumber = 0, pointNumber = 0;
		String[] dataPoint = new String[lineMax - lineMin];

		try{
			BufferedReader in = new BufferedReader(new FileReader(path));

			String line = null;
			while ((line = in.readLine()) != null){
				if (lineNumber >= lineMin && lineNumber < lineMax){
					dataPoint[pointNumber] = line;
					pointNumber++;
				}
				if (lineNumber >= lineMax) break;
				lineNumber++;
			}

			in.close();
		} catch (IOException ex){
			System.err.println(ex);
		}

		return dataPoint;
	}

	public static void writeToFile(String[] newDataPoint, String path, int start){
		ArrayList<String> dataPoint = new ArrayList<String>(0);

		try{
			BufferedReader in = new BufferedReader(new FileReader(path));

			String line = null;
			while ((line = in.readLine()) != null)
				dataPoint.add(line);

			in.close();
		} catch (IOException ex){
			//If file does not exist, then it will be created by PrintWriter
		}

		for (int i = 0; i < newDataPoint.length; i++)
			dataPoint.add(i + start, newDataPoint[i]);

		try{
			PrintWriter out = new PrintWriter(path);
			for (int i = 0; i < dataPoint.size(); i++)
				out.println(dataPoint.get(i));
			out.close();
		} catch (IOException ex){
			System.err.println(ex);
		}
	}

	public static void writeMatToFile(Mat mat, String path){
		try{
			PrintWriter out = new PrintWriter(path);

			double[] rgb;
			for (int xx = 0; xx < mat.rows(); xx++)
				for (int yy = 0; yy < mat.cols(); yy++){
					rgb = mat.get(xx, yy);
					out.println((int) rgb[0] + "\t" + (int) rgb[1] + "\t" + (int) rgb[2]);
				}

			out.close();
		} catch (IOException ex){
			System.err.println(ex);
		}
	}

	public static void deleteFile(String path){
		File file = new File(path);
		file.delete();
	}
	
	public static void writeMatImage(String path, Mat image) {
		Imgcodecs.imwrite(path, image);
	}



}