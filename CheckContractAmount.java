package employee;

import java.util.Scanner;

public class CheckContractAmount {
		Employee e;
		int month,leaves;
		CheckContractAmount(ContractEmployee e,int month,int leaves)
		{
			this.e=e;
			this.month=month;
			this.leaves=leaves;
			
			System.out.println("Amount to be paid is : "+e.salaryToBePaid(leaves,month));
		}
}
