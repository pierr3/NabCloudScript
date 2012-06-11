package net.nabaztag.nabalive.sdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

public class Utils {

	public String get(String urlString) throws IOException {
		HttpClient httpclient = new DefaultHttpClient();
		
		HttpGet httpget = new HttpGet(urlString);
		
		HttpResponse response = httpclient.execute(httpget);
		
		HttpEntity entity = response.getEntity();
		
		if (entity != null) {
		    InputStream instream = entity.getContent();
		    try { 
		       return useHttpRes(instream); 
		    } finally {
		        instream.close();
		    }
		} else {
			return "";
		}
		
	}
	
	private String useHttpRes(InputStream instream) throws IOException {
		
			Writer writer = new StringWriter();
			 
	        char[] buffer = new char[1024];
	        
	        try {
	            Reader reader = new BufferedReader(
	                    new InputStreamReader(instream, "UTF-8"));
	            int n;
	            while ((n = reader.read(buffer)) != -1) {
	                writer.write(buffer, 0, n);
	            }
	            
	        } 
	        
	        finally {
	        	instream.close();
	        }
	        return writer.toString();
	}
	
	public String[] getInstanceParams() throws IOException {
		String[] params = null;
		
		String data = get("http://www.nabcloud.fr/App/params.php?instanceID="+Script.instanceID);
		JSONArray json=(JSONArray)JSONValue.parse(data);
		if (json.get(1) != null) {
			
		}
		
		return params;
	}
	
}
