
package robertefry.jtoolkit.cache;

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
	
}
