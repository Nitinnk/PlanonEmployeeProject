package employee;

import java.time.LocalDate;
import java.util.Date;

public class AllEmployeeSalaryForThisMonth {
	private EmployeeDataBaseManager edbl;
	private LocalDate date;
	public AllEmployeeSalaryForThisMonth(EmployeeDataBaseManager edbl,LocalDate date)
	{
		this.edbl=edbl;
		this.date=date;
	}
	/**
	 * printSalaries() method will print the aslaries of all employees this month.
	 */
	public void printSalaries()
	{
		for(IEmployee p:edbl.getAllEmployeeList())
		{
			System.out.println("Total salary paid to "+p.getName()+" is"+new TotalSalaryPaidToEmployee(p,this.date).checkTotalSalary(p));
		}		
	}
}
