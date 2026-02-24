
import java.io.*;
import java.util.*;

public class DijkstraPqMain {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<int[]>[] g=new List[N]; 
		for(int i = 0; i < N; i++) {
			g[i] = new ArrayList<>();
		}
		boolean v[] =new boolean[N];
		int[] dist = new int[N]; // 다익스트라 1차원 배열 메모이제이션 
		// 인덱스 = 정점 번호(1 : 0->1 가는 거리), 데이터 = 각 정점으로 가는 최단 거리 기억
		Arrays.fill(dist, Integer.MAX_VALUE); // 최소비용 기록 -> 최댓값 fill
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int c = sc.nextInt();
				if(c==0) continue;
				g[i].add(new int[] {j, c}); // 정점과 비용 입력
				
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1[1], o2[1])); // 최소 힙 -> cost기준 정렬
		dist[0] = 0; // 시작 지점
		pq.offer(new int[] {0, dist[0]});
		while(!pq.isEmpty()) { // pq로 바꾸면 시간복잡도 감소(VlogN) = 다익스트라
			// step 1 : 최소 거리 찾기
			int[] vc = pq.poll();//최소 거리 꺼내기 
			int minVertex = vc[0];
			int min = vc[1];
			// if(min>prim[minVertex]) continue; 가지치기
			if(v[minVertex]) continue; // 방문 했으면 컨티뉴

			//step 2 : 방문처리 후 mst에 포함
			v[minVertex] = true;
			if(minVertex == N - 1) break; // end 정점에 도착 할 경우 break
			
			// step 3 : 배열 갱신
			for(int[] jc : g[minVertex]) {
				if(!v[jc[0]] && dist[jc[0]] > min + jc[1]) {
					dist[jc[0]] = min + jc[1];
					pq.offer(new int[] {jc[0], dist[jc[0]]});// 갱신 했으면 pq에 넣기
				}
			}
		}
		System.out.println(dist[N-1]);
		sc.close();
	}

}
/*
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

8
     9
0 ------> 4 : 직항 
  2    6
0 -> 2 -> 4 : 경우

*/