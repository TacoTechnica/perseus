package analysis.photo;

public class Section {

	double[][] red, green, blue, luminance;
	public double rAvg, gAvg, bAvg, yAvg, rStDev, gStDev, bStDev, yStDev;

	public Section(double[][] red, double[][] green, double[][] blue){
		this.red = red;
		this.green = green;
		this.blue = blue;
		luminance = calcLuminanceArray();
		getStats();
	}

	public double[][] calcLuminanceArray(){
		/* Uses the equation:
		 * Y = 0.2126R + 0.7152G + 0.0722B
		 * to calculate luminance
		 */
		double[][] luminance = new double[red.length][red[0].length];

		for (int xx = 0; xx < luminance.length; xx++)
			for (int yy = 0; yy < luminance[0].length; yy++)
				luminance[xx][yy] = (0.2126 * red[xx][yy]) + (0.7152 * green[xx][yy]) +
									(0.0722 * blue[xx][yy]);

		return luminance;
	}

	private void getStats() {
		rAvg = core.Statistics.getAvg(red);
		gAvg = core.Statistics.getAvg(green);
		bAvg = core.Statistics.getAvg(blue);
		yAvg = core.Statistics.getAvg(luminance);
		rStDev = core.Statistics.getStDev(red);
		gStDev = core.Statistics.getStDev(green);
		bStDev = core.Statistics.getStDev(blue);
		yStDev = core.Statistics.getStDev(luminance);
	}
}
