package Exceptions.Syntax.Extends;

/**
 *
 * @author Cristian
 */
import Exceptions.Syntax.SyntaxException;

public class OperatorException extends SyntaxException {

    /**
     *
     * @param string
     */
    public OperatorException(final String string) {
        super(string);
    }

}
