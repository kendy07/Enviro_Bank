
package envirobank;

/**
 *
 * @author 
 */
public class DuplicateException extends Exception {

    /**
     * Creates a new instance of <code>DuplicateException</code> without detail
     * message.
     */
    public DuplicateException() {
    }

    /**
     * Constructs an instance of <code>DuplicateException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DuplicateException(String msg) {
        super(msg);
    }
}
