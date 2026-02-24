// 문제 번호: 13549
// 문제 제목: 숨바꼭질 3
// 난이도: Gold 5

import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 100000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        dq.offer(n);
        dist[n] = 0;
        
        while (!dq.isEmpty()) {
            int now = dq.poll(); // 맨 앞에서 꺼냄
            
            if (now == k) {
                System.out.println(dist[now]);
                return;
            }
            
            // 순간이동 (가중치 0) -> 맨 앞에 넣기
            if (now * 2 <= MAX && dist[now * 2] > dist[now]) {
                dist[now * 2] = dist[now]; // 시간 추가 없음
                dq.addFirst(now * 2);      //앞으로 넣음
            }
            
            // 걷기 (가중치 1) -> 맨 뒤에 넣기
            // 뒤로 걷기
            if (now - 1 >= 0 && dist[now - 1] > dist[now] + 1) {
                dist[now - 1] = dist[now] + 1;
                dq.addLast(now - 1);       //뒤로 넣음
            }
            
            // 앞으로 걷기
            if (now + 1 <= MAX && dist[now + 1] > dist[now] + 1) {
                dist[now + 1] = dist[now] + 1;
                dq.addLast(now + 1);       //뒤로 넣음
            }
        }
    }
}