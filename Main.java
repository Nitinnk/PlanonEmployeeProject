package employee;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner in=new Scanner(System.in);
		EmployeeDBList edbl1=EmployeeDBList.getInstance();
		EmployeeDataBaseManager edbl=new EmployeeDataBaseManager(edbl1);
		/**
		 * Employee ID's are 21,31,41,51,100,200,300,400,500.
		 */
		takeInputs(edbl,in);
	}
	/**
	 * Take Inputs will take the inputs from the user.
	 * @param edbl
	 * @param in
	 * @throws ParseException
	 */
	public static void takeInputs(EmployeeDataBaseManager edbl,Scanner in) throws ParseException
	{
		System.out.println("Choose the operation number");
		System.out.println("1-Print Details of all the employees");
		System.out.println("2-Get total salaries paid to all employee upto current month");
		System.out.println("3-Get total salary paid to one employee upto the current month");
		System.out.println("4-Check the Amount of salary to be paid to an Employee");
		System.out.println("5-All Employees salary for this month");
		System.out.println("6-Print All Leaves Taken by a Permanent employee");
		System.out.println("7-Exit");
		int choice=in.nextInt();
		switch(choice)
		{
		case 1:
			edbl.printAllEmployees();
			askHomePage(edbl,in);
			break;
		case 2:
			TotalSalaryCount tsc=new TotalSalaryCount(edbl,getDate(in));
			tsc.printAllEmployeeSalaries();
			askHomePage(edbl,in);
			break;
		case 3:
			int eid=takeEID(edbl,in);
			Employee employee=edbl.getCurrentEmployee(eid);
			TotalSalaryPaidToEmployee t=new TotalSalaryPaidToEmployee(employee,getDate(in));
			t.printTotalSalary();
			askHomePage(edbl,in);
			break;
		case 4:
			int eid1=takeEID(edbl,in);
			Employee current=edbl.printEmployeeDetails(eid1);
			String type=current.getType();
			System.out.println("Enter the number of leaves taken : ");
			int noOfLeaves=in.nextInt();
			SalaryToBePaidToEmployee ss=new SalaryToBePaidToEmployee(current,noOfLeaves,getDate(in));
			ss.checkSalary();
			askHomePage(edbl,in);
			break;
		case 5:
			AllEmployeeSalaryForThisMonth aesftm=new AllEmployeeSalaryForThisMonth(edbl,getDate(in));
			aesftm.printSalaries();
			askHomePage(edbl,in);
			break;
		case 6:
			int eid6=takeEID(edbl,in);
			IEmployee temp= edbl.getCurrentEmployee(eid6);
			if(temp.getType().equalsIgnoreCase("contract"))
			{
				System.out.println("Contract Employee has only loss of pay");
				askHomePage(edbl,in);
			}
			else
			{
				PermanentEmployee pemployee=(PermanentEmployee) edbl.getCurrentEmployee(eid6);
				pemployee.printAllLeaves();
				askHomePage(edbl,in);
			}
			break;
		case 7:
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
	}
	public static LocalDate getDate(Scanner in) throws ParseException
	{
		System.out.println("Enter the current Date(M/d/yyyy) : ");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
	    LocalDate date = LocalDate.parse(in.next(), dateFormat);
		return date;
	}
	public static void askHomePage(EmployeeDataBaseManager edbl,Scanner in) throws ParseException
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
