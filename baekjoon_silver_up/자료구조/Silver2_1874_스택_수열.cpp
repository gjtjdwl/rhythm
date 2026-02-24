// 문제 번호: 1874
// 문제 제목: 스택 수열
// 난이도: Silver 2

#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main()
{
    int n;
    cin >> n;
    stack <int> s;
    vector <int> v;
    vector <char> stacking;
    for (int i = 0; i < n; i++)
    {
        int a;
        cin >> a;
        v.push_back(a);
    }
    int t = 1;
    s.push(t);
    stacking.push_back('+');
    while (true)
    {
        if (!s.empty() && v.front() == s.top())
        {
            s.pop();
            v.erase(v.begin());
            stacking.push_back('-');
        }
        else if (t <= n)
        {
            t++;
            s.push(t);
            stacking.push_back('+');
        }
        else if (t > n)
        {
            cout << "NO";
            break;
        }

        if (v.empty())
        {
            break;
        }
    }
    if (v.empty())
    {
        for (int i = 0; i < stacking.size(); i++)
        {
            cout << stacking[i] << '\n';
        }
    }
}