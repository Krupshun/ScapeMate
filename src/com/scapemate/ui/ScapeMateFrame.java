package com.scapemate.ui;

import java.applet.Applet;

import javax.swing.JFrame;

import com.scapemate.loader.ScapeMateAppletLoader;

public class ScapeMateFrame extends JFrame {
	private Applet applet;
	
	public ScapeMateFrame() {
		super("ScapeMate");
	}
	
	public void load() {
		ScapeMateAppletLoader loader = new ScapeMateAppletLoader();
		
		applet = loader.getRuneScapeApplet();
		
		super.add(applet);
		super.setSize(768, 560);
	}
	
	@Override
	public void dispose() {
		applet.stop();
		
		super.dispose();
	}
}
