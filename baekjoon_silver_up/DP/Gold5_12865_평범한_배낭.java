// 문제 번호: 12865
// 문제 제목: 평범한 배낭
// 난이도: Gold 5

import java.io.*;
import java.util.*;

public class Main {
    static int n, l;
    static int[] v;
    static int[] c;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            v = new int[n];
            c = new int[n];
            dp = new int[n + 1][l + 1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                v[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                for (int t = 0; t <= l; t++) {
                    dp[i][t] = dp[i - 1][t];
                    if (v[i - 1] <= t) {
                        dp[i][t] = Math.max(dp[i][t], dp[i - 1][t - v[i - 1]] + c[i - 1]);
                    }
                }
            }
            System.out.println(dp[n][l]);
    }
}
