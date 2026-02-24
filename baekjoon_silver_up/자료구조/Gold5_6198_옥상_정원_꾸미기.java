// 문제 번호: 6198
// 문제 제목: 옥상 정원 꾸미기
// 난이도: Gold 5

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] buildings = new int[n + 1];
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            buildings[i] = Integer.parseInt(br.readLine());
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // top 보다 작으면 push, 크면 top을 pop하고 다시 top과 비교
        // stack 안에 있는 건물은 나를 볼 수 있음 -> stack size 만큼 ans 에 더하기
        for (int i = 1; i <= n; i++) {
            if (stack.isEmpty()) {
                stack.push(buildings[i]);
            } else {
                while (!stack.isEmpty() && buildings[i] >= stack.peek()) {
                    stack.pop();
                }
                ans += stack.size();
                stack.push(buildings[i]);
            }
        }
        System.out.println(ans);
    }
}