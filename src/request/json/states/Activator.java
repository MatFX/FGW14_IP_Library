package request.json.states;

/**
 * two enum to activate oder inactivate any states from the api
 * @author m.goerlich
 *
 */
public enum Activator
{
	ACTIVATE("active"),
	
	INACTIVE("inactive");
	
	private String valueToSet = "";
	
	private Activator(String valueToSet)
	{
		this.valueToSet = valueToSet;
	}
	
	public String getValueToSet()
	{
		return this.valueToSet;
	}
}
