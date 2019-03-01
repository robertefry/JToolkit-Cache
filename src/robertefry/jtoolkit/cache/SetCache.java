
package robertefry.jtoolkit.cache;

import java.util.Set;

/**
 * @author Robert E Fry
 * @date 1 Mar 2019
 */
public class SetCache< T > extends CollectionCache< T > {
	
	public SetCache( Set< T > set ) {
		super( set );
	}
	
}
