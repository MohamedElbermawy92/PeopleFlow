package backend_challenge.starter.kafka;



public class Message {

	private String EmployeeName;
	private String state;
	
	public Message() {
		
	}
	
	public Message(String employeeName, String state) {
		EmployeeName = employeeName;
		this.state = state;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Override 
	public String toString() {
	    return "Message(" + EmployeeName + ", " + state + ")";
	  }
	
	
}
