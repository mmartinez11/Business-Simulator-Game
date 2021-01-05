import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.application.Platform;

public class BusinessTest {

	mapLocation test;
	gameMap test2;
	
	String country;
	String store;
	
	@BeforeEach
	void defaultN()
	{
		
		test = new mapLocation();
		test2 = new gameMap();
		
		country = "Madrid/Spain";
		store = "USA/Store1";
	}
	
	@Test 
	void locationName()
	{
		assertEquals("Madrid/Spain", test.locationName.get(8), "Wrong First Country");
		//System.out.println(test.locationName.get(8));
	}
	
	@Test
	void longitudeNumber()
	{
		assertEquals(-3.686667, test.getLongitude(country), "Wrong Longitude Number");
		//System.out.println(test.getLongitude(country));
		
		
	}
	
	@Test
	void latitudeNumber()
	{
		assertEquals(40.478889, test.getLatitude(country), "Wrong Latitude Number");
		//System.out.println(test.getLatitude(country));
	}
	
	
	@Test
	void storeName()
	{
		assertEquals("USA/Store1", test.storeName.get(15), "Wrong Store Name");
	}
	
	@Test 
	void storeLongitude()
	{
		assertEquals(-122.060212, test.getStoreLongitude(store), "Wrong Store Longitude Number");
	}
	
	@Test
	void storeLatitude()
	{
		assertEquals(37.387764, test.getStoreLatitude(store), "Wrong Store Longitude Number");
		
		//String myStr = "USA Store1";
		//System.out.println(myStr.replace(' ', '/'));
	}
	
	@Test 
	void testString()
	{
		assertEquals("USA/Store1", test2.modifyString("USA Store1"), "Not the right string");
	}
	
	
	
}
