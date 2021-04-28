package employee;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		EmployeeDBList edbl1=EmployeeDBList.getInstance();
		//edbl.addAllData();
		EmployeeDataBaseManager edbl=new EmployeeDataBaseManager(edbl1);
		//edbl.printAllEmployees();
		/**
		 * Employee ID's are 21,31,41,51,100,200,300,400,500.
		 */
		takeInputs(edbl,in);
		
	}
	public static void takeInputs(EmployeeDataBaseManager edbl,Scanner in)
	{
		System.out.println("Choose the operation number");
		System.out.println("1-Print Details of all the employees");
		System.out.println("2-Get total salaries paid to all employee upto current month");
		System.out.println("3-Get total salary paid to one employee upto the current month");
		System.out.println("4-Check the Amount of salary to be paid to an Employee");
		System.out.println("5-All Employees salary for this month");
		System.out.println("6-Exit");
		int choice=in.nextInt();
		switch(choice)
		{
		case 1:
			edbl.printAllEmployees();
			askHomePage(edbl,in);
			break;
		case 2:
			TotalSalaryCount tsc=new TotalSalaryCount(edbl,getMonth(in));
			askHomePage(edbl,in);
			break;
		case 3:
			int eid=takeEID(edbl,in);
			Employee employee=edbl.getCurrentEmployee(eid);
			TotalSalaryPaidToEmployee t=new TotalSalaryPaidToEmployee(employee,getMonth(in));
			askHomePage(edbl,in);
			break;
		case 4:
			int eid1=takeEID(edbl,in);
			Employee current=edbl.printEmployeeDetails(eid1);
			String type=current.getType();
			System.out.println("Enter the number of leaves taken : ");
			int noOfLeaves=in.nextInt();
			int month=getMonth(in);
			SalaryToBePaidToEmployee ss=new SalaryToBePaidToEmployee(current,noOfLeaves,month);
			askHomePage(edbl,in);
			break;
		case 5:
			AllEmployeeSalaryForThisMonth aesftm=new AllEmployeeSalaryForThisMonth(edbl,getMonth(in));
			askHomePage(edbl,in);
			break;
		case 6:
			System.exit(0);
			default:
				System.out.println("Invalid Input");
				System.exit(0);
		}
	}
	public static int getMonth(Scanner in)
	{
		System.out.print("Enter the month : ");
		return in.nextInt();
		/*System.out.print("Enter the Date(yyyy/mm/dd) : ");
		Date date = new Date(in.next());
		//LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month=date.getMonth();
		return month;*/
	}
	public static void askHomePage(EmployeeDataBaseManager edbl,Scanner in)
	{
		System.out.println("Choose Your Next Action ");
		System.out.println("1 - Go back to home page");
		System.out.println("2 - Exit");
		int choice= in.nextInt();
		switch(choice)
		{
		case 1:
			takeInputs(edbl,in);
			break;
		case 2:
			System.exit(0);
		default:
			System.exit(0);
		}
	}
	public static int takeEID(EmployeeDataBaseManager edbl,Scanner in)
	{
		System.out.print("Enter the Employee ID : ");
		int temp=in.nextInt();
		if(edbl.isPresent(temp))
			return temp;
		else
		{
			System.out.print("The ID entered does not exist in our DatBase\nDo you want to enter the ID again (y/n) :");
			char c=in.next().charAt(0);
			switch(c)
			{
			case 'y':
				return takeEID(edbl,in);
			case 'n':
				System.exit(0);
			default:
				System.out.println("Invalid Input");
				System.exit(0);
				break;
			}
		}
		return 0;
			
	}

}
