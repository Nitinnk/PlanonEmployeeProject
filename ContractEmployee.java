package employee;

import java.time.LocalDate;

public class ContractEmployee extends Employee  implements IEmployee{
	public ContractEmployee(int id,String name,String type,double salaryPerHour,Address address)
	{
		super(id,name,type,address,salaryPerHour);
	}
	/**
	 * printDetails method will print all the details of the contract employee.
	 * This method is overriden from Employee class.
	 */
	public void printDetails()
	{
		System.out.println("Employee ID : "+this.getId()+"\tName : "+this.getName()+"\tAmount per Hour : "+this.getSalary()+"\tEmployee type : "+this.getType());
		System.out.println("Address : ");
		this.printEmployeeAddress();
	}
	/**
	 * getSalaryperMonth(int days,int month) method will calculate and return the amount that needs to be paid to the contract employee for that month.
	 * Return type: double.
	 * @param days
	 * @param month
	 * @return
	 */
	public double getSalaryperMonth(int days,int month)
	{
		int daysInMonth=new DaysInAMonth(month).getNoOfDays();
		if(month<=6 && days<=1)
		{
			
		}	
		else
			if(month>6 && month<=12 && days<=2)
			{
				
			}
			else
				if(month<=6 && days>1)
					days--;
				else
					if(month>6 && month<=12 && days>2)
						days-=2;
		daysInMonth-=days;
		return this.getSalary()*8*daysInMonth;
	}
	public double salaryToBePaid(int leaves,int month)
	{
		return this.getSalaryperMonth(leaves,month);
	}
	public double salaryToBePaid(int leaves,LocalDate date)
	{
		return this.getSalaryperMonth(leaves,date.getMonthValue());
	}
}
