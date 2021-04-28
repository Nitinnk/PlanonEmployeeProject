package employee;

import java.text.DecimalFormat;

public class Employee implements IEmployee{
	private String name;
	private String type;
	private int id;
	private double salary;
	private Address address;
	Employee(String name)
	{
		this.name=name;
	}
	Employee(String name,String type)
	{
		this.name=name;
		this.type=type;
	}
	Employee(int id,String name,String type,Address address,double salary)
	{
		this.name=name;
		this.type=type;
		this.id=id;
		this.address=address;
		this.salary=salary;
	}
	public void printEmployeeAddress()
	{
		this.address.printAddress();
	}
	@Override
	public Address getAddress()
	{
		return this.address;
	}
	@Override
	public int getId()
	{
		return this.id;
	}
	@Override
	public double getSalary()
	{
		
		return Math.round(this.salary);
	}
	@Override
	public String getName()
	{
		return this.name;
	}
	@Override
	public String getType()
	{
		return this.type;
	}
	public void printDetails()
	{
		System.out.println("Employee ID : "+this.getId()+" Employee Name : "+this.getName()+" Employee type : "+this.getType());
	}
	public void setSalary(double salary)
	{
		this.salary=salary;
	}
	
}
