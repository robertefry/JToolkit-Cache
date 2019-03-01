
package robertefry.jtoolkit.cache;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Robert E Fry
 * @date 1 Mar 2019
 */
public interface Cache< T > extends Iterable< T > {
	
	public void cache( T t );
	
	public void remove( T t );
	
	public int size();
	
	public boolean isEmpty();
	
	public void clear();
	
	public Predicate< T > getCleanCondition();
	
	public void setCleanCondition( Predicate< T > condition );
	
	default void clean() {
		stream().parallel()
			.filter( elem -> getCleanCondition().test( elem ) )
			.collect( Collectors.toSet() )
			.forEach( this::remove );
	}
	
	default Stream< T > stream() {
		return StreamSupport.stream( spliterator(), false );
	}
	
	default Stream< T > parallelStream() {
		return StreamSupport.stream( spliterator(), true );
	}
	
}
