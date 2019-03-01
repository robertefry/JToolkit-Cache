
package robertefry.jtoolkit.cache;

/**
 * @author Robert E Fry
 * @date 1 Mar 2019
 */
public class CacheElementNotPresentException extends RuntimeException {
	private static final long serialVersionUID = -143711217249396781L;
	
	public CacheElementNotPresentException() {
		super();
	}
	
	public CacheElementNotPresentException( String message ) {
		super( message );
	}
	
	public CacheElementNotPresentException( String message, Throwable cause ) {
		super( message, cause );
	}
	
	public CacheElementNotPresentException( Throwable cause ) {
		super( cause );
	}
	
}
