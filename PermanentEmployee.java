package employee;

import java.text.DecimalFormat;

public class PermanentEmployee extends Employee implements IEmployee{
	
	private int noOfLeaves;
	private final double permanentSalary;
	PermanentEmployee(int id,String name,String type,double salary,Address address) {
		super(id,name,type,address,salary);
		this.noOfLeaves=15;
		this.permanentSalary=salary;
	}
	public void printDetails()
	{
		System.out.println("Employee ID : "+this.getId()+"\tName : "+this.getName()+"\tSalary : "+this.getSalary()+"\tEmployee type : "+this.getType());
		System.out.println("Address : ");
		this.printEmployeeAddress();
	}
	public int getCurrentNoOfLeaves()
	{
		return this.noOfLeaves;
	}
	public double salaryPerDay(int month)
	{
		return this.getSalary()/this.getDaysInMonth(month);
	}
	public double deductAmount(int days,int month)
	{
		if(month<=6 && days<=1)
			return this.getPermanentSalary();
		else
			if(month>6 && month<=12 && days<=2)
				return this.getPermanentSalary();
			else
				if(month<=6 && days>1)
					days--;
				else
					if(month>6 && month<=12 && days>2)
						days-=2;
		return Math.round(this.getSalary()- this.salaryPerDay(month)*days);
	}
	public double getPermanentSalary()
	{
		return this.permanentSalary;
	}
	public void availLeaves(int leave)
	{
		this.noOfLeaves=this.noOfLeaves-leave;
	}
	public static int getDaysInMonth(int month)
	{
		return new DaysInAMonth(month).getNoOfDays();
	}
	public int noOfWorkingDays(PermanentEmployee p,int month)
	{
		return PermanentEmployee.getDaysInMonth(month)- p.getCurrentNoOfLeaves();
	}
}
