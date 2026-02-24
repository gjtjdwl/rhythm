// 문제 번호: 9012
// 문제 제목: 괄호
// 난이도: Silver 4

#include <iostream>
#include <stack>
using namespace std;

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        string s;
        stack<char> vps;
        bool check = false;

        cin >> s;
        for (int j = 0; j < s.length(); j++)
        {
            if (s[j] == '(')
            {
                vps.push(s[j]);
            }
            if (s[j] == ')')
            {
                if (!vps.empty())
                {
                    vps.pop();
                }
                else
                {
                    cout << "NO" << "\n";
                    check = true;
                    break;
                }
            }
        }
        if (check)
        {
            continue;
        }
        if (vps.empty())
        {
            cout << "YES" << "\n";
        }
        else 
        {
            cout << "NO" << "\n";
        }
    }
}