// 문제 번호: 2493
// 문제 제목: 탑
// 난이도: Gold 5

import java.io.*;
import java.util.*;

public class Main {
    // 저번에 풀었던 문제랑 비슷
    // 스택에 까꿀로 넣어서 top이랑 비교해서 작으면 pop하고 기록
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ltns = new int[n + 1];
        int[] where = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            ltns[i] = Integer.parseInt(st.nextToken());
        }
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{n, ltns[n]});
        int next = n - 1;
        while (next > 0) {
            while (!stack.isEmpty()) {
                // 왼쪽 건물과 비교
                if (stack.peek()[1] < ltns[next]) {
                    int here = stack.pop()[0];
                    where[here] = next;
                } else {
                    break;
                }
            }
            stack.push(new int[]{next, ltns[next]});
            next--;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(where[i] + " ");
        }
    }
}