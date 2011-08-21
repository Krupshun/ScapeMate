package com.scapemate.runescape.loader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParameterLoader extends Thread {
	private static Thread parameterThread = null;
	
	private static Map<String, String> parameters = new HashMap<String, String>();
	
	public static void parse() {
		parameterThread = new Thread(new ParameterLoader());
		parameterThread.start();
	}
	
	private ParameterLoader() {
		System.out.println("Obtaining applet parameters.");
	}
	
	public void run() {
		try {
			Document doc = Jsoup.connect("http://www.runescape.com/game.ws").get();
			Elements frame = doc.select("frameset frame");
			String appletPage = frame.attr("src");
			
			System.out.println("Loading applet from: " + appletPage);
			
			doc = Jsoup.connect(appletPage).get();
			Elements applet = doc.select("#gameframe applet");
			
			parameters.put("archive", applet.attr("archive"));
			parameters.put("code", applet.attr("code"));
			
			Elements params = applet.select("param");
			
			for(Element e : params) {
				parameters.put(e.attr("name"), e.attr("value"));
			}
		} catch(IOException e) {
			System.out.println("Error loading applet data.");
		}
	}
	
	public static String get(String key) {
		if(parameterThread.isAlive()) {
			try {
				parameterThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return parameters.get(key);
	}
}
