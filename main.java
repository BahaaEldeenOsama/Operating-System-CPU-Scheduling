import java.util.ArrayList;
import java.util.Scanner;

	public class main {

	public static ArrayList<Process> allProcesses = new ArrayList<Process>();
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
		 Process job;
		 job = new Process();
		 
		 /// *********************************************************************************************
			System.out.println("Enter the process number :   ");
			   processNumber = in.nextInt();       
			       
		        for(int i=0; i<processNumber;++i)
		        {  	
		        	/// Process Name.
		            System.out.println("Enter the process name:  ");
		            ProcessName = in.next();
		            job.setName(ProcessName);
		        	
		        	/// Arriving Time.
		            System.out.println("Enter the process Arriving Time:   ");
		            processArrivingTime = in.nextInt();       
		        	job.setArrivalTime(processArrivingTime);
		            
		            /// Burst Time.
		            System.out.println("Enter the process Burst Time:  ");
		            processBurstTime = in.nextInt();
		            job.setBurstTime(processBurstTime);
		            
		            /// Priority.
		            System.out.println("Enter the process Priority:  ");
		            processPriority = in.nextInt();
		            
		            allProcesses.add(new Process(ProcessName, processArrivingTime, processBurstTime, processPriority));
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
		 System.out.print("Make a choice: ");	
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
		int n= allProcesses.size();
		String pname[] = new String[n]; // process name
		int arrivalt[] = new int[n];  // arrival time
		int burstt[] = new int[n];  // burst time
		int complett[] = new int[n];  // complete time
		int turnaround[] = new int[n];  // turn around time
		int waitingt[] = new int[n];  // waiting time
		int flag[]  = new int[n];  //  flag to checks process is completed or not
		int k[]  = new int[n];  // it is also stores burst time
	    int i, startT=0, tot=0;
	    float avgwt=0, avgta=0;
 
	    for (i=0;i<n;i++)
	    {
	    	pname[i]= allProcesses.get(i).ProcessName;
	    	arrivalt[i]= allProcesses.get(i).ArrivalTime;
	    	burstt[i]= allProcesses.get(i).BurstTime;
	    	k[i]= burstt[i];
	    	flag[i]= 0;
	    }
	    
	    while(true){
	    	int min=200,c=n;
	    	if (tot==n)
	    		break;
	    	
	    	for ( i=0;i<n;i++)
	    	{
	    		if ((arrivalt[i]<=startT) && (flag[i]==0) && (burstt[i]<min))
	    		{	
	    			min=burstt[i];
	    			c=i;
	    		}
	    	}
	    	
	    	if (c==n)
	    		startT++;
	    	else
	    	{
	    		burstt[c]--;
	    		System.out.print(pname[c]+ " | ");
	    		startT++;
	    		if (burstt[c]==0)
	    		{
	    			complett[c]= startT;
	    			flag[c]=1;
	    			tot++;
	    		}
	    	}
	    }
	    
	    for(i=0;i<n;i++)
	    {
	    	turnaround[i] = complett[i] - arrivalt[i];
	    	waitingt[i] = turnaround[i] - k[i];
	    	avgwt+= waitingt[i];
	    	avgta+= turnaround[i];
	    }
	    System.out.println();
	    System.out.println("p_name \t|   arrival \t|   burst \t|  turnaround \t|    waiting");
	    for(i=0;i<n;i++)
	    {
	    	System.out.println(pname[i] +"\t|\t"+ arrivalt[i]+"\t|\t"+ k[i]  +"\t|\t"+ turnaround[i] +"\t|\t"+ waitingt[i]);
	    }
	    
	    System.out.println("\naverage Turnaround time is: "+ (float)(avgta/n));
	    System.out.println("average Waiting time is: "+ (float)(avgwt/n));
	   
	}
		
		
	}



	


