// 문제 번호: 15686
// 문제 제목: 치킨 배달
// 난이도: Gold 5

import java.io.*;
import java.util.*;

public class Main {

    static class Point {

        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();
    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static boolean[] c;

    static void comb(int cnt, int start) {

        if (cnt == m) {
            // 다 뽑았으니까 거리 계산하기!
            int t = 0;
            for (int i = 0; i < houses.size(); i++) {
                int temp = 999999999;
                for (int j = 0; j < chickens.size(); j++) {
                    if (c[j] == true) {
                        int distance = Math.abs(houses.get(i).x - chickens.get(j).x) + Math.abs(houses.get(i).y - chickens.get(j).y);
                        temp = Math.min(temp, distance);
                    }
                }
                t += temp;
            }
            ans = Math.min(ans, t);
        }

        for (int i = start; i < chickens.size(); i++) {
            c[i] = true;
            comb(cnt + 1, i + 1);
            c[i] = false;
        }
    }

    public static void main(String args[]) throws Exception {
        // 입출력
        //System.setIn(new FileInputStream("res/input_d1_2073.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1과 2의 좌표 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    houses.add(new Point(i, j)); 
                }else if (arr[i][j] == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }
        c = new boolean[chickens.size()];
        // 2의 조합 뽑기
        comb(0, 0);
        System.out.println(ans);
    }
}
