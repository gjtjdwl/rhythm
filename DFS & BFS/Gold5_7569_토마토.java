// 문제 번호: 7569
// 문제 제목: 토마토
// 난이도: Gold 5

import java.util.*;
import java.io.*;

// 7569 3차원 토마토
class Main {
    static int[][][] tomato;
    static boolean[][][] v;
    static int m, n, h, day;
    
    static int[] dh = {-1, 1, 0, 0, 0, 0};
    static int[] di = {0, 0, -1, 1, 0, 0};
    static int[] dj = {0, 0, 0, 0, -1, 1};
    
    static Queue<int[]> q = new ArrayDeque<>();

    static public void bfs() {
        while (!q.isEmpty()) {
            int size = q.size();
            for (int t = 0; t < size; t++) {
                int[] now = q.poll();

                for (int d = 0; d < 6; d++) {
                    int nh = now[0] + dh[d];
                    int ni = now[1] + di[d];
                    int nj = now[2] + dj[d];
                    
                    if (nh >= 0 && ni >= 0 && nj >= 0 && nh < h && ni < n && nj < m) {
                        if (tomato[nh][ni][nj] == 0 && !v[nh][ni][nj]) {
                            q.offer(new int[]{nh, ni, nj});
                            v[nh][ni][nj] = true;
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
        h = Integer.parseInt(st.nextToken());
        
        day = 0;
        tomato = new int[h][n][m];
        v = new boolean[h][n][m];
        
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    tomato[k][i][j] = Integer.parseInt(st.nextToken());
                    
                    if (tomato[k][i][j] == 1) {
                        q.offer(new int[]{k, i, j});
                        v[k][i][j] = true;
                    } else if (tomato[k][i][j] == -1) {
                        v[k][i][j] = true;
                    }
                }
            }
        }
        
        bfs();
        
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 안 익은 토마토 존재
                    if (!v[k][i][j] && tomato[k][i][j] == 0) {
                    System.out.println(-1);
                    return;
            }
        }
    }
}
        
        System.out.println(day - 1);
    }
}