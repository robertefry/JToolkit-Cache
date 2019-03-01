
package robertefry.jtoolkit.cache;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;

/**
 * @author Robert E Fry
 * @date 1 Mar 2019
 */
public class MapCache< K, V > implements Cache< Map.Entry< K, V > > {
	
	private final Map< K, V > map;
	
	public MapCache( Map< K, V > map ) {
		this.map = map;
	}
	
	public void cache( K key, V value ) {
		map.put( key, value );
	}
	
	@Override
	public void cache( Map.Entry< K, V > entry ) {
		cache( entry.getKey(), entry.getValue() );
	}
	
	@Override
	public void remove( Entry< K, V > entry ) {
		map.remove( entry.getKey() );
	}
	
	public V retireve( K key ) throws CacheElementNotPresentException {
		if ( !map.containsKey( key ) ) throw new CacheElementNotPresentException();
		return map.get( key );
	}
	
	public V retrieve( K key, Supplier< V > supplier ) {
		V value = null;
		if ( map.containsKey( key ) ) {
			value = map.get( key );
		} else {
			value = supplier.get();
			cache( key, value );
		}
		return value;
	}
	
	@Override
	public int size() {
		return map.size();
	}
	
	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}
	
	@Override
	public void clear() {
		map.clear();
	}
	
	@Override
	public Iterator< Entry< K, V > > iterator() {
		return map.entrySet().iterator();
	}
	
}
