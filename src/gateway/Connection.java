package gateway;

public class Connection 
{
	public static boolean isTLS = false;
	
	public static final String DEFAULT_PASSWORD = "fgw14-ip";

	public static String getDestinationIP() 
	{
		/* if(isTLS)
			return getDestinationIPWithTLS();
		else */
		return getDestinationIPWithoutTLS();
	}
	
	public static String getDestinationIPWithoutTLS()
	{
		//Standard ohne tls
		return "http://192.168.150.104";
	}
	
	/*
	public static String getDestinationIPWithTLS() {
		//TLS https
		return "https://192.168.150.81:443";
	}*/



}
