
import java.util.List;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class LargestTracker {
	//custom comparator class to let PriorityQueue order by desc, that means first element is greatest and last element is smallest
	private static class MyComparator implements Comparator<Integer> {
		public int compare(Integer int1, Integer int2) {
			return (int2 - int1);
		}
	}
	
	private static LargestTracker sInstance;
	private PriorityQueue<Integer> mQueue;//order by desc 
	private MyComparator mComparator = new MyComparator();
	/**
	 * Guarantees the creation of a single instance across the virtual machine.
	 * Assumed to be called very frequently.
	 * 
	 * @return an instance of LargestTracker
	 */
	public static LargestTracker getInstance(){
		if (sInstance == null){
			synchronized(LargestTracker.class){
				//double checking Singleton instance
				if (sInstance == null)
					sInstance = new LargestTracker();
			}
		}
		return sInstance;
	}

	/**
	 * Returns a list in O(n log m) time OR BETTER where n is the number of entries 
	 * added to LargestTracker and m is numberOfTopLargestElements. Duplicates are allowed
	 * 
	 * @param numberOfTopLargestElements
	 *            the number of top-most-elements to return
	 * @return the top-most-elements in the tracker sorted in ascending order
	 */
	public List<Integer> getNLargest(int numberOfTopLargestElements){
		if (numberOfTopLargestElements <= 0) return null;
		Integer[] topArray;
		
		synchronized(this){
			if (mQueue == null || numberOfTopLargestElements > mQueue.size()) return null; 
			topArray = new Integer[numberOfTopLargestElements];
			for (int i = numberOfTopLargestElements - 1; i >= 0; --i){
				topArray[i] = mQueue.peek();
				mQueue.poll();
			}
			for (Integer e: topArray){
				mQueue.add(e);
			}
		}
		
		return Arrays.asList(topArray);
	}

	/**
	 * Adds an entry to the tracker. This method must operate in O(log n) time
	 * OR BETTER
	 * @param anEntry
	 *            the entry to add to the tracker. Entries need not be unique.
	 */
	public void add(int anEntry){
		synchronized(this){
			if (mQueue == null){			
				mQueue = new PriorityQueue<Integer>(10, mComparator);
			}
			mQueue.add(anEntry);
		}
	}

	/**
	 * Removes all the entries from the tracker. This should return in constant
	 * time.
	 */
	public void clear(){
		synchronized(this){
			mQueue = null;
		}
	}
	
	public static void main(String[] args) {
		LargestTracker t = LargestTracker.getInstance();
		t.add(1);
		t.add(10);
		t.add(3);
		t.add(4);
		t.add(7);
		t.add(9);
		t.add(11);
		t.add(15);
		t.add(22);
		t.add(22);
		t.add(25);
		t.add(30);
		t.add(31);
		t.add(-1);
		List<Integer> l= t.getNLargest(8);
		for (Integer i: l){
			System.out.println(i);
		}
		t.add(100);
		l= t.getNLargest(15);
		for (Integer i: l){
			System.out.println(i);
		}
	
	}
}

