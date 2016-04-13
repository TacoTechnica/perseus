package core;

import org.opencv.core.Core;

import analysis.Blank;

public class Main {
	public static void main(String args[]){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		String[] path = new String[1];
		path[0] = "/Users/owencarter/Desktop/Perseus/photos/0326_5deg_LPBlank1.NEF";
		new Blank(path);
	}
}
