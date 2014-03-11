package Exceptions.Syntax;

/**
 *
 * @author Cristian
 */
public class SyntaxException extends RuntimeException {

    /**
     *
     * @param string
     */
    public SyntaxException(final String string) {
        super(string);
    }

}
