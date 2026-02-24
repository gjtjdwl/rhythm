// 문제 번호: 1260
// 문제 제목: DFS와 BFS
// 난이도: Silver 2

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

vector<int> G[1001];
bool visited_D[1001];
bool visited_B[1001];

void DFS(int v)
{
    visited_D[v] = true;
    cout << v << ' ';
    for (int i = 0; i < G[v].size(); i++)
    {
        int t = G[v][i];
        if (!visited_D[t])
        {
            DFS(t);
        }
    }
}

void BFS(int v)
{
    queue<int> q;
    visited_B[v] = true;
    q.push(v);

    while (!q.empty())
    {
        int t = q.front();
        q.pop();
        cout << t << ' ';
        for (int i = 0; i < G[t].size(); i++)
        {
            int u = G[t][i];
            if (!visited_B[u])
            {
                q.push(u);
                visited_B[u] = true;
            }
        }
    }
}
int main()
{
    int n, m, v;
    cin >> n >> m >> v;
    for (int i = 1; i <= m; i++)
    {
        int a, b;
        cin >> a >> b;
        G[a].push_back(b);
        G[b].push_back(a);
    }
    for (int i = 0; i < n; i++)
    {
        sort(G[i + 1].begin(), G[i + 1].end());
    }
    DFS(v);
    cout << "\n";
    BFS(v);
}