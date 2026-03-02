import java.io.*;
import java.util.*;

// 1504 특정한 최단 경로
public class Gold4_1504_특정한_최단_경로 {
    public static class node {
        int vertex;
        int cost;

        public node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    static int N, E, v1, v2;
    static List<node>[] g;

    public static int dijkstra(int start, int target) {
        int[] dist = new int[N + 1];
        boolean[] v = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        dist[start] = 0;
        pq.offer(new node(start, dist[start]));

        while (!pq.isEmpty()) {
            node now = pq.poll();

            if (v[now.vertex]) continue;
            v[now.vertex] = true;
            if (v[target]) return dist[target];
            for (node next : g[now.vertex]) {
                if (!v[next.vertex] && dist[next.vertex] > dist[now.vertex] + next.cost) {
                    dist[next.vertex] = dist[now.vertex] + next.cost;
                    pq.offer(new node(next.vertex, dist[next.vertex]));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        g = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            g[from].add(new node(to, cost));
            g[to].add(new node(from, cost));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        int a = -1, b = -1;
        // 1 -> v1 -> v2 -> N 다익스트라
        int first = dijkstra(1, v1);
        int second = dijkstra(v1, v2);
        int third = dijkstra(v2, N);
        if(first != -1 && second != -1 && third != -1) {
            a = first + second + third;
        }
        // 1 -> v2 -> v1 -> N 다익스트라
        first = dijkstra(1, v2);
        second = dijkstra(v2, v1);
        third = dijkstra(v1, N);
        if(first != -1 && second != -1 && third != -1) {
            b = first + second + third;
        }
        int ans = Math.min(a, b);

        System.out.println(ans);
    }
}