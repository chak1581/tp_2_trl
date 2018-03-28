
public class Manager {
	String managerName;
	int employeeId;

	public Manager(String ManagerName, int EmployeeId) {
		this.managerName = ManagerName;
		this.employeeId = EmployeeId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String toString() {
		return "Manager: " + this.managerName + ", ID: " + this.employeeId;
	}

}
