package employee;
import java.util.*;
public class EmployeeDBList {
		private static EmployeeDBList edbl;
		static ArrayList<Employee>allEmployeeList;
		private EmployeeDBList()
		{
			
		}
		public static EmployeeDBList getInstance()
		{
			if(edbl==null)
				edbl=new EmployeeDBList();
			return edbl;
		}
		public static void addEmployee(Employee e)
		{
			if(allEmployeeList==null)
				allEmployeeList=new ArrayList<Employee>();
			allEmployeeList.add(e);
		}
		public void addAllData()
		{
			Address address1=new Address("West MarredPally","Secunderabad","500026");
			PermanentEmployee e1=new PermanentEmployee(11,"Nitin","permanent",50000,address1);
			addEmployee(e1);
			Address address2=new Address("Alwal","Secunderabad","500010");
			PermanentEmployee e2=new PermanentEmployee(21,"Sowmya","permanent",80000,address2);
			addEmployee(e2);
			Address address3=new Address("koti","Hyderabad","500020");
			PermanentEmployee e3=new PermanentEmployee(31,"Rahul","permanent",90000,address3);
			addEmployee(e3);
			Address address4=new Address("Banjara Hills","Hyderabad","500062");
			PermanentEmployee e4=new PermanentEmployee(41,"Vivek","permanent",40000,address4);
			addEmployee(e4);
			Address address5=new Address("Begumpet","Secunderabad","500032");
			PermanentEmployee e5=new PermanentEmployee(51,"Dheeraj","permanent",20000,address1);
			addEmployee(e5);
			ContractEmployee c1=new ContractEmployee(100,"Vinduja","contract",100,address2);
			addEmployee(c1);
			ContractEmployee c2=new ContractEmployee(200,"Pavan","contract",200,address3);
			addEmployee(c2);
			ContractEmployee c3=new ContractEmployee(300,"Krishna","contract",300,address4);
			addEmployee(c3);
			ContractEmployee c4=new ContractEmployee(400,"Nikitha","contract",400,address5);
			addEmployee(c4);
			ContractEmployee c5=new ContractEmployee(500,"Girish","contract",500,address1);
			addEmployee(c5);
		}
}
