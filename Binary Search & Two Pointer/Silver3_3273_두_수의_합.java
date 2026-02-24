// 문제 번호: 3273
// 문제 제목: 두 수의 합
// 난이도: Silver 3

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int target = Integer.parseInt(in.readLine());
        Arrays.sort(arr); //natural order : 오름차순
        int s = 0, e = N-1, ans = 0;
        
        while(s<e) {
            int sum = 0;
            sum = arr[s] + arr[e];
            if(sum == target) {
                ans++; s++; e--;
            }
            else if(sum > target) {
                e--;
            }
            else if(sum < target) {
                s++;
            }
        }
        System.out.println(ans);
        
    }
}
