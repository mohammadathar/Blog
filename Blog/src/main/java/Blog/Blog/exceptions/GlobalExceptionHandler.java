package Blog.Blog.exceptions;

import Blog.Blog.entity.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDetail> handleCustomException(CustomException ex) {
        return new ResponseEntity<>(ex.getErrorDetail(), ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handleGenericException(Exception ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                ex.getMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI()
        );
        return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
