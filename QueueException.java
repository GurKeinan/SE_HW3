public class QueueException extends RuntimeException
{

    /**
     * Constructs a new QueueException exception with null as its detail message.
     */
    public QueueException(){}

    /**
     * Constructs a new QueueException exception with the specified detail message.
     * @param message- the given message
     */
    public QueueException(String message) {
        super(message);
    }

    /**
     * Constructs a new QueueException exception with the specified detail message and cause.
     * @param message- the given message
     * @param cause- the given cause
     */
    public QueueException(String message, Throwable cause) {
        super(message, cause);
    }
}

