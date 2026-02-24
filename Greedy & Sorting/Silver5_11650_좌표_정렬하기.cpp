// 문제 번호: 11650
// 문제 제목: 좌표 정렬하기
// 난이도: Silver 5

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int x, y;
    vector<pair<int,int>> v;
    for (int i = 0; i < n; i++)
    {
        cin >> x >> y;
        v.emplace_back(make_pair(x, y));
    }

    sort(v.begin(), v.end());

    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i].first << " " << v[i].second << "\n";
    }
}