package customQueues;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * This class breaks the Liskov substitution principle, however that is okay,
 * since it is only used in a small project for a very specific purpose.
 * Most operations declared by the interface are not used in my implementation,
 * and implementing them is unnecessary effort. 
 */
public class CustomPriorityBlockingQueue implements BlockingQueue<Integer>{

	// Attributes________________________________________________________________
	protected Queue<Integer> queuedNumbers;
	private final int capacity;
	
	private int minCapacityBeforeRemoving;
	
	public CustomPriorityBlockingQueue (int expectedNumberCount) {
		this.minCapacityBeforeRemoving = expectedNumberCount;
		this.capacity = Integer.MAX_VALUE;
		this.queuedNumbers = new LinkedList<Integer>();
	}
	
	// Ctors_____________________________________________________________________
	public CustomPriorityBlockingQueue () {
		this(1);
	}
	
	@Override
	public Integer element(){
		return queuedNumbers.element();
	}

	// Methods___________________________________________________________________
	public synchronized void setMinCapacityBeforeRemoving(int newMinCapacity) {
		this.minCapacityBeforeRemoving = newMinCapacity;
	}
	
	@Override
	public synchronized Integer peek() {
		return queuedNumbers.peek();
	}

	@Override
	public synchronized int size() {
		return queuedNumbers.size();
	}

	@Override
	public synchronized boolean isEmpty() {
		return queuedNumbers.isEmpty();
	}

	@Override
	public synchronized Iterator iterator() {
		return queuedNumbers.iterator();
	}

	// Removing Elements____________________________________________________________
	@Override
	public synchronized Integer remove(){
		return queuedNumbers.remove();
	}

	@Override
	public synchronized Integer poll() {
		return queuedNumbers.poll();
	}

	@Override
    public synchronized Integer take () throws InterruptedException {
        while (queuedNumbers.size() < minCapacityBeforeRemoving) {
            wait(); 
        }
        Integer item = queuedNumbers.poll();
        notifyAll();
        return item;
    }

	// Adding Elements_______________________________________________________________
	@Override
	public synchronized boolean add(Integer newNumber) {
		return this.queuedNumbers.add(newNumber);
	}


	@Override
	public synchronized boolean offer(Integer newNumber) {
		return queuedNumbers.offer(newNumber);
	}

	@Override
    public synchronized void put (Integer newElement) throws InterruptedException {
        while (queuedNumbers.size() >= capacity) {
            wait(); 
        }
        queuedNumbers.add(newElement);
        // Only notify if the minimum is reached!
        if (this.size()>= this.minCapacityBeforeRemoving)
        	notifyAll();
    }

	// Unsupported operations, not needed for my CustomBlockingQueue__________________
	
	@Override
	public Integer[] toArray() {
		throw new UnsupportedOperationException("toArray() is not supported for class CustomBlockingQueue");
	}

	@Override
	public Integer[] toArray(Object[] a) {
		throw new UnsupportedOperationException("toArray() is not supported for class CustomBlockingQueue");
	}

	@Override
	public boolean containsAll(Collection c) {
		throw new UnsupportedOperationException("containsAll() is not supported for class CustomBlockingQueue");
	}

	@Override
	public boolean addAll(Collection c) {
		throw new UnsupportedOperationException("addAll() is not supported for class CustomBlockingQueue");
	}

	@Override
	public boolean removeAll(Collection c) {
		throw new UnsupportedOperationException("removeAll() is not supported for class CustomBlockingQueue");
	}

	@Override
	public boolean retainAll(Collection c) {
		throw new UnsupportedOperationException("retainAll() is not supported for class CustomBlockingQueue");
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("clear() is not supported for class CustomBlockingQueue");
	}

	@Override
	public boolean offer(Integer e, long timeout, TimeUnit unit) throws InterruptedException {
		throw new UnsupportedOperationException(
				"this version of offer() is not supported for class CustomBlockingQueue. Please use regular offer() with no parameters!"
				);
	}


	@Override
	public Integer poll(long timeout, TimeUnit unit) throws InterruptedException {
		throw new UnsupportedOperationException(
				"this version of poll() is not supported for class CustomBlockingQueue. Please use regular poll() with no parameters!"
				);
	}

	@Override
	public int remainingCapacity() {
		throw new UnsupportedOperationException("remainingCapacity() is not supported for class CustomBlockingQueue");
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException("remove(Object o) is not supported for class CustomBlockingQueue");
	}

	@Override
	public boolean contains(Object o) {
		throw new UnsupportedOperationException("contains(Object o) is not supported for class CustomBlockingQueue");
	}

	@Override
	public int drainTo(Collection c) {
		throw new UnsupportedOperationException("drainTo() is not supported for class CustomBlockingQueue");
	}

	@Override
	public int drainTo(Collection c, int maxElements) {
		throw new UnsupportedOperationException("drainTo() is not supported for class CustomBlockingQueue");
	}
	
}
