// 문제 번호: 9095
// 문제 제목: 1, 2, 3 더하기
// 난이도: Silver 3

#include <iostream>
using namespace std;

int main()
{
    int t;
    int n;
    cin >> t;
    for (int i = 0; i < t; i++)
    {
        int DP[12] = { 0, };
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;
        cin >> n;
        for (int i = 1; i <= n - 3; i++)
        {
            DP[i + 3] = DP[i + 2] + DP[i + 1] + DP[i];
        }
        cout << DP[n] << "\n";

    }
    
}