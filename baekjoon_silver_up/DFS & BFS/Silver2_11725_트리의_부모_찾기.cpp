// 문제 번호: 11725
// 문제 제목: 트리의 부모 찾기
// 난이도: Silver 2

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> tree[100001];
bool visited[100001] = { false, };
int parent[100001] = { 0, };

void search(int child,int p)
{
    if (visited[child] == false)
    {
        visited[child] = true;
        parent[child] = p;
    }
    for (int i = 0; i < tree[child].size(); i++)
    {
        int t = tree[child][i];
        if (!visited[t])
        {
            search(t,child);
        }
    }
}

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n - 1; i++)
    {
        int a, b;
        cin >> a >> b;
        tree[a].push_back(b);
        tree[b].push_back(a);
    }
    search(1,1);
    
    for (int i = 2; i <= n; i++)
    {
        cout << parent[i] << "\n";
    }
}