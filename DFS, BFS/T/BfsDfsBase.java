
import java.io.*;
import java.util.*;
import java.time.*;

public class BfsDfsBase {
	static final int[] di= {-1, 0, 1, 0}; //상우하좌
	static final int[] dj= {0, 1, 0, -1}; //상하좌우 di -1 1 0 0 & dj 0 0 -1 1
	static int n = 5, c;
	static int[][] a;
	static boolean[][] visited; //java boolean은 1byte라서 메모리 이득
	
	static void bfs(int i, int j) { //최단거리, 최소값 등의 문제, 동시에 일어나는 경우
		ArrayDeque<int[]> q = new ArrayDeque<>(); //stack 은 .push를 사용
		visited[i][j] = true;
		q.offer(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0]; j = ij[1];
			a[i][j] = c++;
			
			for(int[] b:a) System.out.println(Arrays.toString(b));
			System.out.println();
			for(int d=0;d<4;d++) {
				int ni=i+di[d];
				int nj=j+dj[d];
				if(ni>=0 && ni<n && nj>=0 && nj<n && !visited[ni][nj]) { // 범위 설정(경계인지 확인)
					visited[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}
	// return 값 가지는 bfs
	static int bfs2(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.offer(new int[] {i,j});
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0;s < size;s++) {
				int[] ij = q.poll();
				i = ij[0]; 
				j = ij[1];
				//if 정답 return cnt;
				a[i][j] = c++;
				
				for(int[] b:a) System.out.println(Arrays.toString(b));
				System.out.println();
				for(int d=0;d<4;d++) {
					int ni=i+di[d];
					int nj=j+dj[d];
					if(ni>=0 && ni<n && nj>=0 && nj<n && !visited[ni][nj]) { // 범위 설정(경계인지 확인)
						visited[ni][nj] = true;
						q.offer(new int[] {ni,nj});
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
	static void dfs(int i, int j) { // 최댓값 등의 문제
		visited[i][j] = true;
		a[i][j] = c++;
		for(int[] b:a) System.out.println(Arrays.toString(b));
		System.out.println();
		for(int d=0;d<4;d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(ni>=0 && ni<n && nj>=0 && nj<n && !visited[ni][nj]) { // 범위 설정(경계인지 확인)
				dfs(ni,nj);
			}
		}
		System.out.println(a[i][j]);
	}
	// return 하는 dfs
	static int dfs2(int i, int j) {// 가지 치는 조건 parameter로
		// if 조건 return
		int cnt = 1;
		visited[i][j] = true;
		a[i][j] = c++;
		for(int[] b:a) System.out.println(Arrays.toString(b));
		System.out.println();
		for(int d=0;d<4;d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(ni>=0 && ni<n && nj>=0 && nj<n && !visited[ni][nj]) { 
				cnt += dfs2(ni,nj);
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception{
		Instant start =Instant.now();
		a = new int[n][n];
		visited = new boolean[n][n];
		c = 1;
		// 기본
		//dfs(n/2, n/2);
		//bfs(n/2, n/2);
		
		// 깊이
		//bfs1(n/2, n/2);
		//bfs1(n/2, n/2, 0);
		//dfs1(n/2, n/2);
		
		// 리턴
		//System.out.println(bfs2(n/2, n/2));
		System.out.println(dfs2(n/2, n/2));
		
		Instant end = Instant.now();
		Duration elapsed = Duration.between(start, end);
		System.out.println(elapsed.toMillis() + " MS");
		System.out.println(elapsed.toNanos() + " NS");//완탐은 dfs가 더 빠르다 -> 쉬운문제 = dfs 

		//for(int[] b: a) System.out.println(Arrays.toString(b));
	}
}
