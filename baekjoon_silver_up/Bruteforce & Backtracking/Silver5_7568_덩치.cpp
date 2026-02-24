// 문제 번호: 7568
// 문제 제목: 덩치
// 난이도: Silver 5

#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<pair<int, int>> v;
    int n;
    cin >> n;
    int* rank = new int[n];
    for (int i = 0; i < n; i++)
    {
        int a;
        int b;
        cin >> a >> b;
        v.emplace_back(make_pair(a, b));
        rank[i] = 1;
    }

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
        {
            if (v[i].first < v[j].first && v[i].second < v[j].second)
            {
                rank[i]++;
            }
        }

    for (int i = 0; i < n ; i++)
    {
        cout << rank[i] << ' ';
    }

}