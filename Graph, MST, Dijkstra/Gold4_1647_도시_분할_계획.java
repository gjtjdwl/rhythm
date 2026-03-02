// 문제 번호: 1647
// 문제 제목: 도시 분할 계획
// 난이도: Gold 4

import java.io.*;
import java.util.*;

// 최소 길만 찾아서 연결 후, 가장 높은 비용을 끊기
class Main {
    static class graph {
        int vertex, cost;

        public graph(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    static List<graph>[] house;
    static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        v = new boolean[n + 1];
        house = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            house[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            house[v1].add(new graph(v2, cost));
            house[v2].add(new graph(v1, cost));
        }
        // prim 알고리즘
        int mst = 0; int cnt = 0;
        int[] prim = new int[n + 1];
        Arrays.fill(prim, Integer.MAX_VALUE);
        prim[1] = 0;
        Queue<graph> pq = new PriorityQueue<>((o1, o2)-> Integer.compare(o1.cost, o2.cost));
        pq.offer(new graph(1, prim[1]));
        while(!pq.isEmpty()){
            graph now = pq.poll();
            if(v[now.vertex]) continue;

            v[now.vertex] = true;
            mst += now.cost;
            if(cnt++ == n-1) break;

            for(graph neighbor : house[now.vertex]){
                if(!v[neighbor.vertex] && prim[neighbor.vertex] > neighbor.cost){
                    prim[neighbor.vertex] = neighbor.cost;
                    pq.add(new graph(neighbor.vertex, prim[neighbor.vertex]));
                }
            }
        }
        int maxroad = 0;
        for(int i = 1; i<prim.length;i++){
            maxroad = Math.max(maxroad, prim[i]);
        }
        
        System.out.println(mst-maxroad);
    }
}