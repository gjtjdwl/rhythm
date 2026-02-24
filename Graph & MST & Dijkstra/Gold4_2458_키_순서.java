// 문제 번호: 2458
// 문제 제목: 키 순서
// 난이도: Gold 4

import java.io.*;
import java.util.*;

public class Main {

    static int V, E, ans;
    static List<Integer>[] up, down;
    static boolean[] visited;

    static int bfs(int i, List<Integer>[] t) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int r = 0;
        q.offer(i);
        visited[i] = true;
        while (!q.isEmpty()) {
            i = q.poll();
            r++;
            for (int j : t[i]) {
                if (!visited[j]) {
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }
        return r - 1;
    }

    // 하지만 해야지
    // 자기자신으로부터 bfs -> 위, 아래 구해서 둘 더한게 v-1이면 정답
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        up = new List[V + 1];
        down = new List[V + 1];
        for (int i = 0; i <= V; i++) {
            up[i] = new ArrayList<>();
            down[i] = new ArrayList<>();
        }

        for (int t = 0; t < E; t++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            up[from].add(to);
            down[to].add(from);
        }
        ans = 0;
        for (int i = 1; i < V + 1; i++) {
            visited = new boolean[V + 1];
            int u = bfs(i, up);
            visited = new boolean[V + 1];
            int d = bfs(i, down);
            if (u + d == V - 1) {
                ans++;
            }

        }
        System.out.println(ans);
    }
}
