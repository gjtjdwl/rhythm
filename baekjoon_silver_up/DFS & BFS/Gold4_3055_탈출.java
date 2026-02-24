// 문제 번호: 3055
// 문제 제목: 탈출
// 난이도: Gold 4

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static String ans;
    static char[][] dungeon;
    static boolean[][] v;
    static int[][] timebomb;
    static int[] start = new int[2], end = new int[2];
    static ArrayDeque<int[]> star;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    static void expand() {
        int size = star.size();
        for (int t = 0; t < size; t++) {
            int[] ij = star.poll();
            int i = ij[0];
            int j = ij[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m) {
                    if (dungeon[ni][nj] == '.' || dungeon[ni][nj] == 'S') {
                        dungeon[ni][nj] = '*';
                        star.offer(new int[]{ni, nj});
                    }
                }
            }
        }
    }

    static void DNF(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        timebomb[i][j] = 0;
        q.offer(new int[]{i, j});
        v[i][j] = true;
        int size;
        while (!q.isEmpty()) {
            expand();
            size = q.size();
            for (int t = 0; t < size; t++) {
                int[] cur = q.poll();
                i = cur[0];
                j = cur[1];
                for (int d = 0; d < 4; d++) {
                    if (i == end[0] && j == end[1]) {
                        ans = String.valueOf(timebomb[i][j]);
                    }
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    if (ni >= 0 && nj >= 0 && ni < n && nj < m) {
                        if ((dungeon[ni][nj] == '.' || dungeon[ni][nj] == 'D') && !v[ni][nj]) {
                            q.offer(new int[]{ni, nj});
                            v[ni][nj] = true;
                            timebomb[ni][nj] = timebomb[i][j] + 1;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = "KAKTUS";
        dungeon = new char[n][m];
        v = new boolean[n][m];
        timebomb = new int[n][m];
        star = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                dungeon[i][j] = line.charAt(j);
                if (dungeon[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                if (dungeon[i][j] == 'D') {
                    end[0] = i;
                    end[1] = j;
                }
                if (dungeon[i][j] == 'X') {
                    v[i][j] = true;
                }
                if (dungeon[i][j] == '*') {
                    star.offer(new int[]{i, j});
                }
            }
        }
        DNF(start[0], start[1]);
        System.out.println(ans);
    }
}