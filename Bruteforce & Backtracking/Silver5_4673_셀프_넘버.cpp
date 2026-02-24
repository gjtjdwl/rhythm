// 문제 번호: 4673
// 문제 제목: 셀프 넘버
// 난이도: Silver 5

#include <iostream>
using namespace std;

int main()
{
    int a = 1, b = 1, c = 1, d = 1;
    int arr[10000] = { 0, };
    //한 자리 일 때
    int dn;
    for (; d < 10; d++)
    {
        dn = d + d;
        arr[dn] = 1;
    }
    //두 자리 일 때
    d = 0;
    int n = 10 * c + d;
    for (; n < 100; n++)
    {
        c = n / 10;
        d = n - 10 * c;
        dn = n + c + d;
        arr[dn] = 1;
    }
    //세 자리 일 때
    c = 0;
    d = 0;
    n = 100 * b + 10 * c + d;
    for (; n < 1000; n++)
    {
        b = n / 100;
        c = (n - 100 * b) / 10;
        d = n - (100 * b) - (10 * c);
        dn = n + b + c + d;
        arr[dn] = 1;
    }
    //네 자리 일 때
    b = 0;
    c = 0;
    d = 0;
    n = a * 1000 + 100 * b + 10 * c + d;
    for (; n < 10000; n++)
    {
        a = n / 1000;
        b = (n - 1000 * a) / 100;
        c = (n - 1000 * a - 100 * b) / 10;
        d = n - 1000 * a - 100 * b - 10 * c;
        dn = n + a + b + c + d;
        if (dn < 10000)
            arr[dn] = 1;
    }
    for (int i = 1; i < 10000; i++)
    {
        if (arr[i] == 0)
            cout << i << "\n";
    }
}