// 문제 번호: 13164
// 문제 제목: 행복 유치원
// 난이도: Gold 5

import java.io.*;
import java.util.*;

public class Main {
    // 배열의 차를 구해서 차이가 가장 큰 구간을 끊으면 되지 않을까? 라는 생각 (그리디?)
    // 최소 값이니까 정렬해서 k-1만큼 버리고 합 구하면 될듯
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] babies = new int[n + 1];
        int[] chai = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            babies[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 2; i <= n; i++) {
            chai[i - 1] = babies[i] - babies[i - 1];
        }
        Arrays.sort(chai);
        long sum = 0;
        for (int i = 1; i < n - k + 1; i++) {
            sum += (long) chai[i];
        }
        System.out.println(sum);
    }
}