package net.nabaztag.nabalive.sdk;

import java.io.IOException;

public class Nabaztag  {

	public Utils Utils = new Utils();
	
	public void tts(String text) {
		
		String Callurl="http://www.nabaztag.com/nabaztags/"+Script.nabApi+"/tts/fr?text="+text;
		log("Calling " + Callurl);
		try {
			Utils.get(Callurl);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void play(String url) {
		
		String Callurl="http://www.nabaztag.com/nabaztags/"+Script.nabApi+"/play?url="+url;
		log("Calling " + Callurl);
		try {
			Utils.get(Callurl);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sleep() {
		
		String Callurl="http://www.nabaztag.com/nabaztags/"+Script.nabApi+"/sleep";
		log("Calling " + Callurl);
		try {
			Utils.get(Callurl);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void wakeup() {
		
		String Callurl="http://www.nabaztag.com/nabaztags/"+Script.nabApi+"/wakeup";
		log("Calling " + Callurl);
		try {
			Utils.get(Callurl);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void ears(int ear, int value, int side) {
		String Callurl ="http://www.nabaztag.com/nabaztags/"+Script.nabApi+"/exec?command=CH+0,motor,"+ear+","+value+",0,"+side;
		log("Calling " + Callurl);
		try {
			Utils.get(Callurl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ears(int ear, int value) {
		String Callurl ="http://www.nabaztag.com/nabaztags/"+Script.nabApi+"/exec?command=CH+0,motor,"+ear+","+value+",0,0";
		log("Calling " + Callurl);
		try {
			Utils.get(Callurl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	private void log(String text) {
		System.out.println(text);
	}
	
}
