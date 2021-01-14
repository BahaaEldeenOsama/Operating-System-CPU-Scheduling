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



	public static void PriorityScheduling() {
		// TODO Auto-generated method stub
	        	        
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
		// TODO Auto-generated method stub
		
	}



	

}
