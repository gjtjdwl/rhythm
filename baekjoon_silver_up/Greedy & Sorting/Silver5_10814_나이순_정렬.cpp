// 문제 번호: 10814
// 문제 제목: 나이순 정렬
// 난이도: Silver 5

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(pair<int, string> a, pair<int, string> b) {

    return a.first < b.first;
}

int main()
{
    vector<pair<int, string>> v;
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int a;
        string b;
        cin >> a >> b;
        v.emplace_back(make_pair(a, b));
    }
    stable_sort(v.begin(), v.end(),compare);

    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i].first << " " << v[i].second << "\n";
    }
}