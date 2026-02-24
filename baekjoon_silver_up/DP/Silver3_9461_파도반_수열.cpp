// 문제 번호: 9461
// 문제 제목: 파도반 수열
// 난이도: Silver 3

#include <iostream>

using namespace std;


int main()
{
    int t;
    cin >> t;
    long long dp[101] = { 0, };
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;
    dp[4] = 2;
    dp[5] = 2;
    for (int k = 0; k < t; k++)
    {
        int n;
        cin >> n;
        for (int i = 6; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
        cout << dp[n] << "\n";
    }
}