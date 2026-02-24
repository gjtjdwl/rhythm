// 문제 번호: 15651
// 문제 제목: N과 M (3)
// 난이도: Silver 3

#include <iostream>

using namespace std;
//n II r
void pi(int depth, int n, int m, int arr[])
{
    if (depth == m)
    {
        for (int i = 0; i < m; i++)
        {
            cout << arr[i] << ' ';
        }
        cout << "\n";
        return;
    }

    for (int i = 1; i <= n; i++)
    {
        arr[depth] = i;
        pi(depth + 1, n, m, arr);
    }
}
int main() 
{
    int n, m;
    cin >> n >> m;
    int arr[8];
    pi(0, n, m, arr);
}
