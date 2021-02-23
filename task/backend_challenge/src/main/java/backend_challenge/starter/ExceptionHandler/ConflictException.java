package backend_challenge.starter.ExceptionHandler;

import org.springframework.http.HttpStatus;

public class ConflictException extends APIexceptions{

	
	private static final long serialVersionUID = 1L;

	public ConflictException(String message) {
		super(message);
	}

	protected HttpStatus getHttpStatus() {

		return HttpStatus.CONFLICT;
	}
}
