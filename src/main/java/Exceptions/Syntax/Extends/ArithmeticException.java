package Exceptions.Syntax.Extends;

import Exceptions.Syntax.SyntaxException;

/**
 *
 * @author Cristian
 */
public class ArithmeticException extends SyntaxException {

    /**
     *
     * @param error
     */
    public ArithmeticException(final String error) {
        super(error);
    }

}
