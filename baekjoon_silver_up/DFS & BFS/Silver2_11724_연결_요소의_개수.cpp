// 문제 번호: 11724
// 문제 제목: 연결 요소의 개수
// 난이도: Silver 2

#include <iostream>
#include <vector>
using namespace std;

vector<int> graph[1001];
bool visited[1001];
int connect = 0;

void dfs(int n)
{
    visited[n] = true;

    for (int i = 0; i < graph[n].size(); i++)
    {
        int t = graph[n][i];
        if (!visited[t])
        {
            visited[t] = true;
            dfs(t);
        }
    }
}

void start_dfs(int n)
{
    if (!visited[n])
    {
        visited[n] = true;
        connect++;

        for (int i = 0; i < graph[n].size(); i++)
        {
            int t = graph[n][i];
            if (!visited[t])
            {
                visited[t] = true;
                dfs(t);
            }
        }
    }
}



int main()
{
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
    for (int i = 1; i <= n; i++)
    {
        start_dfs(i);
    }
    cout << connect;
}

