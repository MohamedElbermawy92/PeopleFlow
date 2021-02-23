package backend_challenge.starter.ExceptionHandler;

import org.springframework.http.HttpStatus;

public class NotFoundException extends APIexceptions {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String message) {
		super(message);
	}

	protected HttpStatus getHttpStatus() {

		return HttpStatus.NOT_FOUND;
	}
}
