// 문제 번호: 15650
// 문제 제목: N과 M (2)
// 난이도: Silver 3

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int n, m;
    vector<int> v;
    vector<int> b;
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        v.push_back(i + 1);
        b.push_back(1);
    }
    for (int i = 0; i < m; i++)
    {
        b[i] = 0;
    }
    do
    {
        for (int i = 0; i < b.size(); i++)
        {
            if (b[i] == 0)
            {
                cout << b[i] + v[i] << ' ';
            }
        }
        cout << '\n';

    } while (next_permutation(b.begin(), b.end()));
}