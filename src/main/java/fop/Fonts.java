package fop;

import org.apache.fop.fonts.apps.TTFReader;

public class Fonts {
	 public static void main(String args[]){
	        String[] parameters= {
	        "-ttcname",
	        "simkai",
	        "C://Windows//Fonts//simkai.ttf","E:/simkai.xml",};
	        TTFReader.main(parameters);
	        }
}
