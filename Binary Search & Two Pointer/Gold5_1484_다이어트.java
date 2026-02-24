// 문제 번호: 1484
// 문제 제목: 다이어트
// 난이도: Gold 5

import java.util.*;

class Main {
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long g = sc.nextLong();
        boolean found = false;
        long before = 1;
        long now = 2;

        while (true) {
            long kg = now * now - before * before;
            if (now - before == 1 && kg > g) break;
            if (kg < g) {
                now++;
            } else if (kg > g) {
                before++;
            } else {
                System.out.println(now);
                found = true;
                now++;
            }
        }

        if (!found) System.out.println(-1);
    }
}