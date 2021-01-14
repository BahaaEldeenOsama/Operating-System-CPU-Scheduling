
public class ProcSchedule {
	private String procName;
	private int time;
	
	ProcSchedule(String name, int t) {
		procName = name;
		time = t;
	}
	
	// getters
	public String getProcName() {
		return procName;
	}
	
	public int getTime() {
		return time;
	}
	
	
	// setters
	public void setProcName(String n) {
		procName = n;
	}
	
	public void setTime(int t) {
		time = t;
	}
}
