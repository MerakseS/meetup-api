package by.losevsa.meetupapi.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The type Api error needed for responses with exception.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    private String debugMessage;

    /**
     * Instantiates a new Api error.
     */
    public ApiError() {
        timestamp = LocalDateTime.now();
    }

    /**
     * Instantiates a new Api error.
     *
     * @param status the status
     */
    public ApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    /**
     * Instantiates a new Api error.
     *
     * @param status the status
     * @param throwable the throwable
     */
    public ApiError(HttpStatus status, Throwable throwable) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = throwable.getLocalizedMessage();
    }

    /**
     * Instantiates a new Api error.
     *
     * @param status the status
     * @param message the message
     * @param throwable the throwable
     */
    public ApiError(HttpStatus status, String message, Throwable throwable) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = throwable.getLocalizedMessage();
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets debug message.
     *
     * @return the debug message
     */
    public String getDebugMessage() {
        return debugMessage;
    }

    /**
     * Sets debug message.
     *
     * @param debugMessage the debug message
     */
    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }
}
