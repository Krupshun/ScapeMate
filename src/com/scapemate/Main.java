package com.scapemate;

import java.io.IOException;

import javax.swing.WindowConstants;

import com.scapemate.runescape.loader.ParameterLoader;
import com.scapemate.ui.ScapeMateFrame;

public class Main {
	/**
	 * @param args program arguments
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ParameterLoader.parse(); 
		
		ScapeMateFrame frame = new ScapeMateFrame();
		frame.load();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
