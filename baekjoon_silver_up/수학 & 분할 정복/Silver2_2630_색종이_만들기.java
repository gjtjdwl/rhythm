// 문제 번호: 2630
// 문제 제목: 색종이 만들기
// 난이도: Silver 2

import java.io.*;
import java.util.*;

public class Main {
    static int n, good, bad;
    static int[][] arr;
    static void check(int i, int j, int rend, int cend, int size) {
        int checksum = 0;
        for(int r=i; r<rend; r++) {
            for(int c=j; c<cend;c++) {
                if(arr[r][c] == 1) {
                    checksum++;
                }
            }
        }
        if(checksum == size * size) {bad++; return;}
        else if(checksum == 0) {good++; return;}
        
        int newsize = size/2;
        
        check(i, j, i + newsize, j + newsize, newsize); // 1사분면 0 ~ 1/2 + 0 ~ 1/2
        check(i, j+newsize, i + newsize, j + size, newsize); // 2사분면 0 ~ 1/2 + 1/2 ~ 1
        check(i+newsize, j+newsize, i + size, j + size,newsize); // 3사분면 1/2 ~ 1 + 1/2 ~ 1
        check(i+newsize, j, i + size, j +newsize, newsize); // 4사분면 1/2 ~ 1 + 0 ~ 1/2
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        good = bad = 0;
        int size = n;
        check(0,0,size,size,size);
        System.out.println(good);
        System.out.println(bad);
    }

}
