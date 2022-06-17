
/**
 * thrown if the user tries to add more items than the maximal amount
 */
public class QueueOverflowException extends QueueException
{

    /**
     * Constructs a new QueueOverflowException exception with null as its detail message.
     */
    public QueueOverflowException(){}

    /**
     * Constructs a new QueueOverflowException exception with the specified detail message.
     * @param message- the given message
     */
    public QueueOverflowException(String message) {
        super(message);
    }

    /**
     * Constructs a new QueueOverflowException exception with the specified detail message and cause.
     * @param message- the given message
     * @param cause- the given cause
     */
    public QueueOverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
