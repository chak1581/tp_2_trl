
public class Worker {

	private int workerID;
	private String workerName;
	
	public Worker(int workerID, String workername)
	{
		this.workerID = workerID;
		this.workerName = workername;
	}
	public Worker() {
		
	}
	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workername) {
		this.workerName = workername;
	}

	public int getWorkerID() {
		return workerID;
	}

	public void setWorkerID(int workerID) {
		this.workerID = workerID;
	}

	public String toString() {
		return "Worker: " + this.workerName + " ID: " + this.workerID;
	}
	
}
