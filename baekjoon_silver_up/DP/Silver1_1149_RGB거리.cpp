// 문제 번호: 1149
// 문제 제목: RGB거리
// 난이도: Silver 1

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> v[1001];
int dp[1001][3];

int main()
{
    int n;
    cin >> n;
    int cost = 0;
    for (int i = 1; i <= n; i++)
    {
        int r, g, b;
        cin >> r >> g >> b;
        v[i].push_back(r);
        v[i].push_back(g);
        v[i].push_back(b);
    }
    dp[1][0] = v[1][0];
    dp[1][1] = v[1][1];
    dp[1][2] = v[1][2];
    for (int i = 2; i <= n; i++)
    {
        // 이전 값이 r이 아닌 경우의 min 값 + 현재 r값
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + v[i][0];
        // 이전값이 g가 아닌 경우의 min값 + 현재 g값
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + v[i][1];
        // 이전값이 b가 아닌 경우의 min값 + 현재 b값
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + v[i][2];

    }
    cost = min(dp[n][0] ,min (dp[n][1], dp[n][2]));
    cout << cost;
}