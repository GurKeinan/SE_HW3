/**
 * thrown if the user tries to add net task with description which matches one of the old tasks' description
 */
public class TaskAlreadyExistsException extends RuntimeException
{

        /**
         * Constructs a new TaskAlreadyExistsException exception with null as its detail message.
         */
        public TaskAlreadyExistsException(){}

        /**
         * Constructs a new TaskAlreadyExistsException exception with the specified detail message.
         * @param message- the given message
         */
        public TaskAlreadyExistsException(String message) {
            super(message);
        }

        /**
         * Constructs a new TaskAlreadyExistsException exception with the specified detail message and cause.
         * @param message- the given message
         * @param cause- the given cause
         */
        public TaskAlreadyExistsException(String message, Throwable cause) {
            super(message, cause);
        }

}
