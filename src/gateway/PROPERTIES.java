package gateway;

public enum PROPERTIES 
{
	
	ACCESSTOKEN("accessToken"),
	
	;
	
	private String propertyName;
	
	private PROPERTIES(String propertyName)
	{
		this.propertyName = propertyName;
	}
	
	public String getPropertyName() {
		return propertyName;
	}

}
