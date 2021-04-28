package employee;

import java.util.*;

public class EmployeeDataBaseManager {
	EmployeeDBList edbl;
	EmployeeDataBaseManager(EmployeeDBList edbl)
	{
		this.edbl=edbl;
		edbl.addAllData();
	}
	public void printAllEmployees()
	{
		for(Employee e:edbl.allEmployeeList)
		{
			e.printDetails();
		}
	}
	public ArrayList<Employee> getAllEmployeeList()
	{
		return edbl.allEmployeeList;
	}
	public boolean isPresent(int eid)
	{
		for(Employee e:edbl.allEmployeeList)
		{
			if(e.getId()==eid)
				return true;
		}
		return false;
	}
	public Employee printEmployeeDetails(int eid)
	{
		for(Employee e:edbl.allEmployeeList)
		{
			if(e.getId()==eid)
			{
				e.printDetails();
				return e;
			}
				
		}
		return null;
	}
	public Employee getCurrentEmployee(int eid)
	{
		for(Employee e:edbl.allEmployeeList)
		{
			if(e.getId()==eid)
			{
				return e;
			}	
		}
		return null;
	}
}
