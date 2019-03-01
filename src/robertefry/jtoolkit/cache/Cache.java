
package robertefry.jtoolkit.cache;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Robert E Fry
 * @date 1 Mar 2019
 */
public interface Cache< T > extends Iterable< T > {
	
	public void cache( T t );
	
	public void uncache( T t );
	
	public int size();
	
	public boolean isEmpty();
	
	public void clear();
	
	default Stream< T > stream() {
		return StreamSupport.stream( spliterator(), false );
	}
	
	default Stream< T > parallelStream() {
		return StreamSupport.stream( spliterator(), true );
	}
	
}
