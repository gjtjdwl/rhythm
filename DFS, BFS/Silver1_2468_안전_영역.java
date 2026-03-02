// 문제 번호: 2468
// 문제 제목: 안전 영역
// 난이도: Silver 1

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, ans;
    static int[][] ground;
    static boolean[][] v;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    static void rainyday(int day) {
        int pinocchio = 0;
        v = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ground[i][j] <= day) {
                    v[i][j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!v[i][j]) {
                    search(i, j);
                    pinocchio++;
                }
            }
        }
        ans = Math.max(ans, pinocchio);
    }

    static void search(int i, int j) {
        v[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (ni >= 0 && nj >= 0 && ni < n && nj < n && !v[ni][nj]) {
                search(ni, nj);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        ans = -1;
        ground = new int[n][n];
        int allday = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                allday = Math.max(ground[i][j], allday);
            }
        }
        for (int i = 0; i <= allday; i++) {
            rainyday(i);
        }
        System.out.println(ans);
    }
}
