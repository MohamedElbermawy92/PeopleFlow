package backend_challenge.starter.ExceptionHandler;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDetails {

	private String message;
	private String uri;
	
	
	public ErrorDetails() {
		this.timeStamp = new Date();
	}
	
	public ErrorDetails(String message, String uri) {
		this();
		this.message = message;
		this.uri = uri;
	}
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyy" )
	private Date timeStamp;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}

