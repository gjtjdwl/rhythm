// 문제 번호: 1026
// 문제 제목: 보물
// 난이도: Silver 4

#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int* a = new int[n];
    int* b = new int[n];
    int s = 0;
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    for (int i = 0; i < n; i++)
    {
        cin >> b[i];
    }
    sort(a, a + n);
    sort(b, b + n, greater<>());
    for (int i = 0; i < n; i++)
    {
        s = s + a[i] * b[i];
    }
    cout << s;
}