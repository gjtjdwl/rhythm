// 문제 번호: 20040
// 문제 제목: 사이클 게임
// 난이도: Gold 4

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int p[];
    static void make() {
        for(int i=0;i<n;i++) {
            p[i] = i;
        }
    }
    static int find(int a) {
        if(p[a] == a) return a;
        
        else return find(p[a]);
    }
    static boolean union(int a, int b) {
        int aroot = find(p[a]);
        int broot = find(p[b]);
        
        if(aroot == broot) return true;
        else {
            p[broot] = aroot;
            return false;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = new int[n];
        int turnel = 1;
        make();
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(union(a, b)) {
                System.out.println(turnel);
                break;
            }
            turnel++;
        }
        if(turnel - 1 == m) {
            System.out.println(0);
        }
    }
}
