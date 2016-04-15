package core;

import org.opencv.core.Core;

import analysis.Blank;

public class Main {
	public static void main(String args[]){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		String[] path = new String[1];
		path[0] = "0412_90degBarlow_LPBlank1";
		new Blank(path);
	}
}
