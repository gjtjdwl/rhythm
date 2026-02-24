
import java.io.*;
import java.util.*;

public class GraphListMain{
	static int N;
	// Node 를 만들어서 Node[] g; 를 만드는게 가장 빠르다
	static List<Integer>[] g;//인접 리스트 그래프
	static boolean[] v;
	
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		while(!q.isEmpty()) {
			i= q.poll();
			System.out.print((char)(i+'A')+ " ");
			for(int j :g[i]) {
				if(!v[j]) {
					v[j] = true;
					q.offer(j);
				}
			}
		}
	}
	static void dfs(int i) {
		v[i] = true;
		System.out.print((char)(i+'A')+ " ");
		for(int j :g[i]) { // forEach -> ArrayList 기 때문
			if(!v[j]) {
				dfs(j);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		g = new List[N]; // 제네릭 붙이면 안된다!
		for(int i=0;i<N;i++) {
			g[i] = new ArrayList<>();
		}
		v= new boolean[N]; // 노드 방문 여부 처리
		int E = sc.nextInt();

		for(int i = 0; i < E ; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			// 무방향 그래프
			g[from].add(to);
			g[to].add(from);// 여기 없으면 유향 그래프
		}
		for(List<Integer> a:g) System.out.println(a);
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

=dfs=========
A B D F E C G : 0->N
A C E F G D B : N->0 g[from].add(0, to); 하면 됨
=bfs=========
A B C D E F G : 0->N
A C B E D F G : N->0 

0: [1, 2]
1: [0, 3, 4]
2: [0, 4]
3: [1, 5]
4: [1, 2, 5]
5: [3, 4, 6]
6: [5]
*/