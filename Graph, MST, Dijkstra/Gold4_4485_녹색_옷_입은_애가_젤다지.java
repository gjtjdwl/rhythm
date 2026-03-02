// 문제 번호: 4485
// 문제 제목: 녹색 옷 입은 애가 젤다지?
// 난이도: Gold 4

import java.io.*;
import java.util.*;

public class Main {
    static int[] di = { 0, 1, 0, -1 };
    static int[] dj = { 1, 0, -1, 0 };
    static int[][] zelda;
    static int dist[][];
    static boolean[][] v;
    static int n;

    static class point {
        int x, y, d;

        public point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            zelda = new int[n][n];
            v = new boolean[n][n];
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    zelda[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            Queue<point> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.d, o2.d));
            dist[0][0] = zelda[0][0];
            q.offer(new point(0, 0, dist[0][0]));
            while (!q.isEmpty()) {
                point now = q.poll();
                int i = now.x;
                int j = now.y;
                int min = now.d;
                if (v[i][j]) continue;
                if (i == n - 1 && j == n - 1) break;
                v[i][j] = true;
                for (int d = 0; d < 4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    if (ni >= 0 && nj >= 0 && ni < n && nj < n) {
                        if (!v[ni][nj] && dist[ni][nj] > min + zelda[ni][nj]) {
                            dist[ni][nj] = min + zelda[ni][nj];
                            q.offer(new point(ni, nj, dist[ni][nj]));
                        }
                    }
                }
            }
            System.out.println("Problem " + tc + ": " +dist[n-1][n-1]);
            tc++;
        }
    }
}