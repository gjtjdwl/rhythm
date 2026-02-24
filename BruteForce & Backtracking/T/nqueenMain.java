import java.io.*;
import java.util.*;

public class nqueenMain {
	static int n, ans, col[];
	
	static boolean able(int i) {
		for(int j = 0; j < i; j++) {
			if(col[i] == col[j] 
			|| Math.abs(col[i] - col[j]) == Math.abs(i - j)) {
				return false;
			}
		}
		return true;
	}
	
	static void nqueen(int i) {
		if(!able(i-1)) return; // backtracking
		if(i == n) {
			ans++;
			return;
		}
		for(int j=0;j<n;j++) {
			col[i] = j;
			nqueen(i+1);
			//if(able(i)) nqueen(i+1); backtracking 다른 방식
		}
	}
	
	public static void main(String[] args) throws Exception {
		n=4;
		col=new int[n];
		nqueen(0);
		System.out.println(ans);
	}
}
