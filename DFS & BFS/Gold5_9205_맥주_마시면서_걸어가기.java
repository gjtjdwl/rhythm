// 문제 번호: 9205
// 문제 제목: 맥주 마시면서 걸어가기
// 난이도: Gold 5

import java.io.*;
import java.util.*;

public class Main {
    static class point {
        int x, y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static point[] cu;
    static boolean[] v;
    static String ans;
    static int dist(int x, int y, int a, int b) {
        return Math.abs(x - a) + Math.abs(y - b);
    }

    static void bfs(point home, point rockfe) {
        Queue<point> q = new ArrayDeque<>();
        q.offer(home);
        while (!q.isEmpty()) {
            point now = q.poll();
            if(now == rockfe){
                ans = "happy";
                break;
            }
            for (int i = 0; i <= n; i++) {
                if(!v[i] && dist(now.x, now.y, cu[i].x, cu[i].y) <= 1000){
                    q.offer(cu[i]);
                    v[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            ans = "sad";
            cu = new point[n + 1];
            v = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            point home = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int i = 0; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                cu[i] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            point rockfe = cu[n];
            bfs(home, rockfe);
            System.out.println(ans);
        }
    }
}