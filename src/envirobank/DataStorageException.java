
package envirobank;

/**
 *
 * @author 
 */
public class DataStorageException extends Exception {

    /**
     * Creates a new instance of <code>DataStorageException</code> without
     * detail message.
     */
    public DataStorageException() {
    }

    /**
     * Constructs an instance of <code>DataStorageException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DataStorageException(String msg) {
        super(msg);
    }
}
