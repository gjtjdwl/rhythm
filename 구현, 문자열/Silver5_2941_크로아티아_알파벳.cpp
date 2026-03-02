// 문제 번호: 2941
// 문제 제목: 크로아티아 알파벳
// 난이도: Silver 5

#include <iostream>
#include <string>
using namespace std;

int main()
{
    string s;
    int count = 0;
    cin >> s;
    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] == 'c')
        {
            if (s[i + 1] == '=' || s[i + 1] == '-')
            {

                i = i + 1;
            }
        }
        else if (s[i] == 'd')
        {
            if (s[i + 1] == '-')
            {
                i = i + 1;
            }
            else if (s[i + 1] == 'z'&& s[i + 2] == '=')
            {   
                i = i + 2;
            }
        }
        else if (s[i] == 'l')
        {
            if (s[i + 1] == 'j')
            {
                i = i + 1;
            }
        }
        else if (s[i] == 'n')
        {
            if (s[i + 1] == 'j')
            {
                i = i + 1;
            }
        }
        else if (s[i] == 's')
        {
            if (s[i + 1] == '=')
            {
                i = i + 1;
            }
        }
        else if (s[i] == 'z') 
        {
            if (s[i + 1] == '=')
            {
                i = i + 1;
            }
        }
        count++;

    }
    cout << count;
}