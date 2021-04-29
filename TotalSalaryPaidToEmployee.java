package employee;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

public class TotalSalaryPaidToEmployee {
	private Employee employee;
	private double totalSalary;
	private static LocalDate date;
	public TotalSalaryPaidToEmployee(IEmployee employee, LocalDate date) {
		this.employee=(Employee) employee;
		this.date=date;
		this.totalSalary=checkTotalSalary( employee);
	}
	public static double checkSalaryUtil(IEmployee p,int month)
	{
		System.out.println("Check total salary method");
		double sum=0;
		if(p.getType().equalsIgnoreCase("permanent"))
		{
			System.out.println("Permanent case");
			sum+=checkTotalSalaryOfPermanentEmployee((PermanentEmployee) p);
		}
		else
		{
			for(int i=1;i<=month;i++)
			{
					ContractEmployee c=new ContractEmployee(p.getId(),p.getName(),p.getType(),p.getSalary(),p.getAddress());
					sum+=c.salaryToBePaid(0, i);
			}
		}
		
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
	/**
	 * checkTotalSalaryOfPermanentEmployee mthod will calculate and return the total salary of permanent employee paid upto the given month.
	 * @param p
	 * @return
	 */
	public static double checkTotalSalaryOfPermanentEmployee(PermanentEmployee p)
	{
		int monthlyLeaves=1;
		double sum=0;
		LocalDate current=date;
		LocalDate temp=p.getJoiningDate();
		System.out.println("Current Date : "+current+" Date Of Joining : "+temp);
		for (LocalDate date = temp; date.isBefore(current); date = date.plusMonths(1)) {
			int leavesTaken=p.getNoOfLeavesInMonth(date.getMonthValue());
			if(!p.isSenior(date))
			{
				if(leavesTaken<=monthlyLeaves)
				{
					sum+=p.getSalary();
					monthlyLeaves+=Math.abs(monthlyLeaves-leavesTaken);
				}
				else
				{
					leavesTaken-=monthlyLeaves;
					monthlyLeaves=1;
					double temp1=p.deductBaseSalary(leavesTaken, temp.getMonthValue());
					sum+=temp1;
				}
			}
			if(p.isSenior(date))
			{
				monthlyLeaves+=monthlyLeaves+2;
				if(leavesTaken<=monthlyLeaves)
				{
					sum+=p.getSalary();
					monthlyLeaves+=Math.abs(monthlyLeaves-leavesTaken);
				}
				else
				{
					leavesTaken-=monthlyLeaves;
					sum+=p.deductBaseSalary(leavesTaken, temp.getMonthValue());
				}
			}
	    }
		return sum;
	}
	/**
	 * checkTotalSalary method will check the total salary paid to the employee upto the given date.
	 * @param p
	 * @return
	 */
	public double checkTotalSalary(IEmployee p)
	{
		double sum=0;
		if(p.getType().equalsIgnoreCase("permanent"))
		{
			sum+=checkTotalSalaryOfPermanentEmployee((PermanentEmployee) p);
		}
		else
		{
			for(int i=1;i<=date.getMonthValue();i++)
			{
					ContractEmployee c=new ContractEmployee(p.getId(),p.getName(),p.getType(),p.getSalary(),p.getAddress());
					sum+=c.salaryToBePaid(0, i);
			}
		}
		return sum;
	}
	
}
