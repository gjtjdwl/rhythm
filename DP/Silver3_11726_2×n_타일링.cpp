// 문제 번호: 11726
// 문제 제목: 2×n 타일링
// 난이도: Silver 3

#include <iostream>

using namespace std;


int main()
{
    int n;
    cin >> n;
    long long dp[1003] = { 0, };
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    for (int i = 4; i <= n; i++)
    {
        dp[i] = dp[i - 1] + dp[i - 2];
        dp[i] = dp[i] % 10007;
    }
    cout << dp[n];
}