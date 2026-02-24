// 문제 번호: 1003
// 문제 제목: 피보나치 함수
// 난이도: Silver 3

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int t;
    int n;
    cin >> t;
    for (int i = 0; i < t; i++)
    {
        cin >> n;
        vector<pair<int, int>> v;
        v.push_back(make_pair(1, 0));
        v.push_back(make_pair(0, 1));
        if (n != 0 && n != 1)
        {
            for (int i = 0; i < n - 1; i++)
            {
                int zero = v[i].first + v[i + 1].first;
                int one = v[i].second + v[i + 1].second;
                v.push_back(make_pair(zero, one));
            }
        }
        cout << v[n].first << ' ' << v[n].second << "\n";

    }
    
}