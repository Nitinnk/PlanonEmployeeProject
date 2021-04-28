package employee;

public class TotalSalaryPaidToEmployee {
	Employee employee;
	int month;
	double totalSalary;
	public TotalSalaryPaidToEmployee(IEmployee employee, int month) {
		this.employee=(Employee) employee;
		this.month=month;
		this.totalSalary=checkTotalSalary( employee);
		this.printTotalSalary();
	}
	public static double checkSalaryUtil(IEmployee p,int month)
	{
		double sum=0;
		for(int i=1;i<=month;i++)
		{
			if(p.getType().equalsIgnoreCase("permanent"))
			{
				sum+=p.getSalary();
			}
			else
			{
				ContractEmployee c=new ContractEmployee(p.getId(),p.getName(),p.getType(),p.getSalary(),p.getAddress());
				sum+=c.salaryToBePaid(0, i);
			}
			
		}
		System.out.println("Total salary paid until now to "+p.getName() +" is "+sum);
		return sum;
	}
	public void printTotalSalary()
	{
		System.out.println("Total salary paid until now to "+employee.getName() +" is "+this.totalSalary);
	}
	public double getTotalSalary()
	{
		return this.totalSalary;
	}
	public double checkTotalSalary(IEmployee p)
	{
		double sum=0;
		for(int i=1;i<=month;i++)
		{
			if(p.getType().equalsIgnoreCase("permanent"))
			{
				sum+=p.getSalary();
			}
			else
			{
				ContractEmployee c=new ContractEmployee(p.getId(),p.getName(),p.getType(),p.getSalary(),p.getAddress());
				sum+=c.salaryToBePaid(0, i);
			}
			
		}
		return sum;
	}
}
