package employee;

public class TotalSalaryCount {
	EmployeeDataBaseManager edbl;
	int month;
	TotalSalaryCount(EmployeeDataBaseManager edbl,int month)
	{
		this.edbl=edbl;
		this.month=month;
		this.printAllEmployeeSalaries();
	}
	public void printAllEmployeeSalaries()
	{
		for(IEmployee e:edbl.getAllEmployeeList())
		{
			//new TotalSalaryPaidToEmployee(e,this.month);
			TotalSalaryPaidToEmployee.checkSalaryUtil(e, this.month);
		}
	}
}
