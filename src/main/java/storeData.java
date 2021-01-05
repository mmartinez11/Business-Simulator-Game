

public class storeData {
	
	String storeID;
	
	int storeCost;
	int inventoryTotal;
	
	int wages;
	int utilities;
	int propertyTaxes;
	int storeValue;
	
	int employeeCount;
	
	int income;
	
	
	public storeData(String store)
	{
		
		storeID = store;
		
		inventoryTotal = 0;
		storeValue = 0;
		
		wages = 12000;
		utilities = 1000;
		propertyTaxes = 10000;
		
		employeeCount = 2;
		income = 0;
		
		setStoreCost(store);
		
	}
	
	private void setStoreCost(String s)
	{
		
		if(s.charAt(s.length()-1) == '1')
		{
			storeCost = 25000;
		}
		else if(s.charAt(s.length()-1) == '2')
		{
			storeCost = 50000;
		}
		else if(s.charAt(s.length()-1) == '3')
		{
			storeCost = 75000;
		}
		
	}
	
	//Getters
	public String getStoreID()
	{
		return storeID;
	}
	
	public int getInventoryTotal()
	{
		return inventoryTotal;
	}
	
	public int getValue()
	{
		return storeValue;
	}
	
	public int getWages()
	{
		return wages;
	}
	
	public int getUtilities()
	{
		return utilities;
	}
	
	public int getPropertyTaxes()
	{
		return propertyTaxes;
	}
	
	public int getEmployeeCount()
	{
		return employeeCount;
	}
	
	public int getStoreCost()
	{
		return storeCost;
	}
	
	
	//Setters
	public void setInventoryTotal(int value)
	{
		 inventoryTotal += value;
	}
	
	public void setValue(int value)
	{
		 storeValue += value;
	}
	
	public void setWages(int value)
	{
		 wages += value;
	}
	
	public void setUtilities(int value)
	{
		 utilities += value;
	}
	
	public void setPropertyTaxes(int value)
	{
		 propertyTaxes += value;
	}
	
	public void setEmployeeCount(int value)
	{
		 employeeCount += value;
	}
	
	public void setStoreCost(int value)
	{
		storeCost += value;
	}
}
