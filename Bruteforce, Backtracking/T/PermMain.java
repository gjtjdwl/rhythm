// 순열 Permutation (순서o) - 처음부터 끝까지 loop + 메모이제이션을 통해 방문처리한 노드는 스킵 
package a0721.bigo;


import java.io.*;
import java.util.*;

public class PermMain { //4P3
	static int n=4, r=3, c=0;
	static int[] a= {1,2,3,4}, b = new int[r];//r만큼 채울 배열
	static boolean[] visited = new boolean[n];//중복순열 : visited 체크 하지 않기
	
	static void perm(int cnt) {//cnt = depth = b의 인덱스
		if(cnt == r) {
			System.out.println(Arrays.toString(b));
			c++;
			return;
		}
			for(int i = 0 ; i < n ; i++) {
				if(visited[i]) continue;
				visited[i] = true;
				b[cnt] = a[i];
				perm(cnt+1);
				visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		c=0;
		perm(0);
		System.out.println(c);

	}

}
