// 문제 번호: 1436
// 문제 제목: 영화감독 숌
// 난이도: Silver 5

#include <iostream>
#include <string>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int t = 666;
    int count = 0;
    string s;
    while (true)
    {
        s = to_string(t);
        if (s.find("666") != string::npos)
        {
            count++;
            if (count == n)
            {
                cout << t;
                break;
            }
        }
        t++;
    }
}