package Blog.Blog.exceptions;


import Blog.Blog.entity.ErrorDetail;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class CustomException extends RuntimeException {
    private final ErrorDetail errorDetail;
    private final HttpStatus status;

    public CustomException(HttpStatus status, String message, String path) {
        super(message);
        this.status = status;
        this.errorDetail = new ErrorDetail(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                path
        );
    }


    public ErrorDetail getErrorDetail() {
        return errorDetail;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
