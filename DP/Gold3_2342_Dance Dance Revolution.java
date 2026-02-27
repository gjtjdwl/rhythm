// 문제 번호: 2342
// 문제 제목: Dance Dance Revolution
// 난이도: Gold 3
import java.util.*;
import java.io.*;

class Main {
    static int[] ddr;
    static int[][][] dp;

    public static int getCost(int now, int next) {
        if (now == next) {
            return 1;
        }
        if (now == 0) {
            return 2;
        }
        if (Math.abs(now - next) == 2) {
            return 4;
        }
        return 3;
    }

    public static int dancing(int idx, int left, int right) {
        if (idx == ddr.length - 1) {
            return 0;
        }

        if (dp[idx][left][right] != -1) {
            return dp[idx][left][right];
        }

        int target = ddr[idx];
        int moveLeft = dancing(idx + 1, target, right) + getCost(left, target);
        int moveRight = dancing(idx + 1, left, target) + getCost(right, target);

        dp[idx][left][right] = Math.min(moveLeft, moveRight);

        return dp[idx][left][right];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int left, right;
        left = right = 0;
        int idx = st.countTokens();
        ddr = new int[idx];
        dp = new int[idx][5][5];
        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        for (int i = 0; i < idx; i++) {
            ddr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = dancing(0,0,0);
        System.out.println(ans);
    }
}
