// 문제 번호: 2293
// 문제 제목: 동전 1
// 난이도: Gold 4

import java.util.*;
import java.io.*;

// 2293 동전1
// 다이나믹 프로그래밍
// dp[i] = i 원을 만드는 데 가능한 경우의 수
// 점화식 dp[i] = dp[i] + dp[i-coin]
class Main {

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        System.out.println(dp[k]);
    }
}
