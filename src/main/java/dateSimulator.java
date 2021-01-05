import java.util.Hashtable;

public class dateSimulator {
	
	int month;
	int day;
	int year;
	
	Hashtable<Integer, Integer> monthLimit;
	
	
	public dateSimulator()
	{
		month = 8;
		day = 26;
		year = 2020;
		
		monthLimit = new Hashtable<Integer, Integer>();
		
		setMonthLimits();
		
	}
	
	private void setMonthLimits()
	{
		
		monthLimit.put(1, 31);
		monthLimit.put(2, 28);
		monthLimit.put(3, 31);
		monthLimit.put(4, 30);
		monthLimit.put(5, 31);
		monthLimit.put(6, 30);
		
		monthLimit.put(7, 31);
		monthLimit.put(8, 31);
		monthLimit.put(9, 30);
		monthLimit.put(10, 31);
		monthLimit.put(11, 30);
		monthLimit.put(12, 31);
		
		
	}
	
	public void nextDay()
	{
		
		day = day + 1;
		
		//Check Limit has not been Reached
		if(day > monthLimit.get(month))
		{
			day = 1;
			
			if(month == 12)
			{
				month = 1;
				year = year + 1;
			}
			else
			{
				month = month + 1;
			}
		}
		
	}
	
	public String getDate()
	{
		String d = month + "/" + day + "/" + year;
		
		return d;
	}
	
	//Getters
	public int getMonth()
	{
		return month;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public int getYear()
	{
		return year;
	}
	
	
	
}
