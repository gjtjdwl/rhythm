import java.io.*;
import java.util.*;

// 1238 파티
public class Main {
    public static class node {
        int vertex;
        int cost;

        public node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    static int N, M, X;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<node>[] g = new List[N + 1];
        List<node>[] reverse = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            g[from].add(new node(to, cost));
            reverse[to].add(new node(from, cost));
        }

        // N -> X 다익스트라
        int[] toX = new int[N + 1];
        boolean[] vX = new boolean[N + 1];
        Arrays.fill(toX, Integer.MAX_VALUE);
        PriorityQueue<node> pqX = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        toX[X] = 0;
        pqX.offer(new node(X, toX[X]));
        while (!pqX.isEmpty()) {
            node now = pqX.poll();
            if (vX[now.vertex]) continue;

            vX[now.vertex] = true;

            for (node next : reverse[now.vertex]) {
                if (!vX[next.vertex] && toX[next.vertex] > toX[now.vertex] + next.cost) {
                    toX[next.vertex] = toX[now.vertex] + next.cost;
                    pqX.offer(new node(next.vertex, toX[next.vertex]));
                }
            }
        }
        // X -> N 다익스트라
        int[] toN = new int[N + 1];
        boolean[] vN = new boolean[N + 1];
        Arrays.fill(toN, Integer.MAX_VALUE);
        PriorityQueue<node> pqN = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        toN[X] = 0;
        pqN.offer(new node(X, toN[X]));
        while (!pqN.isEmpty()) {
            node now = pqN.poll();
            if (vN[now.vertex]) continue;

            vN[now.vertex] = true;

            for (node next : g[now.vertex]) {
                if (!vN[next.vertex] && toN[next.vertex] > toN[now.vertex] + next.cost) {
                    toN[next.vertex] = toN[now.vertex] + next.cost;
                    pqN.offer(new node(next.vertex, toN[next.vertex]));
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (toX[i] + toN[i] > ans) {
                ans = toX[i] + toN[i];
            }
        }

        System.out.println(ans);
    }
}