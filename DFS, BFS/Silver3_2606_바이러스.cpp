// 문제 번호: 2606
// 문제 제목: 바이러스
// 난이도: Silver 3

#include <iostream>
#include <vector>
using namespace std;

bool visited[101];
vector<int> graph[101];

void dfs(int x)
{
    visited[x] = true;
    for (int i = 0; i < graph[x].size(); i++)
    {
        int y = graph[x][i];
        if (!visited[y])
        {
            dfs(y);
        }
    }
}

int main()
{
    int n;
    cin >> n;
    int m;
    cin >> m;
    int count = 0;
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);

    }
    dfs(1);
    for (int i = 1; i <= n; i++)
    {
        if (visited[i])
        {
            count++;
        }
    }
    cout << count - 1;
}