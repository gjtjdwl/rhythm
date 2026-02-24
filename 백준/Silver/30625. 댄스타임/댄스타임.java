
import java.util.*;
import java.io.*;

// 30625 댄스타임

class Main {
    static final int mod = 1000000007;

    static class dancetime {
        int genre;
        int d;

        public dancetime(int genre, int d) {
            this.genre = genre;
            this.d = d;
        }
    }

    public static long power(long base, long e) {
        long res = 1;
        for (int i = 0; i < e; i++) {
            res = (res * base) % mod;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        m = m - 1;
        long fastforward = 0;
        long backitup = 0;
        dancetime[] eta = new dancetime[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int genre = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (d == 0) fastforward++;
            else if (d == 1) backitup++;
            eta[i] = new dancetime(genre, d);
        }
        // 다 맞출 경우
        long front = 0, behind = 0;
        long alldayproject = power(m, backitup);
        // 앞을 틀릴 경우
        if (fastforward >= 1) {
            front = power(m, backitup + 1) * fastforward;
        }
        // 뒤를 틀릴 경우
        if (backitup >= 1) {
            behind = power(m, backitup - 1) * backitup;
        }
        long result = (alldayproject % mod) + (front % mod) + (behind % mod);
        result = result % mod;
        System.out.println(result);
    }
}