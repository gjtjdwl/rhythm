// 문제 번호: 15652
// 문제 제목: N과 M (4)
// 난이도: Silver 3

#include <iostream>

using namespace std;
//n H r
void pi(int depth, int n, int m, int arr[], int num)
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

    for (int i = num; i <= n; i++)
    {
        arr[depth] = i;
        pi(depth + 1, n, m, arr, i);
    }
}
int main() 
{
    int n, m;
    cin >> n >> m;
    int arr[8];
    pi(0, n, m, arr, 1);
}
