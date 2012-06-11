package net.nabaztag.nabalive.sdk;

import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;



public class Script {

	public static String instanceID = "";
	public static String nabApi = "";
	
	public static void main(String[] args) throws IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		System.out.println("-----Script reader starting-----");

	    Class.forName("com.mysql.jdbc.Driver").newInstance();
		
	    instanceID = args[0];
	    
	    java.sql.Connection mysql = DriverManager.getConnection("jdbc:mysql://localhost/nabaztag?"+ "user=username&password=password");
	    System.out.println("Connecting to mysql...");
	    Statement statement = mysql.createStatement();
	    System.out.println("Mysql query: SELECT * FROM `table` WHERE `field` = "+instanceID);
	    ResultSet rs = statement.executeQuery("select * from table where field = '"+instanceID+"'");
	    rs.next();
		
	    if (rs.getString("apiKey") != null || rs.getString("apiKey") != "") {
	    	
		    nabApi = rs.getString("apiKey");
		    
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");
			
			String appPath = "/home/nabaztag/app/"+rs.getString("appID")+"/main.js";
			
			System.out.println("NabApiKey "+nabApi+" for script "+appPath+" with instanceID "+instanceID);

			
				  try {
					jsEngine.put("nabaztag", new Nabaztag());
					jsEngine.put("http", new Utils());
					jsEngine.put("instanceID", rs.getString("instanceID"));
					jsEngine.put("mail", rs.getString("email"));
					jsEngine.put("appID", rs.getString("appID"));
					
				    jsEngine.eval(new FileReader(appPath));
				  } catch (ScriptException ex) {
				    ex.printStackTrace();
				  }
				  System.exit(0);
	    }
	}

}
