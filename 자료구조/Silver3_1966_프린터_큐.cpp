// 문제 번호: 1966
// 문제 제목: 프린터 큐
// 난이도: Silver 3

#include <iostream>
#include <vector>
using namespace std;
int main()
{
    int t;
    cin >> t;
    for (int k = 0; k < t; k++)
    {
        int n, m;
        cin >> n >> m;
        int count = 0;
        vector <pair<int, int>> v;
        for (int i = 0; i < n; i++)
        {
            int a;
            cin >> a;
            v.push_back(make_pair(i, a));
        }

        while (true)
        {
            for (int i = 1; i < v.size(); i++)
            {
                if (v[0].second < v[i].second)
                {
                    v.push_back(v[0]);
                    v.erase(v.begin());
                    i = 0;
                }
            }
            if (v[0].first == m)
            {
                count++;
                cout << count << "\n";
                break;
            }
            else
            {
                v.erase(v.begin());
                count++;
            }
        }
    }
}