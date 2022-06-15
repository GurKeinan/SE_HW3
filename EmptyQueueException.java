/**
 * thrown if the user tries to pick or deque on the queue when it's empty
 */
public class EmptyQueueException extends QueueException
{
    /**
     * Constructs a new EmptyQueueException exception with null as its detail message.
     */
    public EmptyQueueException(){}

    /**
     * Constructs a new EmptyQueueException exception with the specified detail message.
     * @param message- the given message
     */
    public EmptyQueueException(String message) {
        super(message);
    }

    /**
     * Constructs a new EmptyQueueException exception with the specified detail message and cause.
     * @param message- the given message
     * @param cause- the given cause
     */
    public EmptyQueueException(String message, Throwable cause) {
        super(message, cause);
    }

}
