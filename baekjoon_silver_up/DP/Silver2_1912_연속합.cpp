// 문제 번호: 1912
// 문제 제목: 연속합
// 난이도: Silver 2

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int dp[100000] = { 0, };

int main()
{
    int n;
    vector<int> v;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int a;
        cin >> a;
        v.push_back(a);
    }
    dp[0] = v[0];
    int m = dp[0];
    for (int i = 1; i < v.size(); i++)
    {
        dp[i] = max(dp[i - 1] + v[i], v[i]);
        if (m < dp[i])
        {
            m = dp[i];
        }
    }
    cout << m;
}