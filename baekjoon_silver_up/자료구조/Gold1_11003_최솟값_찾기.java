// 문제 번호: 11003
// 문제 제목: 최솟값 찾기
// 난이도: Gold 1

import java.io.*;
import java.util.*;

public class Main {
    // 슬라이딩 윈도우... 인거 같은데 포문으로 하면 시간초과 날 것 같은디
    // 슬윈 + 덱이라고 하네용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        int[] minarr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            idx = i - l + 1;
            // 현재 원소와 덱 비교
            if (dq.isEmpty()) {
                dq.push(i);
            } else {
                while (!dq.isEmpty() && nums[dq.peekLast()] > nums[i]) {
                    dq.pollLast();
                }
                dq.offerLast(i);
            }
            // 슬라이딩 윈도우 범위와 덱 비교
            if (dq.peekFirst() < idx) {
                dq.pollFirst();
            }
            minarr[i] = nums[dq.peekFirst()];
        }
        StringBuilder sb = new StringBuilder();
        for(int num : minarr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}