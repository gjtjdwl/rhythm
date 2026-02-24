
import java.io.*;
import java.util.*;

public class BfsDfsDepth {
	static final int[] di= {-1, 0, 1, 0}; //상우하좌
	static final int[] dj= {0, 1, 0, -1}; //상하좌우 di -1 1 0 0 & dj 0 0 -1 1
	static int n = 5, c;
	static int[][] a;
	static boolean[][] visited; //java boolean은 1byte라서 메모리 이득
	
	// 깊이 depth 확인 - 사이즈 주기 = 나로부터 몇칸 떨어져 있는가?
	static void bfs1(int i, int j) { //최단거리 -> 한칸의 가중치가 1인 경우
		int depth = 0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.offer(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0;s < size;s++) {
				int[] ij = q.poll();
				i = ij[0]; 
				j = ij[1];
				a[i][j] = c++;
				System.out.println(depth);
				
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
			depth++;
		}
	}
	// 깊이 depth 확인 - parameter = backtracking(가지치기) 가능 -> 이걸 더 추천!
	static void bfs1(int i, int j, int depth) {/* int sum, int cnt - if (cnt(sum)> m) break; */
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.offer(new int[] {i,j,depth});
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0;s < size;s++) {
				int[] ij = q.poll();
				i = ij[0]; 
				j = ij[1];
				depth = ij[2];
				a[i][j] = c++;
				System.out.println(depth);
				
				for(int[] b:a) System.out.println(Arrays.toString(b));
				System.out.println();
				for(int d=0;d<4;d++) {
					int ni=i+di[d];
					int nj=j+dj[d];
					if(ni>=0 && ni<n && nj>=0 && nj<n && !visited[ni][nj]) { // 범위 설정(경계인지 확인)
						visited[ni][nj] = true;
						q.offer(new int[] {ni, nj, depth+1});
					}
				}
			}
		}
	}
	// 깊이 parameter - backtracking 
	static void dfs1(int i, int j, int depth) { 
		//if(depth > 11) return; // 백트래킹
		visited[i][j] = true;
		a[i][j] = c++;
		System.out.println(depth);
		for(int[] b:a) System.out.println(Arrays.toString(b));
		System.out.println();
		for(int d=0;d<4;d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(ni>=0 && ni<n && nj>=0 && nj<n && !visited[ni][nj]) { // 범위 설정(경계인지 확인)
				dfs1(ni, nj, depth + 1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		a = new int[n][n];
		visited = new boolean[n][n];
		c = 1;
		// 기본
		//dfs(n/2, n/2);
		//bfs(n/2, n/2);
		
		// 깊이
		//bfs1(n/2, n/2);
		//bfs1(n/2, n/2, 0);
		dfs1(n/2, n/2, 0);
		
		// 리턴
		//System.out.println(bfs2(n/2, n/2));
		//System.out.println(bfs2(n/2, n/2));

		for(int[] b: a) System.out.println(Arrays.toString(b));
	}
}
