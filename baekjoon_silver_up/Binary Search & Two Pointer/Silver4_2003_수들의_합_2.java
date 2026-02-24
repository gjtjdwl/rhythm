// 문제 번호: 2003
// 문제 제목: 수들의 합 2
// 난이도: Silver 4

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[N];
            st = new StringTokenizer(in.readLine()," ");
            
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int s = 0, e = 0, ans = 0;
            
            while(e <= N) {
                int sum = 0;

                for(int i = s; i < e; i++) {
                    sum = sum + arr[i];
                }
                if(sum == target) {
                    ans++; s++;
                }
                else if(sum > target) {
                    s++;
                }
                else if(sum < target) {
                    e++;
                }
            }
            System.out.println(ans);
            
        }
}
