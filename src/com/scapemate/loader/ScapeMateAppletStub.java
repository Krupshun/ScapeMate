package com.scapemate.loader;

import java.applet.AppletContext;
import java.applet.AppletStub;
import java.net.MalformedURLException;
import java.net.URL;

public class ScapeMateAppletStub implements AppletStub {
	private String codebase;
	private URL codebaseURL;
	
	public ScapeMateAppletStub() {
		codebase = "http://world" + ParameterLoader.get("worldid") + ".runescape.com/";
		try {
			codebaseURL = new URL(codebase);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void appletResize(int width, int height) {
		// Do Nothing.
		System.out.println("Applet Resized: " + width + ", " + height);
	}

	@Override
	public AppletContext getAppletContext() {
		return null; 
	}

	@Override
	public URL getCodeBase() {
		return codebaseURL;
	}

	@Override
	public URL getDocumentBase() {
		return codebaseURL;
	}

	@Override
	public String getParameter(String key) {
		return ParameterLoader.get(key);
	}

	@Override
	public boolean isActive() {
		return ParameterLoader.activeCount() == 0;
	}
}
