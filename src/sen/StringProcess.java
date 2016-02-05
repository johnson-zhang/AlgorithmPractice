package sen;
import java.util.Arrays;
import java.util.ArrayList;

public class StringProcess {

	//find if two strings are anagram
	public static boolean isAnagram(String s1, String s2){
		if (s1 == null || s2 == null) return false;
		System.out.println(s1);
		System.out.println(s2);
		if (s1.length() != s2.length()) return false;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		return Arrays.equals(c1,c2);
	}
	//another fast method
	public static boolean isAnagram2(String s1, String s2){
		if (s1 == null || s2 == null) return false;
		System.out.println(s1);
		System.out.println(s2);
		if (s1.length() != s2.length()) return false;
		int[] charMap = new int[256];
		for (int i = 0; i < s1.length(); i++){
			charMap[s1.charAt(i)]++;
			charMap[s2.charAt(i)]--;
		}
		for(int i = 0; i < charMap.length;i++){
			if (charMap[i] !=0) return false;
		}
		return true;
	}
	
	//return the length of Longest Substring Without Repeating Characters
	public static int lengthOfLongestSubstring(String s){
		if (s == null || s.length() == 0) return 0;
		System.out.println(s);
		int max = 0;
		int[] charMap = new int['~' - ' ' + 1];
		int proLocation = 1, aftLocation = 1;
		for (int i = 0; i < s.length(); i++){
			int charIndex = s.charAt(i) - ' ';
			if (charMap[charIndex] >= proLocation){
				max = Math.max(max, aftLocation - proLocation + 1);
				proLocation = charMap[charIndex] + 1;
			}
			charMap[charIndex] = i + 1;
			aftLocation = charMap[charIndex];
		}
		return Math.max(max, aftLocation - proLocation + 1);
		
	}
	
	public static void main(String[] args) {

		/*System.out.println(isAnagram2("abddab","dbadba"));
		System.out.println(isAnagram2("abc","dba"));
		System.out.println(isAnagram2("ab","dba"));*/
		//System.out.println("abcde".substring(1,3));
		System.out.println(lengthOfLongestSubstring("abcdefgad"));
		System.out.println(lengthOfLongestSubstring("abcdbwfga"));
		System.out.println(lengthOfLongestSubstring("a"));
		ArrayList<int[]> test = new ArrayList<>();
		test.add(new int[]{1,2,3});
		test.add(new int[]{4,5,6});
		System.out.println(test.get(0)[0]);
		
	}

}
