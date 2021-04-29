package employee;

import java.time.LocalDate;

public class SalaryToBePaidToEmployee {
	private IEmployee e;
	private int leaves,month;
	private LocalDate date;
	SalaryToBePaidToEmployee(IEmployee e,int leaves,int month)
	{
		this.e=e;
		this.leaves=leaves;
		this.month=month;
	}
	SalaryToBePaidToEmployee(IEmployee e,int leaves,LocalDate date)
	{
		this.e=e;
		this.leaves=leaves;
		this.date=date;
	}
	/**
	 * checkSalary() method will check and print the salary to be paid to employee for that particular month.
	 */
	public void checkSalary()
	{
		switch(e.getType())
		{
		case "permanent":
			System.out.println("Original Salary Is "+this.e.getSalary()+"\nSalary to be paid is : "+((PermanentEmployee) this.e).deductAmount(this.leaves,this.date));
			break;
		case "contract":
			System.out.println("Amount to be paid is : "+((ContractEmployee) this.e).salaryToBePaid(leaves,this.date));
			break;
		default:
			break;
		}
	}
	
}
