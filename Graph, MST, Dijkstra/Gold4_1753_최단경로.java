// 문제 번호: 1753
// 문제 제목: 최단경로
// 난이도: Gold 4

import java.util.*;
import java.io.*;

// 1753 최단경로
//  디자익스트라 문제
class Main {
    static class graph {
        int vertex;
        int cost;

        public graph(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        List<graph>[] g = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            g[Integer.parseInt(st.nextToken())].add(new graph(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        boolean[] v = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<graph> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        dist[start] = 0;
        pq.offer(new graph(start, 0));
        while (!pq.isEmpty()) {
            // step 1 : 최소 거리 찾기
            graph min = pq.poll();
            if (v[min.vertex]) continue;
            //step 2 : 방문처리
            v[min.vertex] = true;
            // step 3 : 배열 갱신
            for (graph next : g[min.vertex]) {
                if (!v[next.vertex] && dist[next.vertex] > min.cost + next.cost) {
                    dist[next.vertex] = min.cost + next.cost;
                    pq.offer(new graph(next.vertex, dist[next.vertex]));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                System.out.println(dist[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}