package backend_challenge.starter.ExceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class Handler  extends ResponseEntityExceptionHandler{

	@ExceptionHandler(APIexceptions.class)
	public ResponseEntity<ErrorDetails> handleNotFounException(APIexceptions ex , WebRequest request){
		
		ErrorDetails error = new ErrorDetails(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error  , ex.getHttpStatus());
	}
}
