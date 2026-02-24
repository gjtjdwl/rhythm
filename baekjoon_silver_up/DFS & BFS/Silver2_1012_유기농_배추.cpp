// 문제 번호: 1012
// 문제 제목: 유기농 배추
// 난이도: Silver 2

#include <iostream>
#include <vector>
using namespace std;

int m, n, k;

void DFS(int i, int j, int arr[][51], bool visited[][51])
{
    if (arr[i + 1][j] == 1 && !visited[i + 1][j] && (i + 1) < n)
    {
        visited[i + 1][j] = true;
        DFS(i + 1, j, arr, visited);
    }
    if (arr[i][j + 1] == 1 && !visited[i][j + 1] && (j + 1) < m)
    {
        visited[i][j + 1] = true;
        DFS(i, j + 1, arr, visited);
    }

    if (arr[i - 1][j] == 1 && !visited[i - 1][j] && (i - 1) >= 0)
    {
        visited[i - 1][j] = true;
        DFS(i - 1, j, arr, visited);
    }
    if (arr[i][j - 1] == 1 && !visited[i][j - 1] && (j - 1) >= 0)
    {
        visited[i][j - 1] = true;
        DFS(i, j - 1, arr, visited);
    }
}

int main()
{
    int t;
    cin >> t;
    for (int i = 0; i < t; i++)
    {
        int count = 0;
        int arr[51][51] = { 0, };
        bool visited[51][51] = { false, };
        cin >> m >> n >> k;
        for (int i = 0; i < k; i++)
        {
            int a, b;
            cin >> a >> b;
            arr[b][a] = 1;
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (arr[i][j] == 1 && visited[i][j] == false)
                {
                    visited[i][j] = true;
                    DFS(i, j, arr, visited);
                    count++;
                }
            }
        }
        cout << count << '\n';
    }
}