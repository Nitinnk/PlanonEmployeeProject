package employee;

public class DaysInAMonth {
	 int month=0; 
     String MonthOfName;
     public DaysInAMonth(int month)
     {
    	 this.month=month;
     }
     public int getNoOfDays()
     {
    	 return gnd(this.month);
     }
     private int gnd(int month)
     {
    	 int number_Of_DaysInMonth=0;
     switch(month)
     {
         case 1:
             MonthOfName = "January";
             number_Of_DaysInMonth = 31;
             break;
         case 2:
             MonthOfName = "February";
             /*if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                 number_Of_DaysInMonth = 29;
             } else {
                 number_Of_DaysInMonth = 28;
             }*/
             number_Of_DaysInMonth = 28;
             break;
         case 3:
             MonthOfName = "March";
             number_Of_DaysInMonth = 31;
             break;
         case 4:
             MonthOfName = "April";
             number_Of_DaysInMonth = 30;
             break;
         case 5:
             MonthOfName = "May";
             number_Of_DaysInMonth = 31;
             break;
         case 6:
             MonthOfName = "June";
             number_Of_DaysInMonth = 30;
             break;
         case 7:
             MonthOfName = "July";
             number_Of_DaysInMonth = 31;
             break;
         case 8:
             MonthOfName = "August";
             number_Of_DaysInMonth = 31;
             break;
         case 9:
             MonthOfName = "September";
             number_Of_DaysInMonth = 30;
             break;
         case 10:
             MonthOfName = "October";
             number_Of_DaysInMonth = 31;
             break;
         case 11:
             MonthOfName = "November";
             number_Of_DaysInMonth = 30;
             break;
         case 12:
             MonthOfName = "December";
             number_Of_DaysInMonth = 31;
     }
     return number_Of_DaysInMonth;
     }

}