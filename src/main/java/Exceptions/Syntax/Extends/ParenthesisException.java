package Exceptions.Syntax.Extends;

/**
 *
 * @author Cristian
 */
import Exceptions.Syntax.SyntaxException;

public class ParenthesisException extends SyntaxException {

    /**
     *
     * @param string
     */
    public ParenthesisException(final String string) {
        super(string);
    }

}
