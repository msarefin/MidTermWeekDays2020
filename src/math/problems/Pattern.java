package math.problems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pattern {

	public static void main(String[] args) {
		/* Read this numbers, find the pattern then implement the logic from this pattern.which will give you this output.
		 * 100,99,98,97,96,95,94,93,92,91,90,88,86,84,82,80,78,76,74,72,70,67,64,61,58,55,52,49,46,43,40,36,32............
		 *
		 *
		 */

		System.out.println(Arrays.toString(pattern()));

	}

	public static int [] pattern(){
		List pattern = new ArrayList();
		int n = 100;
		while(n>90){
			pattern.add(n);
			n--;
		}
		while(n<=90 && n>70){
			pattern.add(n);
			n-=2;
		}
		while(n<=70 && n> 40){
			pattern.add(n);
			n-=3;
		}
		while(n<=40 && n>=0){
			pattern.add(n);
			n-=4;
		}
		int [] num = new int[pattern.size()];

		for(int i = 0; i<pattern.size(); i++){
			num[i] = (int)pattern.get(i);
		}
		return num;
	}


}
