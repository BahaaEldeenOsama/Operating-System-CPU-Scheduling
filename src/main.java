import java.util.ArrayList;
import java.util.Scanner;

	public class main {

	public static ArrayList<Process> allProcesses;
    public static int processNumber;
    public static int processPriority;
    public static int processArrivingTime;
    public static int processBurstTime;
    private int Quantum;
    public static String ProcessName;
    public static Scanner in;
    
    
    public main() {
	// TODO Auto-generated constructor stub
    processNumber = 0;
    processPriority = 0;
    processArrivingTime = 0;
    processBurstTime = 0;
    Quantum=0;
   
    
    }
	
	
	
	 public static void main(String[] args) {
		 in = new Scanner(System.in);     
		 int choice = 0;
		 
		 /// *********************************************************************************************
			System.out.println("Enter the process number :   ");
			   processNumber = in.nextInt();       
			       
		        for(int i=0; i<processNumber;++i)
		        {  	
		        	/// Process Name.
		            System.out.println("Enter the process name:  ");
		            ProcessName = in.next();
		        	
		        	/// Arriving Time.
		            System.out.println("Enter the process Arriving Time:   ");
		            processArrivingTime = in.nextInt();       
		        	
		            
		            /// Burst Time.
		            System.out.println("Enter the process Burst Time:  ");
		            processBurstTime = in.nextInt();
		            
		            /// Priority.
		            System.out.println("Enter the process Priority:  ");
		            processPriority = in.nextInt();
		            
		            allProcesses.add(new Process(ProcessName,processArrivingTime,processBurstTime,processPriority));
		        }
		 
		 /// ***********************************************************************************************************
		 
		        
		/// Now You have all Process to apply your Algorithm. 
		 		        
		 while(true)
		 {
		 System.out.println("=============================================================");
		 System.out.println("Enter(1)..for preemptive Shortest- Job First (SJF) Scheduling");
		 System.out.println("Enter(2)..for Round Robin (RR) Scheduling");
		 System.out.println("Enter(3)..for Priority Scheduling");
		 System.out.println("Enter(4)..for Multi level");
		 System.out.println("Enter(5)..exit");
		 System.out.println("=============================================================");	
		 System.out.print("Make a choice ..");	
	     choice= in.nextInt();
		 
	     /// Twatiy
		 if(choice==1)
		 {
			 SJFScheduling();
		 }
		 /// Abdo
		 else if(choice==2)
		 {
			 RRScheduling();
		 }
		 /// Bahaa
		 else if(choice==3)
		 {
			 PriorityScheduling();
		 }
		 else if(choice==4)
		 {
		   
			 /*
			  * 
			  * 
			  * 
			  */
			 
		 }
		 else if(choice==5)
		 {
		    break;	 
		 }
		 else
		 {
			 System.out.print("Wrong input!!");
		 }
	  }
		
		 
		 
	 }



	public static void PriorityScheduling() {
		// TODO Auto-generated method stub
	        	        
	}



	public static void RRScheduling() {
		// TODO Auto-generated method stub
		
	}



	public static void SJFScheduling() {
		// TODO Auto-generated method stub
		
	}



	

}
