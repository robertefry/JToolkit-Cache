
package robertefry.jtoolkit.cache;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * @author Robert E Fry
 * @date 1 Mar 2019
 */
public class CollectionCache< T > implements Cache< T > {
	
	private final Collection< T > collection;
	private Predicate< T > condition = ( entry ) -> false;
	
	public CollectionCache( Collection< T > collection ) {
		this.collection = collection;
	}
	
	@Override
	public void cache( T t ) {
		collection.add( t );
	}
	
	@Override
	public void remove( T t ) {
		collection.remove( t );
	}
	
	@Override
	public Predicate< T > getCleanCondition() {
		return condition;
	}
	
	@Override
	public void setCleanCondition( Predicate< T > condition ) {
		this.condition = condition;
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
	public void clear() {
		collection.clear();
	}
	
	@Override
	public Iterator< T > iterator() {
		return collection.iterator();
	}
	
}
