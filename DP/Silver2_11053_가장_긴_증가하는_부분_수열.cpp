// 문제 번호: 11053
// 문제 제목: 가장 긴 증가하는 부분 수열
// 난이도: Silver 2

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int dp[1001] = { 0, };


int main()
{
    int n;
    cin >> n;
    vector <int> a;
    int large = 0;
    for (int i = 0; i < n; i++)
    {
        int ai;
        cin >> ai;
        a.push_back(ai);
    }
    for (int i = 1; i < a.size(); i++)
    {
        for (int j = 0; j < i; j++)
        {
            if (a[i] > a[j])
            {
                dp[i] = max(dp[i], dp[j] + 1);
                if (dp[i] > large)
                {
                    large = dp[i];
                }
            }
        }
    }
    cout << large + 1;
}

