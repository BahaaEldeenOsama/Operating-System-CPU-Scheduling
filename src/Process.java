public class Process {
public String ProcessName;
public int ArrivalTime;
public int BurstTime;
public int priorityNumber;
public int Quantum;

 

    public Process(String ProcessName, int ArrivalTime, int BurstTime, int priorityNumber) 
    {
        this.ProcessName = ProcessName;
        this.ArrivalTime = ArrivalTime;
        this.BurstTime = BurstTime;
        this.priorityNumber = priorityNumber;
    }
    
   
    public void setName(String ProcessName) {
        this.ProcessName = ProcessName;
    }
    public String getProcessName() {
        return ProcessName;
    }
  

    
    
    public void setArrivalTime(int arrivalTime) {
        this.ArrivalTime = ArrivalTime;
    }
    public int getArrivalTime() {
        return ArrivalTime;
    }
    

    
    public void setBurstTime(int burstTime) {
        this.BurstTime = BurstTime;
    }    
    public int getBurstTime() {
        return BurstTime;
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
    

 
    
}