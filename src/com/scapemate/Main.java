package com.scapemate;

import java.io.IOException;

import javax.swing.WindowConstants;

import com.scapemate.loader.ParameterLoader;
import com.scapemate.ui.ScapeMateFrame;

public class Main {	
	private static ScapeMateFrame frame;
	
	/**
	 * @param args program arguments
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ParameterLoader.parse(); 
		
		frame = new ScapeMateFrame();
		frame.load();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static ScapeMateFrame getScapeMateFrame() {
		return frame;
	}
}
