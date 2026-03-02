// 문제 번호: 7576
// 문제 제목: 토마토
// 난이도: Gold 5

import java.util.*;
import java.io.*;

// 7576 토마토
// bfs 군

class Main {
    static int[][] tomato;
    static boolean[][] v;
    static int n, m, day;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static Queue<int[]> q = new ArrayDeque<>();

    static public void bfs() {
        while (!q.isEmpty()) {
            int size = q.size();
            for (int t = 0; t < size; t++) {
                int[] ij = q.poll();

                for (int d = 0; d < 4; d++) {
                    int ni = ij[0] + di[d];
                    int nj = ij[1] + dj[d];
                    if (ni >= 0 && nj >= 0 && ni < n && nj < m) {
                        if (tomato[ni][nj] == 0 && !v[ni][nj]) {
                            q.offer(new int[]{ni, nj});
                            v[ni][nj] = true;
                        }
                    }
                }
            }
            day++;
        }
    }

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        day = 0;
        tomato = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    v[i][j] = true;
                } else if (tomato[i][j] == -1) {
                    v[i][j] = true;
                }
            }
        }
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j] && tomato[i][j] == 0) {
                    day = 0;
                    break;
                }
            }
        }
        System.out.println(day - 1);
    }
}
