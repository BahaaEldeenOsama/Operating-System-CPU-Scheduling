public class Process {
	
	public String ProcessName;
	public int ArrivalTime;
	public int BurstTime;
	public int BurstTimeUpdated;
	public int priorityNumber;
	public int Quantum;
	private int turnaroundTime;
	private int waitingTime;

    public Process(String ProcessName, int ArrivalTime, int BurstTime, int priorityNumber) 
    {
        this.ProcessName = ProcessName;
        this.ArrivalTime = ArrivalTime;
        this.BurstTime = this.BurstTimeUpdated = BurstTime;
        this.priorityNumber = priorityNumber;
    }
    
   
    public void setName(String ProcessName) {
        this.ProcessName = ProcessName;
    }
    public String getProcessName() {
        return ProcessName;
    }
  

    
    
    public void setArrivalTime(int arrivalTime) {
        this.ArrivalTime = arrivalTime;
    }
    public int getArrivalTime() {
        return ArrivalTime;
    }
    

    
    public void setBurstTime(int burstTime) {
        this.BurstTime = burstTime;
    }    
    public int getBurstTime() {
        return BurstTime;
    }
    
    public void setBurstTimeUpdated(int burstTime) {
        this.BurstTimeUpdated = burstTime;
    }   
    public int getBurstTimeUpdated() {
        return BurstTimeUpdated;
    }

    
    public void setPriorityNumber(int priorityNumber) {
        this.priorityNumber = priorityNumber;
    }
    public int getPriorityNumber() {
        return priorityNumber;
    }
    
    
    public void setQuantum(int Quantum) {
        this.Quantum = Quantum;
    }
    public int getQuantum() {
        return priorityNumber;
    }
	
	public void setTurnaround(int trt) {
		turnaroundTime = trt;
	}
    
	public int getTurnaround() {
		return turnaroundTime;
	}
	
	public void setWaiting(int wt) {
		waitingTime = wt;
	}
	
	public int getWaiting() {
		return waitingTime;
	}
 
    
}