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
	public void printAllEmployeeSalaries()
	{
		for(IEmployee e:edbl.getAllEmployeeList())
		{
			System.out.println("Total salary paid to "+e.getName()+" is "+checkThisMonthSalary(e));
		}
	}
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
