// 문제 번호: 16930
// 문제 제목: 달리기
// 난이도: Platinum 3

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int si, sj, ei, ej;
    static char[][] room;
    static int[][] time;
    static int[] di = {1, 0, -1, 0};
    static int[] dj = {0, 1, 0, -1};

    static void search(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { i, j });
        time[i][j] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            i = now[0];
            j = now[1];

            if (i == ei && j == ej) {
                System.out.println(time[i][j]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                for (int l = 1; l <= k; l++) {
                    int ni = i + di[d] * l;
                    int nj = j + dj[d] * l;

                    if (ni < 0 || nj < 0 || ni >= n || nj >= m) break;
                    if (room[ni][nj] == '#') break;

                    if (time[ni][nj] < time[i][j] + 1) break;

                    if (time[ni][nj] == 10000000) {
                        time[ni][nj] = time[i][j] + 1;
                        q.offer(new int[]{ni, nj});
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        room = new char[n][m];
        time = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                room[i][j] = line.charAt(j);
                time[i][j] = 10000000;
            }
        }

        st = new StringTokenizer(br.readLine());
        si = Integer.parseInt(st.nextToken()) - 1;
        sj = Integer.parseInt(st.nextToken()) - 1;
        ei = Integer.parseInt(st.nextToken()) - 1;
        ej = Integer.parseInt(st.nextToken()) - 1;

        search(si, sj);
    }
}