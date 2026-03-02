// 문제 번호: 2563
// 문제 제목: 색종이
// 난이도: Silver 5

#include <iostream>
using namespace std;
int main()
{
    int paper[100][100] = { 0, };
    int n;
    int x, y;
    int count = 0;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> x >> y;
        for (int j = x; j < x + 10; j++)
        {
            for (int k = y; k < y + 10; k++)
            {
                if (paper[j][k] == 1)
                    continue;
                paper[j][k] = 1;
                count++;
            }
        }
    }
    cout << count;
}
