/**
 * thrown when the user tries to give negative capacity as an argument to the queue constructor
 */
public class NegativeCapacityException extends QueueException
{
    /**
     * Constructs a new NegativeCapacityException exception with null as its detail message.
     */
    public NegativeCapacityException(){}

    /**
     * Constructs a new NegativeCapacityException exception with the specified detail message.
     * @param message- the given message
     */
    public NegativeCapacityException(String message) {
        super(message);
    }

    /**
     * Constructs a new NegativeCapacityException exception with the specified detail message and cause.
     * @param message- the given message
     * @param cause- the given cause
     */
    public NegativeCapacityException(String message, Throwable cause) {
        super(message, cause);
    }
}
