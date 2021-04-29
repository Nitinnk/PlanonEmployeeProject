package employee;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

public class PermanentEmployee extends Employee implements IEmployee{
	
	private final double totalSalary;
	private final LocalDate dateOfJoining;
	private final double hra,da;
	private Leaves leaveObject;
	private int monthlyLeaves;
	private int totalLeavesAvailable;
	PermanentEmployee(int id,String name,String type,double salary,Address address,LocalDate dateOfJoining,Leaves leaveObject) {
		super(id,name,type,address,(double)(salary*(80.0f/100.0f)));
		this.hra=salary/10;
		this.da=salary/10;
		this.totalSalary=salary;
		this.dateOfJoining=dateOfJoining;
		this.leaveObject=leaveObject;
		this.totalLeavesAvailable=15;
	}
	public void printAllLeaves()
	{
		leaveObject.printLeaves();
	}
	public LocalDate getJoiningDate()
	{
		return this.dateOfJoining;
	}
	public void printDetails()
	{
		System.out.println("Employee ID : "+this.getId()+"\tName : "+this.getName()+"\tBaseSalary : "+this.getSalary()+"\tEmployee type : "+this.getType()+" Date of Joining is "+this.getJoiningDate());
		System.out.println("Total Leaves : 15 "+"Available Leaves Of this employee : "+this.totalLeavesAvailable);
		System.out.println("Address : ");
		this.printEmployeeAddress();
	}
	public double salaryPerDay(int month)
	{
		return this.getSalary()/this.getDaysInMonth(month);
	}
	public void deductLeaves()
	{
		for(Map.Entry<Integer, Integer>entry:this.leaveObject.getLeaves().entrySet())
		{
			this.totalLeavesAvailable-=entry.getValue();
		}
	}
	public int getAvailableLeaves()
	{
		return this.totalLeavesAvailable;
	}
	public double deductAmount(int leaves,LocalDate currentDate)
	{
		if(this.isSenior(currentDate))
		{
			leaves=(leaves>=2)?leaves-2:(leaves==1)?0:0;
		}
		else
			leaves=(leaves>=1)?leaves--:0;
		return deductBaseSalary(leaves,currentDate.getMonthValue());
	}
	public double deductBaseSalary(int leaves,int month)
	{
		return Math.round(this.salaryPerDay(month)*(getDaysInMonth(month)-leaves));
	}
	public int getNoOfLeavesInMonth(int month)
	{
		return this.leaveObject.getNoOfLeaves(month);
	}
	public double getTotalSalary()
	{
		return this.totalSalary;
	}
	public static int getDaysInMonth(int month)
	{
		return new DaysInAMonth(month).getNoOfDays();
	}
	public boolean isSenior(LocalDate current)
	{
		 long diffInMonths = ChronoUnit.MONTHS.between(this.getJoiningDate(), current);
		 if(diffInMonths<6)
			 return false;
		 return true;
	}
}
