package employee;

import java.time.LocalDate;

public class TotalSalaryCount {
	private EmployeeDataBaseManager edbl;
	private LocalDate date;
	TotalSalaryCount(EmployeeDataBaseManager edbl,LocalDate date)
	{
		this.edbl=edbl;
		this.date=date;
	}
	/**
	 *  printAllEmployeeSalaries() will print all the employee salaries.
	 */
	public void printAllEmployeeSalaries()
	{
		for(IEmployee e:edbl.getAllEmployeeList())
		{
			System.out.println("Total salary paid to "+e.getName()+" is "+checkThisMonthSalary(e));
		}
	}
	/**
	 * checkThisMonthSalary() will check the salary of one particular month.
	 * @param e
	 * @return
	 */
	public double checkThisMonthSalary(IEmployee e)
	{
		if(e.getType().equalsIgnoreCase("permanent"))
		{
			return ((PermanentEmployee) e).deductBaseSalary(((PermanentEmployee) e).getNoOfLeavesInMonth(this.date.getMonthValue()),this.date.getMonthValue());
		}
		else
		{
			return ((ContractEmployee) e).salaryToBePaid(0,this.date);
		}
	}
}
