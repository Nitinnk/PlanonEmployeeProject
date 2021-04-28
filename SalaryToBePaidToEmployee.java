package employee;

public class SalaryToBePaidToEmployee {
	private IEmployee e;
	private int leaves,month;
	private double salary;
	SalaryToBePaidToEmployee(IEmployee e,int leaves,int month)
	{
		this.e=e;
		this.leaves=leaves;
		this.month=month;
		checkSalary();
	}
	public void checkSalary()
	{
		switch(e.getType())
		{
		case "permanent":
			CheckPermanentEmployeeSalary cp=new CheckPermanentEmployeeSalary((PermanentEmployee) e,leaves,month);
			break;
		case "contract":
			CheckContractAmount ca=new CheckContractAmount((ContractEmployee)e,month,leaves);
			break;
		default:
			break;
		}
	}
	
}
