
import java.io.*;
import java.util.*;

public class DijkstraMain {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<int[]>[] g=new List[N]; // to와 cost 집어넣을 배열 타입 List 
		for(int i = 0; i < N; i++) {
			g[i] = new ArrayList<>();
		}
		boolean v[] =new boolean[N];
		int[] dist = new int[N];// min edge 기록할 메모이제이션 배열
		Arrays.fill(dist, Integer.MAX_VALUE); // 다익스트라 1차원 배열 메모이제이션 
		// 인덱스 = 정점 번호(1 : 0->1 가는 거리), 데이터 = 각 정점으로 가는 최단 거리 기억
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int c = sc.nextInt();
				if(c==0) continue;
				g[i].add(new int[] {j, c}); // 정점과 비용 입력
				
			}
		}
		
		//int mst = 0, cnt = 0;
		dist[0] = 0; // 시작 지점
		for(int i = 0; i < N; i++) { // pq로 바꾸면 시간복잡도 감소 = 다익스트라
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			// step 1 :최소비용 해당하는 min, 정점 찾기
			for(int j = 0; j < N; j++) {
				if(!v[j] && min > dist[j]) {
					minVertex = j;
					min = dist[j];	
				}
			}
			//step 2 : 방문처리
			v[minVertex] = true;
			//mst += min;
			if(minVertex == N - 1) break;// end 정점에 도착 할 경우 break
			
			// step 3 : 최소거리 갱신 
			for(int[] jc : g[minVertex]) {
				if(!v[jc[0]] && dist[jc[0]] > min+jc[1]) { // 경유지 거쳐서 갈 경우가 더 작으면
					dist[jc[0]] = min+jc[1];
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
0 -> 2 -> 4 : 경유

*/