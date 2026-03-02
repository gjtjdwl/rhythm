
import java.io.*;
import java.util.*;

public class GraphMatrixMain{
	static int N;
	static int[][] g;// 인접 행렬 그래프 -> 난이도 낮은 문제
	static boolean[] v;
	
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		while(!q.isEmpty()) {
			i= q.poll();
			System.out.print((char)(i+'A')+ " ");
			//for(int j = N-1 ; j >=0 ; j--)  뒤에서 부터 방문 = 내림차순 방문
			for(int j = 0 ; j < N ; j++) {
				if(g[i][j] != 0 && !v[j]) {
					v[j] = true;
					q.offer(j);
				}
			}
		}
	}
	static void dfs(int i) {
		v[i] = true;
		System.out.print((char)(i+'A')+ " ");
		for(int j = 0 ; j < N ; j++) {
			if(g[i][j] != 0 && !v[j]) {
				dfs(j);
			}
		}
		/* 뒤에서 부터 방문 = 내림차순 부터 방문
		for(int j = N-1 ; j >=0 ; j--) {
			if(g[i][j] != 0 && !v[j]) {
				dfs(j);
			}
		}*/
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		g = new int[N][N];
		v= new boolean[N]; // 노드 방문 여부 처리
		int E = sc.nextInt();

		for(int i = 0; i < E ; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			// 무방향 그래프
			g[from][to] = g[to][from] = 1; // 이렇게도 된대 오 신기
			// cost가 있으면 1 대신 cost를 추가
		}
		//for(int[]a:g) System.out.println(Arrays.toString(a));
		bfs(0);
		//dfs(0);
		sc.close();
	}
}
/*
....A0
.../.\
..B1.C2
./.\./
D3..E4
..\.|
...F5-G6

7
8
0 1
0 2	
1 3
1 4
2 4
3 5
4 5
5 6

x 0 1 2 3 4 5 6
0 0 1 1 . . . .
1 1 0 . 1 1 . .
2 1 . 0 . 1 . .
3 . 1 . 0 . 1 .
4 . 1 1 . 0 1 .
5 . . . 1 1 0 1
6 . . . . . 1 0

=dfs=========
A B D F E C G : 0->N
A C E F G D B : N->0
=bfs=========
A B C D E F G : 0->N
A C B E D F G : N->0
*/