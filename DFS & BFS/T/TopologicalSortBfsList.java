
import java.io.*;
import java.util.*;

public class TopologicalSortBfsList {
	static int V,E;
	static List<Integer>[] g; // 인접리스트로 그래프 표현
	static int[] indegree; // 진입 차수 메모이제이션
	
	static void bfs() {
		ArrayDeque<Integer> q = new ArrayDeque<>();// 빠른 순서로 해결하고 싶을경우 pq 사용
		//for(int i=V; i>=1; i--) // V -> 1
		for(int i=1;i<V+1;i++) {
			if(indegree[i]==0) q.offer(i); // 진입차수가 0일경우 탐색
		}

		while(!q.isEmpty()) {
			int i= q.poll();
			System.out.print(i + " ");
			for(int j :g[i]) {
				indegree[j]--;
				if(indegree[j] == 0) q.offer(j);
				}
			}
		}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		g = new List[V+1];// 0번 쓰지 않고 사용
		for(int i=0;i< V+1;i++) {
			g[i] = new ArrayList<>();
		}
		indegree = new int[V+1];
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			g[from].add(to);
			indegree[to]++; // 진입 차수 관리
		}
		sc.close();
	}

}

/*
3 2
1 3
2 3
	1
  	 \
  2---3

   1 2 3
1: . . 1
2: . . 1
3: . . .

1 2 3
2 1 3

*/
/* 큐에 넣어서 진입 차수가 없는 친구부터 bfs */