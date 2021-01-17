import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

	public class main {

	public static ArrayList<Process> allProcesses;
	public static ArrayList<ProcSchedule> RRresult;
    public static int processNumber;
    public static int processPriority;
    public static int processArrivingTime;
    public static int processBurstTime;
    private static int Quantum;
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
		 
		 allProcesses = new ArrayList<Process>();
		 
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
			 int contextSwitch = 0;
			 
			 System.out.print("Context-switching time:");	
			 contextSwitch = in.nextInt();
			 
			 System.out.print("Quantum time:");	
			 Quantum = in.nextInt();
			 
			 RRScheduling(Quantum, contextSwitch);
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



	 /// Sort based Priority.
     public static ArrayList<Process> sortPriority(ArrayList<Process> procs) {
		
		ArrayList<Integer> Priority = new ArrayList<Integer>();
		ArrayList<Process> temp = new ArrayList<Process>();
		
		// getting all the arrival times
		for (Process proc : procs) {
			Priority.add(proc.getPriorityNumber());
		}
		
		// sorting Priority
		Collections.sort(Priority);
		
		// storing the sorted processes in temp
		for (Integer Priority_Value : Priority) {
			for (int i = 0; i < procs.size(); i++) {
				
				if (procs.get(i).getPriorityNumber() == Priority_Value) {
					temp.add(procs.get(i));
					procs.remove(i);

					i--;
				}
			}
		}
		
		procs = temp;
		return procs;
	}
     
   /// Sort based Process Name.
     public static ArrayList<Process> sortProcessName(ArrayList<Process> procs) {
		
		ArrayList<String> ProcName = new ArrayList<String>();
		ArrayList<Process> temp = new ArrayList<Process>();
		
		// getting all the arrival times
		for (Process proc : procs) {
			ProcName.add(proc.ProcessName);
		}
		
		// sorting Priority
		Collections.sort(ProcName);
		
		// storing the sorted processes in temp
		for (String ProcessName : ProcName) {
			for (int i = 0; i < procs.size(); i++) {
				
				if (procs.get(i).ProcessName == ProcessName) {
					temp.add(procs.get(i));
					procs.remove(i);

					i--;
				}
			}
		}
		
		procs = temp;
		return procs;
	}

	

	 
	 
	 
	public static void PriorityScheduling() {
		// TODO Auto-generated method stub
		
		ArrayList<Process> myProcs = new ArrayList<Process>(allProcesses);
		myProcs = sortPriority(myProcs); // sorts myProcs based on Priority.
		
		double average_WaitingTime = 0.0,average_Turnaround=0.0;
		boolean flag = true;
		int n= myProcs.size();
		int CompletionTime[] = new int[n];  // complete time
		int turnaroundTime[] = new int[n];  // turn around time
		int waitingTime[] = new int[n];  // waiting time
		
		/*
		for(int i=0;i<myProcs.size();++i)
		{
			System.out.println(myProcs.get(i).ProcessName  + "    "+ myProcs.get(i).priorityNumber );
		}*/
		    
		     
			/// Completion Time
			for(int i=0;i<n;++i)
			{
				if(flag)
				{
					CompletionTime[i] = myProcs.get(i).BurstTime  ;
					flag = false;
				}
				else
				{
						CompletionTime[i] =  CompletionTime[i-1]+myProcs.get(i).BurstTime ;	
				}		
			}
			
			
			/// Waiting Time.
			for(int i=0;i<n;++i)
			{
				waitingTime[i] = ( CompletionTime[i] - myProcs.get(i).BurstTime  );
				average_WaitingTime+=waitingTime[i];
			}
			
			/// Turnaround Time
			for(int i=0 ; i<n;++i)
			{
				turnaroundTime[i] = waitingTime[i] + myProcs.get(i).BurstTime ;
				average_Turnaround+=turnaroundTime[i];
			}
			
			
			
			
			/// Print Process.
			
			System.out.println("Process | Execution Time  | Priority | Arrival Time  | Completion Time | Turnaround Time | Waiting Time ");
			for(int i=0;i<n;++i)
			{
				System.out.print(myProcs.get(i).ProcessName + "		");
				System.out.print(myProcs.get(i).BurstTime + "		");
				System.out.print(myProcs.get(i).priorityNumber + "          ");
				System.out.print(myProcs.get(i).ArrivalTime + "	             ");
				System.out.print(CompletionTime[i] + "	              ");
				System.out.print(turnaroundTime[i] + "                ");
				System.out.print(waitingTime[i]);
				System.out.println();
				
			}
			
			System.out.println();
			System.out.println();
			
			myProcs = sortProcessName(myProcs); // sorts myProcs based on Process Name.
			System.out.println("Process | Execution Time  | Priority | Arrival Time  | Completion Time | Turnaround Time | Waiting Time ");
			for(int i=0;i<n;++i)
			{
				System.out.print(myProcs.get(i).ProcessName + "		");
				System.out.print(myProcs.get(i).BurstTime + "		");
				System.out.print(myProcs.get(i).priorityNumber + "          ");
				System.out.print(myProcs.get(i).ArrivalTime + "	             ");
				System.out.print(CompletionTime[i] + "	              ");
				System.out.print(turnaroundTime[i] + "                ");
				System.out.print(waitingTime[i]);
				System.out.println();
				
			}
			
			System.out.println("Average Waiting Time = " + average_WaitingTime/n);
			System.out.println("Average Turnaround Time = " + average_Turnaround/n);
			
			
			
		
		
	}


	public static void printAllProcSchedule() {
		
		for(int i=0; i < RRresult.size(); i++) {
			System.out.print(RRresult.get(i).getProcName());
			System.out.print(" | ");
			System.out.println(RRresult.get(i).getTime());
			System.out.println("-----");
		}
	}
	
	public static ArrayList<Process> sortArrival(ArrayList<Process> procs) {
		
		ArrayList<Integer> arrival_times = new ArrayList<Integer>();
		ArrayList<Process> temp = new ArrayList<Process>();
		
		// getting all the arrival times
		for (Process proc : procs) {
			arrival_times.add(proc.getArrivalTime());
		}
		
		// sorting arrival times
		Collections.sort(arrival_times);
		
		// storing the sorted processes in temp
		for (Integer arrivalTime : arrival_times) {
			for (int i = 0; i < procs.size(); i++) {
				
				if (procs.get(i).getArrivalTime() == arrivalTime) {
					temp.add(procs.get(i));
					procs.remove(i);

					i--;
				}
				
			}
		}
		
		procs = temp;
		
		return procs;
	}
	
	public static void printProcInfo() {
		
		int counter = 0;
		float sumWaiting = 0, sumTurnaround = 0;

		System.out.println("----------------------------------");
		for (Process proc : allProcesses) {
			System.out.println("Process Name    : " + proc.getProcessName());
			System.out.println("Waiting Time    : " + proc.getWaiting());
			System.out.println("Turnaround Time : " + proc.getTurnaround());
			System.out.println("Service Time    : " + proc.getBurstTime());
			System.out.println("----------------------------------");

			sumWaiting += proc.getWaiting();
			sumTurnaround += proc.getTurnaround();
			counter++;
		}
		
		System.out.println("Average Waiting Time    : " + sumWaiting / counter);
		System.out.println("Average Turnaround Time : " + sumTurnaround / counter);
		System.out.println("----------------------------------");
	}

	public static void RRScheduling(int quantum, int conSwtch) {

		ArrayList<Process> myProcs = new ArrayList<Process>(allProcesses);

		RRresult = new ArrayList<ProcSchedule>();
		int currTime = 0;
		
		myProcs = sortArrival(myProcs); // sorts myProcs based on arrival time
		
		boolean first = true;
		
		// while there's processes in the queue
		while (!myProcs.isEmpty()) {
			
			// for each process (one cycle)
			for(int i=0; i < myProcs.size(); i++) {
				
				// if the process has not reached yet go back to start
				if (!first && myProcs.get(i).getArrivalTime() >= currTime - conSwtch) {
					break;
				}
				
				if (myProcs.get(i).getBurstTimeUpdated() > quantum) {
					
					// adding to the result and update the burst time to be the full quantum time
					RRresult.add(new ProcSchedule(myProcs.get(i).getProcessName(), quantum));
					
					// update the burst time after subtracting the quantum time
					myProcs.get(i).setBurstTimeUpdated(myProcs.get(i).getBurstTimeUpdated() - quantum);
					
					// updating the current time
					currTime += quantum;
					
					// adding the context-switching value and updating time
					RRresult.add(new ProcSchedule("", conSwtch));
					currTime += conSwtch;
				}
				
				else {
					
					// getting the whole burst time into the result
					RRresult.add(new ProcSchedule(myProcs.get(i).getProcessName(),
							myProcs.get(i).getBurstTimeUpdated()));
					
					// updating the current time
					currTime += myProcs.get(i).getBurstTimeUpdated();
					
					// adding the context-switching value and updating time
					RRresult.add(new ProcSchedule("", conSwtch));
					currTime += conSwtch;
					
					// storing the waiting time of this process before removing it from the queue
					for (Process proc : allProcesses) {
						
						if (proc.getProcessName().equals(myProcs.get(i).getProcessName())) {
							proc.setTurnaround(currTime - proc.getArrivalTime());
							proc.setWaiting(proc.getTurnaround() - proc.getBurstTime());
							break;
						}
					}
					
					// removing the process from the queue
					myProcs.remove(i);
					i--; // fixing the left shift caused by the remove function
				}
				
				first = false;
			}
			
				
		}
		
		printAllProcSchedule();
		printProcInfo();
	}



	private static ProcSchedule ProcSchedule(String processName2, int i) {
		// TODO Auto-generated method stub
		return null;
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
