package employee;

public class AllEmployeeSalaryForThisMonth {
	private EmployeeDataBaseManager edbl;
	private int month;
	AllEmployeeSalaryForThisMonth(EmployeeDataBaseManager edbl,int month)
	{
		this.edbl=edbl;
		this.month=month;
		printSalaries();
	}
	public void printSalaries()
	{
		for(IEmployee p:edbl.getAllEmployeeList())
		{
			new TotalSalaryPaidToEmployee(p,this.month);
		}		
	}
}
