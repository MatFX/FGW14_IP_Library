package gateway;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Connection 
{
	public static boolean isTLS = false;
	
	public static final String DEFAULT_PASSWORD = "fgw14-ip";

	private String currentAccessToken;
	
	private static Connection connection = null;
	
	private final String pathToFile = "/config/settings.cfg";
	
	private Properties settings = null;
	
	public Connection()
	{
		
	}
	
	
	public static Connection getInstance()
	{
		if(connection == null)
		{
			System.out.println("readProps");
			connection = new Connection();
			connection.readProperties();
		}
		
		return connection;
	}
	
	private void readProperties() 
	{
		File settingsFile = new File(".");
		settingsFile = new File(settingsFile.getAbsolutePath()+pathToFile);
		settings = new Properties();
		System.out.println("> " + settingsFile.getAbsolutePath());
		try (FileInputStream fis = new FileInputStream(settingsFile.getAbsolutePath()))
		{
			settings.load(fis);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		currentAccessToken = (String) fillConstants("accessToken", String.class, "", settings); 
		
	}
	

	/**
	 * Eine Methode die einen gewünschte Eigenschaft aus einer Property-Datei holt.
	 * @param key
	 * @param classCast
	 * @param defaultObject
	 * @param settings
	 * return Ein Objekt der Aufrufer weiß ja Bescheid was zurück kommt.
	 */
	private static Object fillConstants(String key, Class<?> classCast, Object defaultObject, Properties settings)
	{
		try
		{
			Object value = settings.get(key);
			return classCast.getConstructor(new Class[] {String.class }).newInstance(value.toString().trim());
		}
		catch(Exception e)
		{
			//Falls es die Eigenschaft nicht gibt, dann den übergebenen Defaultwert setzen
			return classCast.cast(defaultObject);
		}
	}


	public String getDestinationIP() 
	{
		/* if(isTLS)
			return getDestinationIPWithTLS();
		else */
		return getDestinationIPWithoutTLS();
	}
	
	public String getDestinationIPWithoutTLS()
	{
		//Standard ohne tls
		return "http://192.168.150.104";
	}

	public void setCurrentAccessToken(String accessToken) 
	{
		this.currentAccessToken = accessToken;
	
		settings.setProperty(PROPERTIES.ACCESSTOKEN.getPropertyName(), this.currentAccessToken);
		saveProperties();
		
		
	}

	private void saveProperties() 
	{
		File settingsFile = new File(".");
		settingsFile =  new File(settingsFile.getAbsolutePath() + pathToFile);
	
		try 
		{
			FileOutputStream fr = new FileOutputStream(settingsFile);
			settings.store(fr, "Properties");
		    fr.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public String getCurrentAccessToken() {
		return currentAccessToken;
	}
	
	/*
	public static String getDestinationIPWithTLS() {
		//TLS https
		return "https://192.168.150.81:443";
	}*/



}
