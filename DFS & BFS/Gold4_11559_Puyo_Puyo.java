// 문제 번호: 11559
// 문제 제목: Puyo Puyo
// 난이도: Gold 4

import java.io.*;
import java.util.*;

public class Main {
  static char[][] puyo;
  static int[] di = { 0, -1, 0, 1 };
  static int[] dj = { 1, 0, -1, 0 };
  static boolean[][] v;
  static int cnt;
  static List<int[]> candy;

  static void dfs(int i, int j, char color) {
    v[i][j] = true;
    candy.add(new int[] { i, j });
    for (int d = 0; d < 4; d++) {
      int ni = i + di[d];
      int nj = j + dj[d];
      if (ni >= 0 && nj >= 0 && ni < 12 && nj < 6 && !v[ni][nj]) {
        if (color == puyo[ni][nj]) {
          cnt++;
          dfs(ni, nj, color);
        }
      }
    }
  }

  static void drop() {
    for (int j = 0; j < 6; j++) {
      for (int i = 10; i >= 0; i--) {
        int t = i;
        while (t < 11) {
          if (puyo[t][j] != '.' && puyo[t + 1][j] == '.') {
            puyo[t + 1][j] = puyo[t][j];
            puyo[t][j] = '.';
          }
          t++;
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int ans = 0;
    puyo = new char[12][6];
    for (int i = 0; i < 12; i++) {
      String line = br.readLine();
      for (int j = 0; j < 6; j++) {
        puyo[i][j] = line.charAt(j);
      }
    }
    boolean isBoom = true;
    while (isBoom) {
      isBoom = false;

      for (int i = 11; i >= 0; i--) {
        for (int j = 0; j < 6; j++) {
          if (puyo[i][j] != '.') {
            cnt = 1;
            candy = new ArrayList<>();
            v = new boolean[12][6];
            dfs(i, j, puyo[i][j]);
            if (cnt >= 4) {
              isBoom = true;
              for (int t = 0; t < candy.size(); t++) {
                int a = candy.get(t)[0];
                int b = candy.get(t)[1];
                puyo[a][b] = '.';
              }
            }
          }
        }
      }
      ans++;
      drop();
    }
    System.out.println(ans - 1);
  }
}