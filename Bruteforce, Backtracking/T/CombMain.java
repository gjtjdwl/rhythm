
import java.io.*;
import java.util.*;

public class CombMain {

		static int n=4, r=3, c=0;
		static int[] a= {1,2,3,4}, b = new int[r];//r만큼 채울 배열
		
		static void comb(int cnt, int start) {//cnt = depth = b의 인덱스
			if(cnt == r) {
				System.out.println(Arrays.toString(b));
				c++;
				return;
			}
				for(int i = start ; i < n ; i++) {
					b[cnt] = a[i];
					comb(cnt+1, i+1); // 중복조합 comb(cnt+1,i);
			}
		}
		
		public static void main(String[] args) throws Exception {
			c=0;
			comb(0, 0);
			System.out.println(c);
		}
}
