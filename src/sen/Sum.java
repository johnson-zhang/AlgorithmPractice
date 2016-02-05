package sen;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Iterator;

public class Sum {
	private ArrayList<Integer> nlist = new ArrayList<>(10);
	
	public void store(int n){
		nlist.add(n);
	}	
	public boolean test2Sum(int sum){
		ArrayList<Integer> tmp = new ArrayList<>();
		for(int i : nlist){
			if (tmp.contains(i))
				return true;
			else
				tmp.add(sum - i);
		}
		return false;
	}
	public boolean test3Sum(int sum){
		
/*		int[] num = new int[nlist.size()];
		for (int i = 0; i<  nlist.size(); i++){
			num[i] = nlist.get(i);
		}*/
		Object[] num = nlist.toArray();
		Arrays.sort(num);
		for (int i=0; i<num.length;i++){
			int j=i+1,k=num.length - 1;
			while(j<k){
				int temp = (int)num[i] + (int)num[j] + (int)num[k];
				if (temp == sum){
					return true;
				}else if (temp > sum){
					k--;
				}else {
					j++;
				}
				
			}
		}
		return false;
	}
	public void print(){
		Iterator it = nlist.iterator();
		while (it.hasNext()){
			System.out.print(it.next() + ", ");
		}		
	}
	public static void main(String[] args) {
		Sum s = new Sum();
		s.store(4);
		s.store(2);
		s.store(3);
		s.store(1);
		s.print();
		System.out.println();
		//test two sum
		System.out.println("sum 1:" + s.test2Sum(1));
		System.out.println("sum 2:" + s.test2Sum(2));
		System.out.println("sum 5:" + s.test2Sum(5));
		System.out.println("sum 6:" + s.test2Sum(6));
		System.out.println("sum 3:" + s.test2Sum(3));
		//test three sum
		System.out.println("Test 3 sum:");
		System.out.println("sum 1:" + s.test3Sum(1));
		System.out.println("sum 2:" + s.test3Sum(2));
		System.out.println("sum 5:" + s.test3Sum(5));
		System.out.println("sum 6:" + s.test3Sum(6));
		System.out.println("sum 3:" + s.test3Sum(3));
	}

}
