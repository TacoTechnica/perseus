package analysis;

import analysis.photo.Photo;

/** Blank.java
 * 
 * Analysis handling for a "blank" photo of the sky.
 * 
 * See section 1.3 in the experiment documentation for more information.
 */
public class Blank {
	String path[] = null;
	Photo photo[] = null;

	double avg, stDev;

	public Blank(String[] path){
		this.path = path;
		photo = new Photo[path.length];
		for (int i = 0; i < path.length; i++){
			photo[i] = new Photo(path[i]);
			//photo[i].display();
		}
		avg = getAvg();
		System.out.println(avg);
	}
	
	public double getAvg(){
		double[] avg = new double[photo.length];

		for (int i = 0; i < avg.length; i++)
			avg[i] = photo[i].yAvg;

		return core.Statistics.getAvg(avg);
	}
}
