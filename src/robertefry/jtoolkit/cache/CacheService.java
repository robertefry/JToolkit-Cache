
package robertefry.jtoolkit.cache;

import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Robert E Fry
 * @date 1 Mar 2019
 */
public class CacheService< T > implements Cache< T > {
	
	private final Thread thread = new Thread( new Run() );
	private volatile boolean running = false;
	
	private final Cache< T > cache;
	private Predicate< T > removal = elem -> false;
	
	public CacheService( Cache< T > cache ) {
		this.cache = cache;
		thread.setDaemon( true );
		thread.start();
	}
	
	private final class Run implements Runnable {
		
		@Override
		public void run() {
			
			while ( running ) {
				
				cache.stream().parallel()
					.filter( removal::test )
					.collect( Collectors.toSet() )
					.forEach( cache::uncache );
				
			}
			
		}
		
	}
	
	public void setRemovalCondition( Predicate< T > removal ) {
		this.removal = removal;
	}
	
	@Override
	public Iterator< T > iterator() {
		return cache.iterator();
	}
	
	@Override
	public void cache( T t ) {
		cache.cache( t );
	}
	
	@Override
	public void uncache( T t ) {
		cache.uncache( t );
	}
	
	@Override
	public int size() {
		return cache.size();
	}
	
	@Override
	public boolean isEmpty() {
		return cache.isEmpty();
	}
	
	@Override
	public void clear() {
		cache.clear();
	}
	
}
