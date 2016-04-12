package analysis.photo;

public class Photo {
	
	CVImageModifier photo = null;
	int length, width;
	double[][] hue, saturation, value;
	double hAvg, sAvg, vAvg, hStDev, sStDev, vStDev;
	
	public Photo(String path){
		photo = new CVImageModifier(path);
		length = photo.width;
		width = photo.length;
		hue = photo.getHueArray();
		saturation = photo.getSaturationArray();
		value = photo.getValueArray();
		getStats();
	}
	private void getStats(){
		hAvg = core.Statistics.getAvg(hue);
		sAvg = core.Statistics.getAvg(saturation);
		vAvg = core.Statistics.getAvg(value);
		hStDev = core.Statistics.getStDev(hue);
		sStDev = core.Statistics.getStDev(saturation);
		vStDev = core.Statistics.getStDev(value);
	}

	public void display(){
		System.out.println(vAvg);
	}
}
