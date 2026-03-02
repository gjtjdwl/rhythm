// 문제 번호: 1193
// 문제 제목: 분수찾기
// 난이도: Silver 5

#include <iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int sum = 0;
    int i = 1;
    int za, mo;
    do
    {
        sum = sum + i;
        i++;
    } while (n > sum);
    i = i - 1;
    int a = sum - n;
    if (i % 2 == 0)
    {
        za = i - a;
        mo = 1 + a;
        
    }
    else
    {
        za = 1 + a;
        mo = i - a;
    }
    cout << za << "/" << mo;
}