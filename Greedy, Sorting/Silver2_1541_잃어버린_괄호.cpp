// 문제 번호: 1541
// 문제 제목: 잃어버린 괄호
// 난이도: Silver 2

#include <iostream>
#include <vector>
#include<string>
using namespace std;

int main()
{
    int start = 0, len = -1;
    int sum = 0, result = 0;
    bool minus = false;
    vector<int> v;
    string s;
    cin >> s;

    if (s.find("+") == string::npos && s.find("-") == string::npos)
    {
        result = stoi(s);
    }
    else
    {
        for (int i = 0; i < s.size(); i++)
        {
            if (s[i] == '+' || s[i] == '-')
            {
                len = i - (len + 1);
                int sub = stoi(s.substr(start, len));
                start = i + 1;

                if (minus == true)
                {
                    sum = sum + sub;
                }
                else if (minus == false)
                {
                    v.push_back(sub);
                }

                if (s[i] == '-')
                {
                    if (minus == false)
                    {
                        minus = true;
                    }
                }

            }
            if (i == s.size() - 1)
            {
                int sub = stoi(s.substr(start, s.size() - 1));
                if (minus == true)
                {
                    sum = sub + sum;
                    v.push_back(-sum);
                }
                else if (minus == false)
                {
                    v.push_back(-sum);
                    v.push_back(sub);
                }
            }
        }
    }
    for (int i = 0; i < v.size(); i++)
    {
        result = result + v[i];
    }
    cout << result;
}