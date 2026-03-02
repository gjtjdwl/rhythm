// 문제 번호: 1676
// 문제 제목: 팩토리얼 0의 개수
// 난이도: Silver 5

#include <iostream>
using namespace std;
int main()
{
    int n;
    cin >> n;
    int nums[501] = { 0, };
    for (int i = 1; i <= n; i++)
    {
        nums[i] = 1;
    }
    int count = 0;
    for (int i = 1; i < 501; i++)
    {
        if (nums[i] == 0)
        {
            break;
        }
        else if (i % 5 == 0)
        {
            if (i % 125 == 0)
            {
                count += 3;
            }
            else if (i % 25 == 0)
            {
                count += 2;
            }
            else
            {
                count++;
            }
        }
    }
    cout << count;
}
