package employee;

public class ContractEmployee extends Employee  implements IEmployee{
	private double salary;
	ContractEmployee(int id,String name,String type,double salaryPerHour,Address address)
	{
		super(id,name,type,address,salaryPerHour);
	}
	public void printDetails()
	{
		System.out.println("Employee ID : "+this.getId()+"\tName : "+this.getName()+"\tAmount per Hour : "+this.getSalary()+"\tEmployee type : "+this.getType());
		System.out.println("Address : ");
		this.printEmployeeAddress();
	}
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
}
