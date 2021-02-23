package backend_challenge.starter.ExceptionHandler;

import org.springframework.http.HttpStatus;

public abstract class APIexceptions extends RuntimeException {

private static final long serialVersionUID = 1L;
	

	public APIexceptions(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	protected abstract HttpStatus getHttpStatus();
}
