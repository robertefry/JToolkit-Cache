
package robertefry.jtoolkit.cache;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/**
 * @author Robert E Fry
 * @date 1 Mar 2019
 */
public class MapCache< K, V > implements Cache< Map.Entry< K, V > >, Map< K, V > {
	
	private final Map< K, V > map;
	
	public MapCache( Map< K, V > map ) {
		this.map = map;
	}
	
	@Override
	public void cache( Map.Entry< K, V > entry ) {
		map.put( entry.getKey(), entry.getValue() );
	}
	
	public void uncache( Map.Entry< K, V > entry ) {
		map.remove( entry.getKey(), entry.getValue() );
	}
	
	public void cache( K key, V value ) {
		map.put( key, value );
	}
	
	public V retrieve( K key ) throws CacheElementNotPresentException {
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
	public Iterator< Entry< K, V > > iterator() {
		return map.entrySet().iterator();
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
	public boolean containsKey( Object key ) {
		return map.containsKey( key );
	}
	
	@Override
	public boolean containsValue( Object value ) {
		return map.containsValue( value );
	}
	
	@Override
	public V get( Object key ) {
		return map.get( key );
	}
	
	@Override
	public V put( K key, V value ) {
		return map.put( key, value );
	}
	
	@Override
	public V remove( Object key ) {
		return map.remove( key );
	}
	
	@Override
	public void putAll( Map< ? extends K, ? extends V > m ) {
		map.putAll( m );
	}
	
	@Override
	public void clear() {
		map.clear();
	}
	
	@Override
	public Set< K > keySet() {
		return map.keySet();
	}
	
	@Override
	public Collection< V > values() {
		return map.values();
	}
	
	@Override
	public Set< Entry< K, V > > entrySet() {
		return map.entrySet();
	}
	
}
