// 문제 번호: 4948
// 문제 제목: 베르트랑 공준
// 난이도: Silver 2

#include <iostream>
#include <cmath>
using namespace std;


int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int n;
    while (true)
    {
        cin >> n;
        int count = 0;
        int nums[246913] = { 0, };

        if (n == 0)
            break;

        for (int i = 2; i <= sqrt(2 * n); i++)
        {
            if (nums[i] == 0)
            {
                for (int j = 2; i * j <= 2 * n; j++)
                {
                    nums[i * j] = 1;
                }
            }
        }
        for (int i = n + 1; i <= 2 * n; i++)
        {
            if (nums[i] == 0)
            {
                count++;
            }
        }
        cout << count << "\n";
    }
}