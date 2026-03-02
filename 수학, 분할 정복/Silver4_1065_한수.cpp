// 문제 번호: 1065
// 문제 제목: 한수
// 난이도: Silver 4

#include <iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int count = 0;
    for (int i = 1; i <= n; i++)
    {
        if (i < 100)
        {
            count++;
        }
        else if (100 <= i && i < 1000)
        {
            int t = i;
            int c = t % 10;
            t = t / 10;
            int b = t % 10;
            t = t / 10;
            int a = t % 10;
            if (a - b == b - c)
            {
                count++;
            }
        }
    }
    cout << count;
}