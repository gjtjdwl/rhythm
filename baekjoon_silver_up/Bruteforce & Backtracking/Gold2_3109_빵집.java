// 문제 번호: 3109
// 문제 제목: 빵집
// 난이도: Gold 2

import java.io.*;
import java.util.*;

public class Main {

    static int n, m, ans;
    static boolean[][] v;

    static boolean search(int i, int j) {
        if (j == m - 1) {
            ans++;
            v[i][j] = true;
            return true;
        }

        v[i][j] = true;
        if (i - 1 >= 0) {
            if (!v[i - 1][j + 1]) {
                if (search(i - 1, j + 1)) {
                    return true;
                }
            }
        }

        if (!v[i][j + 1]) {
            if (search(i, j + 1)) {
                return true;
            }
        }

        if (i + 1 < n) {
            if (!v[i + 1][j + 1]) {
                if (search(i + 1, j + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = new boolean[n][m];
        ans = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == 'x') {
                    v[i][j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            search(i, 0);

        }
        System.out.println(ans);

    }
}