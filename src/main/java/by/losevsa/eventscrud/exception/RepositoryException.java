package by.losevsa.eventscrud.exception;

/**
 * Thrown when something goes wrong on repository layer.
 */
public class RepositoryException extends RuntimeException {

    /**
     * Instantiates a new Repository exception.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A {@code null} value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     */
    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
