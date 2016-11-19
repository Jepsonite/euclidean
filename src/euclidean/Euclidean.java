package euclidean;

import java.util.ArrayList;

public class Euclidean {
	private int first;
	private int second;
	private int gcd;
	private ArrayList<Integer> coefficient = new ArrayList<Integer>();
	
//	public Euclidean() {
//		
//	}
	
	public Euclidean(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	public static void main(String[] args) {
		//take input, validate it somewhere
		//calculate the gcd in some method
		//store the things needed
		//return stuff
	}
	
	public int getGCD() {
		if (gcd != 0) {
			return gcd;
		}
		gcd();
		return gcd;
	}
	
	private void gcd() {
		int reminder = max(first,second) % min(first, second);
		int larger = max(first,second);
		int smaller = min(first, second);
		while (reminder > 0) {
			coefficient.add(larger);
			coefficient.add(larger/smaller);
			coefficient.add(smaller);
			coefficient.add(reminder);
			larger = smaller;
			smaller = reminder;
			reminder = larger % smaller;
			if (reminder == 0) {
				gcd = smaller;
				coefficient.add(larger);
				coefficient.add(larger/smaller);
				coefficient.add(smaller);
				coefficient.add(reminder);
			}
		}
		// 126 = 1*82 + 44
		// 82 = 1*44 + 38
		// 44 = 1*38 + 6
		// 38 = 6*6 + 2
		// 6 = 3*2 + 0
	}
	
	private int max(int a, int b) {
		if (a > b) {
			return a;
		}
		return b;
	}
	
	private int min(int a, int b) {
		return -max(-a,-b);
	}
	
	public void showEuclidianAlgorithm() {
//		System.out.println(max(first,second) + " = " + max(first,second)/min(first,second) 
//				+ "*" + min(first,second) + " + " + max(first,second)%min(first,second));
		for (int i = 0 ; i < coefficient.size() ; i += 4) {
			System.out.println(coefficient.get(i) + " = " + coefficient.get(i+1) 
			+ "*" + coefficient.get(i+2) + " + " + coefficient.get(i+3));
		}
	}
	
	public void GCDAsLinearCombination() {
		// 2 = 38 - 6*6 = 38 - 6*(44 - 1*38) = 7*38 - 6*44 = 7*(82 - 1*44) - 6*44 = 7*82 - 13*44
		//   = 7*82 - 13*(126 - 1*82) = -13*126 + 20*82 = 2
		// 2 = 38 - 6*6 = 38 - 6*(44 - 1*38) = 82 - 1*44 - 6*(44 - 1*(82 - 1*44)) 
		//	 = 82 - 1*(126 - 1*82) - 6*((126 - 1*82) - 1*(82 - 1*(126 - 1*82)))
		// might be a bit more complex to implement than i thought
		// a_1 = k_1 * b_1 + r_1, a_2 = b_1, b_2 = r_1
		// a_2 = k_2 * b_2 + r_2 => b_1 = k_2 * r_1 + r_2, a_3 = b_2, b_3 = r_2 
		// a_3 = k_3 * b_3 + r_3 => b_2 = k_3 * r_2 + r_3 => r_1 = k_3 * r_2 + r_3, a_4 = b_3, b_4 = r_3
		// a_4 = k_4 * b_4 + r_4 => b_3 = k_4 * r_3 + r_4 => r_2 = k_4 * r_3 + r_4
		// => r_{n-1} = k_{n+1} * r_n + r_{n+1} => r_{n+1} = r_{n-1} - k_{n+1} * r_n
	}
}
