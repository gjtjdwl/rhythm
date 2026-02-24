// 문제 번호: 17471
// 문제 제목: 게리맨더링
// 난이도: Gold 3

import java.io.*;
import java.util.*;

public class Main {

    static int n, ans;
    static List<Integer> g[];
    static int[] people;
    static ArrayList<Integer> remain;

    // 연결되어 있는지 체크
    static boolean checkparty(ArrayList<Integer> snsd) {
        int i = snsd.get(0);
        boolean[] v = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(i);
        v[i] = true;
        while (!q.isEmpty()) {
            i = q.poll();
            for (int j : g[i]) {
                if (!v[j] && snsd.contains(j)) {
                    q.offer(j);
                    v[j] = true;
                }
            }
        }
        for (int t : snsd) {
            if (!v[t]) {
                return false;
            }
        }
        return true;
    }

    // 부분집합을 구해서
    // 구할 때 마다 가능한지 체크 
    static void ss(int cnt, ArrayList<Integer> pick, ArrayList<Integer> remain) {
        if (cnt == n) {
            if (pick.isEmpty() || remain.isEmpty()) {
                return;
            }
            int sumpick = 0, sumremain = 0;
            if (checkparty(pick) && checkparty(remain)) {
                for (int a : pick) {
                    sumpick += people[a];
                }
                for (int b : remain) {
                    sumremain += people[b];
                }
                ans = Math.min(ans, Math.abs(sumpick - sumremain));
            }
            return;
        }

        
        // 비선택
        ss(cnt + 1, new ArrayList<>(pick), new ArrayList<>(remain));
        
        // 선택
        ArrayList<Integer> firstparty = new ArrayList<>(pick);
        ArrayList<Integer> secondparty = new ArrayList<>(remain);
        firstparty.add(cnt + 1);
        secondparty.remove(Integer.valueOf(cnt + 1));
        ss(cnt + 1, firstparty, secondparty);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 입력
        n = Integer.parseInt(br.readLine());
        g = new List[n + 1];
        people = new int[n + 1];
        remain = new ArrayList<>();
        ans = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            g[i] = new ArrayList<>();
            remain.add(i);
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for (int j = 0; j < t; j++) {
                int to = Integer.parseInt(st.nextToken());
                g[i].add(to);
            }
        }
        ss(0, new ArrayList<>(), remain);
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }
}
