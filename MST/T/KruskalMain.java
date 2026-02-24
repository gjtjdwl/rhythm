
import java.io.*;
import java.util.*;

public class KruskalMain {	// E log E : 간선이 적을 경우 유리
	static int N;
	static int[] g[]; // Edge 클래스 선언 후 1차원 배열 Edge[] g와 동일 -> 행렬하고 헷갈리지 말자.
	static int[] p; // 메모이제이션 용 배열 
	
	static void make() {
		// union find step 1 : 초기화 -> 각각 서로소가 되도록 (각자의 부모가 자기자신이 되도록)
		p = new int[N];
		for(int i = 0 ; i < N ; i++) {
			p[i] = i;
		}
	}
	static int find(int a) {
		// union find step 2 : 부모노드가 어딘지 find!
		// 부모가 자기자신일 경우
		if(p[a] == a) return a;
		// 부모가 자기자신이 아닐 경우 메모이제이션 -> 포포몬쓰 쩔도록~!
		return p[a] = find(p[a]);
	}
	static boolean union(int a, int b) {
		// union find step 3 : 부모 노드가 같은지 확인 후 union!
		int aRoot = find(a);
		int bRoot = find(b);
		// 같으면 false
		if(aRoot == bRoot) return false;
		// 다르면 union
		p[bRoot] =aRoot;
		return true;
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		g= new int[E][3];
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			g[i] = new int[] {from,to,cost}; // 이렇게 말고 한줄로 {sc.nextInt(), sc.nextInt(), sc.nextInt()} 하는게 최소코딩
			
		}
		Arrays.sort(g,(o1,o2)->Integer.compare(o1[2], o2[2])); // 내림차순은 맥시멈 스빼닝 트뤼
		int mst = 0, cnt = 0;
		make();
		for(int[] edge : g) {
			if(union(edge[0],edge[1])) {
				mst += edge[2];
				if(++cnt == N-1) {
					break;
				}
			}
		}

		System.out.println(mst); // 최소 신장 비용 출력 아잉 너무 자료구조해요
		sc.close();
	}
}
/*
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

output==>10
*/