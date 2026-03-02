
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointersSum {
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
		
		Arrays.sort(arr); //natural order : 오름차순 정렬
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
