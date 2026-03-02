// 문제 번호: 1197
// 문제 제목: 최소 스패닝 트리
// 난이도: Gold 4

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점 N, 간선 M
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        List<int[]>[] g = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            g[from].add(new int[]{to, cost});
            g[to].add(new int[]{from, cost}); // 무향 그래프이면 양쪽 다 추가
        }

        boolean[] v = new boolean[N + 1];
        int[] prim = new int[N + 1];
        Arrays.fill(prim, Integer.MAX_VALUE);

        int mst = 0, cnt = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

        // 시작 정점 1
        prim[1] = 0;
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] vc = pq.poll();
            int minVertex = vc[0];
            int minCost = vc[1];

            if (v[minVertex]) continue;

            v[minVertex] = true;
            mst += minCost;
            if (++cnt == N) break;

            for (int[] edge : g[minVertex]) {
                int to = edge[0], cost = edge[1];
                if (!v[to] && prim[to] > cost) {
                    prim[to] = cost;
                    pq.offer(new int[]{to, cost});
                }
            }
        }

        System.out.println(mst);
    }
}