// 문제 번호: 12919
// 문제 제목: A와 B 2
// 난이도: Gold 5

import java.util.*;
import java.io.*;

// 12919 A와 B 2

class Main {
    static String original;
    static int answer;

    public static void compare(String change) {
        if (answer == 1) return;
        if (change.equals(original)) {
            answer = 1;
            return;
        }
        if (change.length() < original.length()) return;
        StringBuilder ch = new StringBuilder(change);
        if (ch.toString().charAt(0) == 'B') {
            // B를 붙여 A가 맨 앞으로 온 경우
            String caseB = new StringBuilder(ch).deleteCharAt(0).reverse().toString();
            compare(caseB);
        }
        if (ch.toString().charAt(ch.length() - 1) == 'A') {
            // A를 붙인 경우
            String caseA = new StringBuilder(ch).deleteCharAt(ch.length() - 1).toString();
            compare(caseA);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        original = br.readLine();
        String change = br.readLine();
        answer = 0;
        compare(change);
        System.out.println(answer);
    }
}