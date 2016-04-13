package core;

public class Statistics {
	public static int getN(double[] array) {
		return array.length;
	}

	public static int getN(double[][] array) {
		return array.length * array[0].length;
	}

	public static double getAvg(double[][] array) {
		double array1D[] = new double[getN(array)];

		for (int xx = 0; xx < array.length; xx++)
			for (int yy = 0; yy < array[0].length; yy++)
				array1D[xx * array[0].length + yy] = array[xx][yy];

		return getAvg(array1D);
	}

	public static double getAvg(double[] array) {
		int n = getN(array);
		return getAvg(array, n);
	}

	public static double getAvg(double[] array, int n) {
		double sum = 0, avg;

		for (int i = 0; i < array.length; i++)
			sum += array[i];

		avg = sum / n;
		return avg;
	}

	public static double getStDev(double[][] array) {
		int n = getN(array);
		double avg = getAvg(array), deviation[] = new double[n], stdev;

		for (int xx = 0; xx < array.length; xx++)
			for (int yy = 0; yy < array[0].length; yy++)
				deviation[xx * array[0].length + yy] = Math.pow(array[xx][yy] - avg, 2);

		stdev = Math.sqrt(getAvg(deviation, n - 1));
		return stdev;
	}
}
