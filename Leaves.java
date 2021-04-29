package employee;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
public class Leaves {
	private HashMap<Integer,Integer>leaves;
	public HashMap<Integer,Integer> getLeaves() {
		return leaves;
	}
	public void setLeaves(HashMap<Integer,Integer> leaves) {
		this.leaves = leaves;
	}
	public void addLeave(int month,int noOfLeaves)
	{
		if(this.leaves==null)
			leaves=new HashMap<Integer,Integer>();
		leaves.put(month,noOfLeaves);
	}
	public int getNoOfLeaves(int month)
	{
		return this.leaves.get(month);
	}
	/**
	 * assignLeaves method will assign some Random leaves to the permanent employee.
	 * @param joiningDate
	 * @param current
	 * @return
	 */
	public HashMap<Integer,Integer> assignLeaves(LocalDate joiningDate,LocalDate current)
	{
		if(this.leaves==null)
			leaves=new HashMap<Integer,Integer>();
		int x=0,totalLeave=0;
			for (LocalDate date = joiningDate; date.isBefore(current); date = date.plusMonths(1)) {
				if(date==joiningDate)
				{
					leaves.put(date.getMonthValue(),3);
				}
				else
				{
					if(totalLeave>15)
					{
						leaves.put(date.getMonthValue(), 0);
					}
					else
					{
						leaves.put(date.getMonthValue(), x++);
					}
				}
				if(x==5)
					x=0;
				if(x==0)
					totalLeave+=3;
				else
					totalLeave+=x;
		    }
		return leaves;
	}
	/**
	 * printLeaves method will print all the leaves in the leaves HashMap.
	 */
	public void printLeaves()
	{
		for(Map.Entry<Integer, Integer>entry:this.leaves.entrySet())
		{
			System.out.println("Month : "+Month.of(entry.getKey())+" No Of Leaves : "+entry.getValue());
		}
	}
	
}
