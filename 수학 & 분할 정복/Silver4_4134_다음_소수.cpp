// 문제 번호: 4134
// 문제 제목: 다음 소수
// 난이도: Silver 4

#include <iostream>
#include <cmath>
using namespace std;

bool prime(long long num)
{
    if (num == 0 || num == 1)
    {
        return false;
    }
    if (num == 2 || num == 3)
    {
        return true;
    }
    for (long long i = 2; i <= sqrt(num); i++)
    {
        if (num % i == 0)
        {
            return false;
        }
    }

    return true;
}
int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        long long num;
        cin >> num;
        while (!prime(num))
        {
            num++;
        }
        cout << num << "\n";
    }
}