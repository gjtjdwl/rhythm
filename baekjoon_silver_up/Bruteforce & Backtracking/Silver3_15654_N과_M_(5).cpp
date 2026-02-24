// 문제 번호: 15654
// 문제 제목: N과 M (5)
// 난이도: Silver 3

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int main()
{
    int n, m;
    cin >> n >> m;
    vector<int> v;
    for (int i = 1; i <= n; i++)
    {
        int num;
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    do {
        for (int i = 0; i < m; i++)
        {
            {
                cout << v[i] << " ";
            }
        }
        cout << "\n";
        reverse(v.begin() + m, v.end());
    } while (next_permutation(v.begin(), v.end()));
}

