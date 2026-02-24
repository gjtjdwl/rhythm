// 문제 번호: 1074
// 문제 제목: Z
// 난이도: Gold 5

import java.io.*;
import java.util.*;

// 1074 Z
public class Main {
    static int N, r, c;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = 0; i < 15; i++) {
            ans += (r & (1 << i)) << (i + 1);
            ans += (c & (1 << i)) << i;
        }
        System.out.println(ans);
    }
}