
package robertefry.jtoolkit.cache;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * @author Robert E Fry
 * @date 1 Mar 2019
 */
public class CollectionCache< T > implements Cache< T >, Collection< T > {
	
	private final Collection< T > collection;
	
	public CollectionCache( Collection< T > collection ) {
		this.collection = collection;
	}
	
	@Override
	public void cache( T elem ) {
		collection.add( elem );
	}
	
	@Override
	public void uncache( T elem ) {
		collection.remove( elem );
	}
	
	@Override
	public Iterator< T > iterator() {
		return collection.iterator();
	}
	
	@Override
	public int size() {
		return collection.size();
	}
	
	@Override
	public boolean isEmpty() {
		return collection.isEmpty();
	}
	
	@Override
	public boolean contains( Object o ) {
		return collection.contains( o );
	}
	
	@Override
	public Object[] toArray() {
		return collection.toArray();
	}
	
	@Override
	public < E > E[] toArray( E[] a ) {
		return collection.toArray( a );
	}
	
	@Override
	public boolean add( T e ) {
		return collection.add( e );
	}
	
	@Override
	public boolean remove( Object o ) {
		return collection.remove( o );
	}
	
	@Override
	public boolean containsAll( Collection< ? > c ) {
		return collection.containsAll( c );
	}
	
	@Override
	public boolean addAll( Collection< ? extends T > c ) {
		return collection.addAll( c );
	}
	
	@Override
	public boolean removeAll( Collection< ? > c ) {
		return collection.removeAll( c );
	}
	
	@Override
	public boolean retainAll( Collection< ? > c ) {
		return collection.retainAll( c );
	}
	
	@Override
	public void clear() {
		collection.clear();
	}
	
	@Override
	public Stream< T > stream() {
		return Cache.super.stream();
	}
	
	@Override
	public Stream< T > parallelStream() {
		return Cache.super.parallelStream();
	}
	
}
