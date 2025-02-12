package customQueues;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Custom PriorityBlockingQueue implementation that will skip insertion of duplicate elements
 */
public class NoDuplicateNumbersPriorityBlockingQueue extends CustomPriorityBlockingQueue{

	 private final Set<Integer> insertedNumbersSet = new HashSet<>();

	    @Override
	    public synchronized boolean add(Integer newNumber) {
	        if (!insertedNumbersSet.contains(newNumber)) {
	            boolean added = super.add(newNumber);
	            if (added) {
	                insertedNumbersSet.add(newNumber);
	            }
	            return added;
	        }
	        return false; 
	    }

	    @Override
	    public synchronized boolean offer(Integer newNumber) {
	    	if (!insertedNumbersSet.contains(newNumber)) {
	            boolean offered = super.offer(newNumber);
	            if (offered) {
	                insertedNumbersSet.add(newNumber);
	            }
	            return offered;
	        }
	        return false; 
	    }

	    @Override
	    public synchronized void put(Integer newNumber) {
	        if (!insertedNumbersSet.contains(newNumber)) {
	            try {
					super.put(newNumber);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	            insertedNumbersSet.add(newNumber);
	        }
	    }

	    @Override
	    public synchronized Integer poll() {
	        Integer removed = super.poll();
	        if (removed != null) {
	            insertedNumbersSet.remove(removed);
	        }
	        return removed;
	    }

	    @Override
	    public synchronized Integer take() throws InterruptedException {
	        Integer removed = super.take();
	        insertedNumbersSet.remove(removed);
	        return removed;
	    }

	    @Override
	    public synchronized boolean remove(Object o) {
	        boolean removed = super.remove(o);
	        if (removed) {
	            insertedNumbersSet.remove(o);
	        }
	        return removed;
	    }
}
