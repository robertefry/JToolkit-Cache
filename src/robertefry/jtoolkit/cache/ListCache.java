
package robertefry.jtoolkit.cache;

import java.util.List;

/**
 * @author Robert E Fry
 * @date 1 Mar 2019
 */
public class ListCache< T > extends CollectionCache< T > {
	
	public ListCache( List< T > list ) {
		super( list );
	}
	
}
