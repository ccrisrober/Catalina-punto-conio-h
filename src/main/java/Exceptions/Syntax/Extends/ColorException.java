package Exceptions.Syntax.Extends;

import Exceptions.Syntax.SyntaxException;

/**
 *
 * @author Cristian
 */
public class ColorException extends SyntaxException {

    /**
     *
     * @param error
     */
    public ColorException(final String error) {
        super(error);
    }

}
