// 문제 번호: 14567
// 문제 제목: 선수과목 (Prerequisite)
// 난이도: Gold 5

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<Integer>[] g;
    static int[] indegree, sems;

    static void TS() {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int i = q.poll();
            for(int j : g[i]){
                indegree[j] --;
                sems[j] = Math.max(sems[j], sems[i] + 1);
                if(indegree[j] == 0){
                    q.offer(j);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        indegree = new int[n + 1];
        sems = new int[n + 1];
        Arrays.fill(sems, 1);
        g = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            g[from].add(to);
            indegree[to]++;
        }
        TS();
        for (int i = 1; i < n + 1; i++) {
            System.out.print(sems[i] + " ");
        }
    }
}