import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class mapLocation {

	//Location Data Structures 
	public HashMap<String, Double> locationLatitude;
	public HashMap<String, Double> locationLongitude;
	
	public List<String> locationName;
	
	//Stores Data Structures 
	public HashMap<String, Double> storeLatitude;
	public HashMap<String, Double> storeLongitude;
	
	public List<String> storeName;
	
	//Default Constructor
	public mapLocation()
	{
		//Get Location Information
		locationLatitude = new HashMap<String, Double>();
		locationLongitude = new HashMap<String, Double>();
		locationName = new ArrayList<>();
		
		fillLocationName();
		fillLocationLatitude();
		fillLocationLongitude();

		//Get store information
		storeLatitude = new HashMap<String, Double>();
		storeLongitude = new HashMap<String, Double>();
		storeName = new ArrayList<>();
		
		fillStoreName();
		fillStoreLatitude();
		fillStoreLongitude();
		
		
	}

	//Fill Location Values
	public void fillLocationName()
	{
		
		Path filePath = Paths.get("locationName.txt");
		Scanner scanner;
		try {
			scanner = new Scanner(filePath);
			
			while (scanner.hasNext()) 
			{
				locationName.add(scanner.next());    
			}
			
			scanner.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fillLocationLatitude()
	{
		
		Path filePath = Paths.get("locationLatitude.txt");
		Scanner scanner;
		int i = 0;
		
		
		try {
			
			scanner = new Scanner(filePath);
			
			while (scanner.hasNext()) 
			{
				 if (scanner.hasNextDouble()) 
				 {
					 locationLatitude.put(locationName.get(i), scanner.nextDouble());
				 } 
				 else 
				 {
				     scanner.next();
				 }
				 
				 i++;
			}
			
			scanner.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void fillLocationLongitude()
	{
		
		Path filePath = Paths.get("locationLongitude.txt");
		Scanner scanner;
		int i = 0;
		
		
		try {
			
			scanner = new Scanner(filePath);
			
			
			while (scanner.hasNext()) 
			{
				 if (scanner.hasNextDouble()) 
				 {
					 locationLongitude.put(locationName.get(i), scanner.nextDouble());
				 } 
				 else 
				 {
				     scanner.next();
				 }
				 
				 i++;
			}
			
			scanner.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	//Fill Store Values 
	public void fillStoreName()
	{
		Path filePath = Paths.get("storeNames.txt");
		Scanner scanner;
		try {
			scanner = new Scanner(filePath);
			
			while (scanner.hasNext()) 
			{
				storeName.add(scanner.next());    
			}
			
			scanner.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fillStoreLatitude()
	{
		Path filePath = Paths.get("storeLatitude.txt");
		Scanner scanner;
		int i = 0;
		
		
		try {
			
			scanner = new Scanner(filePath);
			
			while (scanner.hasNext()) 
			{
				 if (scanner.hasNextDouble()) 
				 {
					 storeLatitude.put(storeName.get(i), scanner.nextDouble());
				 } 
				 else 
				 {
				     scanner.next();
				 }
				 
				 i++;
			}
			
			scanner.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fillStoreLongitude()
	{
		Path filePath = Paths.get("storeLongitude.txt");
		Scanner scanner;
		int i = 0;
		
		
		try {
			
			scanner = new Scanner(filePath);
			
			
			while (scanner.hasNext()) 
			{
				 if (scanner.hasNextDouble()) 
				 {
					 storeLongitude.put(storeName.get(i), scanner.nextDouble());
				 } 
				 else 
				 {
				     scanner.next();
				 }
				 
				 i++;
			}
			
			scanner.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Get Location Values 
	public double getLatitude(String country)
	{
		return locationLatitude.get(country);
	}
	
	public double getLongitude(String country)
	{
		return locationLongitude.get(country);
	}
	
	//Get Store Values 
	public double getStoreLatitude(String country)
	{
		return storeLatitude.get(country);
	}
	
	public double getStoreLongitude(String country)
	{
		return storeLongitude.get(country); 
	}
	
	
}