package sen;

import java.util.ArrayList;

public class BitManipulation {
	//get the num of different bits between two integer
	public static int diffBits(int a, int b){
		int c = a ^ b;
		int num = 0;
		for (int i=0; i<32;i++){
			int test = 1 << i;
			if ((test & c) == test) num++;
		}
		return num;
	}

	public static int findSingle(int[] nums){
		int xor = 0;
		for (int num : nums){
			xor = xor ^ num;
		}
		return xor;
	}
	//give a bit length, return a num sequence that meet two successive values diff only one bit, must start with 0
	public static ArrayList<Integer> GrayColor(int n){
		ArrayList<Integer> result = new ArrayList<>();
		result.add(0);
		for (int i = 0; i < n; i++){
			int a = 1 << i;
			for (int j = result.size() - 1; j >= 0; j--){
				result.add(result.get(j) | a);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		//System.out.println(diffBits(15,8));
		//System.out.println(diffBits(-1,8));
		/*System.out.println(findSingle(new int[]{1,2,1,56,2,14,14}));
		System.out.println(findSingle(new int[]{1,2,1,2,14,14}));
		System.out.println(findSingle(new int[]{-1,2,-1,2,14,14,-33}));
		System.out.println(findSingle(new int[]{35}));*/
		System.out.println(GrayColor(2).toString());
		System.out.println(GrayColor(3).toString());
	}

}
