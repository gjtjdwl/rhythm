import java.io.*;
import java.util.*;

public class TopologicalSortDfsList {
	static int V,E;
	static List<Integer>[] g; // 인접리스트로 그래프 표현
	static boolean[] v; // 진입 차수 메모이제이션
	static ArrayDeque<Integer> s = new ArrayDeque<>();

	static void dfs(int i) { // dfs를 실행 한 다음, 방문할 곳이 없는 경우 스택에 푸쉬 - 마지막에 스택에서 꺼내며 출력
		v[i] = true;
		for(int j: g[i]) {
			if(!v[j]) {
				dfs(j);
			}
		}
		s.push(i); // 방문할 곳이 없다
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		g = new List[V+1];// 0번 쓰지 않고 사용
		v = new boolean[V+1];
		for(int i=0;i< V+1;i++) {
			g[i] = new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			g[from].add(to);
		}
		//for(int i=V;i>=1;i--)
		for(int i=1;i <=V;i++) {
			if(!v[i]) dfs(i);
		}
		while(!s.isEmpty()) {
			System.out.print(s.pop() + " ");
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

2 1 3

*/
/* 큐에 넣어서 진입 차수가 없는 친구부터 bfs */