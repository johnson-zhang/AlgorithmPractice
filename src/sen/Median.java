package sen;

import java.util.PriorityQueue;

public class Median {
	
	public static int findMedian(int[] num){
		PriorityQueue<Long> large = new PriorityQueue<>();//store large part
		PriorityQueue<Long> small = new PriorityQueue<>();//store small part
		for (int i: num){
			large.add((long)i);
			small.add(-large.poll());
			if (large.size() < small.size()) {
				large.add(-small.poll());
			}
		}
		return (int)(large.size() > small.size()?large.peek():(large.peek() - small.peek())/2);
		
	}

	public static void main(String[] args) {
		int[] num = {1, -1, -3,25,10,100,3,45,15};
		for (int i: num){
			System.out.println(i+",");
		}
		System.out.println();
		System.out.println("The median num is " + findMedian(num));
	}

}
