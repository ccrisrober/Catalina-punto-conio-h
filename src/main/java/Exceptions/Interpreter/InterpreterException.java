package Exceptions.Interpreter;

/**
 *
 * @author Cristian
 */
public class InterpreterException extends RuntimeException {

    /**
     *
     * @param error
     */
    public InterpreterException(final String error) {
        super(error);
    }

}
