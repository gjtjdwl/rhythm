import java.io.*;
import java.util.*;

// 부분집합으로 조합 구현
public class SubsMainComb {

		static int n=4, c=0;
		static int[] a= {1,2,3,4};
		//static boolean[] v = new boolean[n];
		
		static void subs(int cnt, String str, int r) {
			if(r == 3) { // 3개가 선택된 경우에만 작업
				System.out.println(str);
				c++;
				return;				
			}
			if(cnt == n) return;

			//v[cnt] = false;
			subs(cnt+1, str+"", r); // 비선택
			//v[cnt] = true;
			subs(cnt+1, str+a[cnt], r + 1); // 선택
				
		}
		
		public static void main(String[] args) throws Exception {
			c=0;
			subs(0,"",0);
			System.out.println(c);
		}
}
