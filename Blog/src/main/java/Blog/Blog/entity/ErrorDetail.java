package Blog.Blog.entity;

import java.time.LocalDateTime;

public class ErrorDetail {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ErrorDetail(LocalDateTime timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Getters only (or setters too if needed)
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public int getStatus() { return status; }
    public String getError() { return error; }
    public String getMessage() { return message; }
    public String getPath() { return path; }
}
