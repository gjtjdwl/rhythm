import java.io.*;
import java.util.*;

// 부분집합의 개수 2^n개
public class SubsMain {

		static int n=4, c=0;
		static int[] a= {1,2,3,4};
		//static boolean[] v = new boolean[n];
		
		static void subs(int cnt, String str) {
			if(cnt == n) {
				System.out.println(str);
				c++;
				return;
			}
			//v[cnt] = false;
			subs(cnt+1, str+"."); // 비선택
			//v[cnt] = true;
			subs(cnt+1, str+a[cnt]); // 선택
				
		}
		
		public static void main(String[] args) throws Exception {
			c=0;
			subs(0,"");
			System.out.println(c);
		}
}
