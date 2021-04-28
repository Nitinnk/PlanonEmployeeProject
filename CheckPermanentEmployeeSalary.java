package employee;
import java.util.*;
public class CheckPermanentEmployeeSalary {
	PermanentEmployee e;
	int noOfLEaves,month;
	CheckPermanentEmployeeSalary(PermanentEmployee current,int noOfLEaves,int month)
	{
		this.e=current;
		this.noOfLEaves=noOfLEaves;
		this.month=month;
		System.out.println("Original Salary Is "+current.getPermanentSalary()+"\nSalary to be paid is : "+e.deductAmount(noOfLEaves,month));
		//System.out.println("Original Salary Is "+current.getPermanentSalary()+"\nSalary to be paid is : "+current.getSalary());
	}
	
}
