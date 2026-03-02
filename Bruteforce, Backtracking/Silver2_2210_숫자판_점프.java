// 문제 번호: 2210
// 문제 제목: 숫자판 점프
// 난이도: Silver 2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static String[][] arr;
    static Set<String> nums;
    static int[] di = { 0, -1, 0, 1 };
    static int[] dj = { 1, 0, -1, 0 };

    static void bruteforce(int i, int j, StringBuilder sb, int cnt) {
        if (cnt == 6) {
            nums.add(sb.toString());
            return;
        }
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (ni >= 0 && nj >= 0 && ni < 5 && nj < 5) {
                sb.append(arr[ni][nj]);
                bruteforce(ni, nj, sb, cnt + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
            arr = new String[5][5];
            nums = new HashSet<>();
            for (int i = 0; i < 5; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 5; j++) {
                    arr[i][j] = st.nextToken();
                }
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(arr[i][j]);
                    bruteforce(i, j, sb, 1);
                }
            }
            System.out.println(nums.size());
    }
}
