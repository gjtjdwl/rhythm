// 문제 번호: 1620
// 문제 제목: 나는야 포켓몬 마스터 이다솜
// 난이도: Silver 4

#include <iostream>
#include <map>
#include <string>
using namespace std;


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    map<int, string> pm1;
    map<string, int> pm2;

    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        string a;
        cin >> a;
        pm1.insert({ i, a });
        pm2.insert({ a, i });
    }

    for (int i = 0; i < m; i++)
    {
        string s;
        cin >> s;
        if (isdigit(s[0]))
        {
            int t = stoi(s);
            cout << pm1[t] << "\n";
        }
        else
        {
            cout << pm2[s] << "\n";
        }
    }
}