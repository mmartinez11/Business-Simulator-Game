
public class userData {

	int budget;
	int totalEmployees;
	
	public userData()
	{
		budget = 100000;
		totalEmployees = 2;
	}
	
	//Reduce from Budget
	public void reduceBudget(int value)
	{
		budget = budget - value;
	}
	
	//Add to budget
	public void increaseBudget(int value)
	{
		budget += value;
	}
	
	//Setters 
	public int getBudget()
	{
		return budget;
	}
	
	public int getEmployeeTotal()
	{
		return totalEmployees;
	}
	
}
