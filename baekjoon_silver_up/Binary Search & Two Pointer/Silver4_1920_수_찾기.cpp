// 문제 번호: 1920
// 문제 제목: 수 찾기
// 난이도: Silver 4

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int n, m;
    vector<long long> a;
    vector<long long> x;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        long long num;
        cin >> num;
        a.push_back(num);
    }
    cin >> m;
    sort(a.begin(), a.end());
    for (int i = 0; i < m; i++)
    {
        long long num;
        cin >> num;
        x.push_back(num);
    }
    for (int i = 0; i < m; i++)
    {
        cout << binary_search(a.begin(), a.end(), x[i]) << "\n";
    }
}