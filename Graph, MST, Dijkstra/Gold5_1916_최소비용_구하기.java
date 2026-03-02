// 문제 번호: 1916
// 문제 제목: 최소비용 구하기
// 난이도: Gold 5

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<long[]> g[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        g = new List[n + 1];
        for(int i=0;i<=n;i++) {
            g[i] = new ArrayList<>();
        }
        boolean[] v = new boolean[n + 1];
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Integer.parseInt(st.nextToken());
            g[from].add(new long[] {to,cost});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        dist[start] = 0;
        Queue<long[]> pq = new PriorityQueue<>((o1,o2)->Long.compare(o1[1], o2[1]));
        pq.offer(new long[] {start, dist[start]});
        while(!pq.isEmpty()) {
            long[] now = pq.poll();
            int j = (int) now[0];
            v[j] = true;
            if(v[end]) break;
            for(long[] jc: g[j]) {
                int nj = (int) jc[0]; long nc = jc[1];
                if(!v[nj] && dist[nj] > dist[j] + nc) {
                    dist[nj] = dist[j] + nc;
                    pq.offer(new long[] {jc[0], dist[nj]});
                }
            }
        }
        System.out.println(dist[end]);
    }
}
