package com.scapemate.ui;

import java.applet.Applet;

import javax.swing.JFrame;

import com.scapemate.runescape.loader.AppletLoader;

public class ScapeMateFrame extends JFrame {
	private Applet applet;
	
	public ScapeMateFrame() {
		super("ScapeMate");
	}
	
	public void load() {
		AppletLoader loader = new AppletLoader();
		
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
