import java.util.Hashtable;

import javafx.scene.web.WebEngine;

public class gameMap {
	
	Hashtable<String, Integer> storeIndex = new Hashtable<String, Integer>(); 
	int index = 0;
	
	mapLocation mapCord;
	
	//Default Constructor 
	public gameMap()
	{
		mapCord = new mapLocation();	
	}
	
	//Load the map the user chose 
	public void getCountry(String location, WebEngine webEngine)
	{
		
		String place = modifyString(location);
		
		double latitude = mapCord.getLatitude(place);
		double longitude = mapCord.getLongitude(place);
		
		webEngine.executeScript("callMapsTwo("+latitude+","+longitude+")");
		
	}
	
	//Put a marker for a business
	public void putBusiness(String storeChosen, WebEngine webEngine)
	{
		String store = modifyString(storeChosen);
		
		storeIndex.put(store, index);
		
		
		double latitude = mapCord.getStoreLatitude(store);
		double longitude = mapCord.getStoreLongitude(store);
		
		webEngine.executeScript("callMarker("+latitude+", "+longitude+", \"" + store + "\")");
		
		index = index + 1;
		
		System.out.println("Size: " + storeIndex.size());
    }
	
	
	//Delete Marker 
	public void deleteMarker(String storeChosen, WebEngine webEngine)
	{
		String store = modifyString(storeChosen);
		int indx = storeIndex.get(store);
		
		webEngine.executeScript("deleteMarker("+indx+")");
	}
		
	//Changes the string to the text file format
	public String modifyString(String a)
	{
		String b = a.replace(' ', '/');
		
		return b;
	}
	
		
}
	


