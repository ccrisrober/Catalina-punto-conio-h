package Exceptions.Syntax.Extends;

import Exceptions.Syntax.SyntaxException;

/**
 *
 * @author Cristian
 */
public class HomeError extends SyntaxException {

    /**
     *
     * @param string
     */
    public HomeError(final String string) {
        super(string);
    }

}
