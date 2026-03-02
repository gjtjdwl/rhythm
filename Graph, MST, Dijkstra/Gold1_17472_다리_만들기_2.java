// 문제 번호: 17472
// 문제 제목: 다리 만들기 2
// 난이도: Gold 1

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, icount, bcount;
    static int[][] ourtwentyfour;
    static boolean[][] v;
    static int[] di = { 0, 1, 0, -1 };
    static int[] dj = { 1, 0, -1, 0 };
    static List<int[]> g;
    static int[] p;

    // mst
    static void make() {
        p = new int[icount];
        for (int i = 0; i < icount; i++) {
            p[i] = i;
        }
    }

    static int find(int a) {
        if (p[a] == a)
            return a;
        return p[a] = find(p[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot)
            return false;
        p[bRoot] = aRoot;
        return true;
    }

    // 다리 짓기
    static void bridge() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ourtwentyfour[i][j] == 0)
                    continue;
                for (int d = 0; d < 4; d++) {
                    int blen = 0;
                    int ni = i;
                    int nj = j;
                    while (true) {
                        ni = ni + di[d];
                        nj = nj + dj[d];
                        blen++;
                        if (ni < 0 || nj < 0 || ni >= n || nj >= m)
                            break;
                        if (ourtwentyfour[ni][nj] != 0) {
                            if (ourtwentyfour[ni][nj] != ourtwentyfour[i][j] && blen - 1 > 1) {
                                // 다리 완성되면 섬 번호, 섬 번호, 다리길이 저장
                                int from = ourtwentyfour[i][j];
                                int to = ourtwentyfour[ni][nj];
                                g.add(new int[] { from, to, blen - 1 });
                                bcount++;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    // 섬 구분짓기
    static void island(int i, int j) {
        if (v[i][j])
            return;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { i, j });
        ourtwentyfour[i][j] = icount;
        v[i][j] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            i = now[0];
            j = now[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m && !v[ni][nj]) {
                    if (ourtwentyfour[ni][nj] == 1) {
                        q.offer(new int[] { ni, nj });
                        v[ni][nj] = true;
                        ourtwentyfour[ni][nj] = icount;
                    }
                }
            }
        }
        icount++;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        icount = 1;
        ourtwentyfour = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ourtwentyfour[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ourtwentyfour[i][j] == 0)
                    continue;
                island(i, j);
            }
        }

        g = new ArrayList<>();
        bridge();
        Collections.sort(g, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        int mst = 0, cnt = 0;
        make();
        for (int[] edge : g) {
            if (union(edge[0], edge[1])) {
                mst += edge[2];
                if (++cnt == icount - 2) {
                    break;
                }
            }
        }
        if (cnt == icount - 2)
            System.out.println(mst);
        else
            System.out.println(-1);
    }
}