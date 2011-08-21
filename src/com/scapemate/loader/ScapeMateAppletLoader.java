package com.scapemate.loader;

import java.applet.Applet;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


public class ScapeMateAppletLoader {
	private Applet runescapeApplet;
	private ScapeMateAppletStub runescapeStub;
	private URLClassLoader classLoader;
	
	public ScapeMateAppletLoader() {
		try {
			runescapeStub = new ScapeMateAppletStub();
			
			URL[] archives = new URL[] { new URL(runescapeStub.getCodeBase(), ParameterLoader.get("archive")) };
			
			classLoader = new URLClassLoader(archives);
			
			try {
				runescapeApplet = (Applet) classLoader.loadClass(ParameterLoader.get("code").split("\\.")[0]).newInstance();
				runescapeApplet.setStub(runescapeStub);
				runescapeApplet.init();
				runescapeApplet.start();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public Applet getRuneScapeApplet() {
		return runescapeApplet;
	}
}
