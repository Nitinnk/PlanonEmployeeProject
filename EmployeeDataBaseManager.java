package employee;
import java.util.*;
public class EmployeeDataBaseManager {
	private EmployeeDBList edbl;
	public EmployeeDataBaseManager(EmployeeDBList edbl)
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
	/**
	 * isPresent method will check wether the given Employee ID is present in the database or not.
	 * @param eid
	 * @return
	 */
	public boolean isPresent(int eid)
	{
		for(Employee e:edbl.allEmployeeList)
		{
			if(e.getId()==eid)
				return true;
		}
		return false;
	}
	/**
	 * printAllEmployeeDetails method will print all the employee details.
	 * @param eid
	 * @return
	 */
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
	/**
	 * getCurrentEmployee method will return the employee object based on the given Employee ID
	 * @param eid
	 * @return
	 */
	public Employee getCurrentEmployee(int employeeId)
	{
		for(Employee e:edbl.allEmployeeList)
		{
			if(e.getId()==employeeId)
			{
				return e;
			}	
		}
		return null;
	}
}
