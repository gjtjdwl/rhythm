

import java.io.*;
import java.util.*;

public class PrimPqMain {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<int[]>[] g=new List[N]; // to와 cost 집어넣을 배열 타입 List 
		for(int i = 0; i < N; i++) {
			g[i] = new ArrayList<>();
		}
		boolean v[] =new boolean[N];
		int[] prim = new int[N];// min edge 기록할 메모이제이션 배열
		Arrays.fill(prim, Integer.MAX_VALUE); // 최소비용 기록 -> 최댓값 fill
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int c = sc.nextInt();
				if(c==0) continue;
				g[i].add(new int[] {j, c}); // 정점과 비용 입력
				
			}
		}
		int mst = 0, cnt = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1[1], o2[1])); // 최소 힙 -> cost기준 정렬
		prim[0] = 0; // 시작 지점
		pq.offer(new int[] {0, prim[0]});
		while(!pq.isEmpty()) { // pq로 바꾸면 시간복잡도 감소(VlogN) = 다익스트라
			// step 1 : prim 최소비용 해당하는 min, 정점 찾기
			int[] vc = pq.poll();//최소비용 정점 꺼내기 
			int minVertex = vc[0];
			int min = vc[1];
			// if(min>prim[minVertex]) continue; 가지치기
			if(v[minVertex]) continue; // 방문 했으면 컨티뉴

			//step 2 : 방문처리 후 mst에 포함
			v[minVertex] = true;
			mst += min;
			if(cnt++ == N - 1) break;
			
			// step 3 : prim 배열 갱신 (제일 중요)
			for(int[] jc : g[minVertex]) {
				if(!v[jc[0]] && prim[jc[0]] > jc[1]) {
					prim[jc[0]] = jc[1];
					pq.offer(new int[] {jc[0], prim[jc[0]]});// 갱신 했으면 pq에 넣기
				}
			}
		}
		System.out.println(mst);
		sc.close();
	}

}
/*
정점 중심 - 행렬
 
5
0 5 10 8 7
5 0 5 3 6
10 5 0 1 3
8 3 1 0 1
7 6 3 1 0

output : 10
*/