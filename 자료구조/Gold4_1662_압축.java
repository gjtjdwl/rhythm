// 문제 번호: 1662
// 문제 제목: 압축
// 난이도: Gold 4

import java.util.*;
import java.io.*;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] zip = br.readLine().toCharArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < zip.length; i++) {
            if (zip[i] == '(') {
                stack.pop();
                stack.push(Character.getNumericValue(zip[i - 1])); // k 넣기
                stack.push(-1);
            } else if (zip[i] == ')') {
                int len = 0;
                while (!stack.isEmpty() && stack.peek() != -1) {
                    len += stack.pop();
                }
                stack.pop(); // ( 제거
                int repeat = stack.pop();
                int subTotal = len * repeat;
                stack.push(subTotal);

            } else{
                stack.push(1);
            }
        }
        
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        System.out.println(result);
    }
}