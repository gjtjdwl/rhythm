// 문제 번호: 1010
// 문제 제목: 다리 놓기
// 난이도: Silver 5

#include <iostream>
using namespace std;

int main()
{
    int t;
    cin >> t;
    for (int i = 0; i < t; i++)
    {
        long long r, n;
        long long bridge = 1;
        cin >> r >> n;
        for (int i = 0; i < r; i++)
        {
            bridge = bridge * (n - i);
            bridge = bridge / (1 + i);
        }

        cout << bridge << "\n";
    }
}
