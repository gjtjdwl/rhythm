// 문제 번호: 14940
// 문제 제목: 쉬운 최단거리
// 난이도: Silver 1

import java.io.*;
import java.util.*;

// 14940 쉬운 최단거리
public class Main {
    static int n, m;
    static int[] di = {0, -1, 0, 1};
    static int[] dj = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] v;
    static int[][] path;

    public static void pathfinder(int si, int sj) {
        path[si][sj] = 0;
        v[si][sj] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si, sj});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int d = 0; d < 4; d++) {
                int ni = now[0] + di[d];
                int nj = now[1] + dj[d];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m) {
                    if (!v[ni][nj] && map[ni][nj] != 0) {
                        v[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                        path[ni][nj] = path[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        path = new int[n][m];
        v = new boolean[n][m];
        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        pathfinder(start[0], start[1]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j] && map[i][j] == 1) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(path[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}