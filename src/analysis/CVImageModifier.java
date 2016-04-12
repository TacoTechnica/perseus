package analysis;

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

	public void removeBackgroundNoise(Mat input, Mat output) {
		// Convert to hsv
		Imgproc.cvtColor(input, output, Imgproc.COLOR_BGR2HSV);

		// Remove background color
		Core.inRange(output, lowerHSV, upperHSV, output);

		
	}
}
