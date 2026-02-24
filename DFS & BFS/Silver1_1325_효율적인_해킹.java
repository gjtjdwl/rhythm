// 문제 번호: 1325
// 문제 제목: 효율적인 해킹
// 난이도: Silver 1

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] g;
    static boolean[] v;
    static int max, cnt;
    static List<Integer> ans = new ArrayList<>();

    static void bfs(int i, int snode) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[i] = true;
        q.offer(i);
        while(!q.isEmpty()) 
        {
            cnt++;
            i= q.poll();
            for(int j :g[i]) {
                if(!v[j]) {
                    v[j] = true;
                    q.offer(j);
                }
            }
        }
        if(cnt > max){
            max = cnt;
            ans = new ArrayList<>();
            ans.add(snode);
        } else if(cnt == max){
            ans.add(snode);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        g = new List[n + 1];
        for(int i = 1 ; i <= n ; i++){
            g[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[b].add(a);
        }
        for(int i = 1; i <= n; i++){
            v = new boolean[n + 1];
            cnt = 0;
            bfs(i,i);
        }
        for(int item : ans){
            System.out.print(item + " ");
        }
    }
}
