// 문제 번호: 1316
// 문제 제목: 그룹 단어 체커
// 난이도: Silver 5

#include <iostream>
#include <string>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int count = 0;
    bool word = true;
    for (int i = 0; i < n; i++)
    {
        string s;
        cin >> s;
        int j = 0, t = 1;
        char a = s[j];

        for (int j = 0; j < s.length(); j++)
        {
            
            for (int t = j+1; t < s.length(); t++)
            {
                char a = s[j];
                
                if (a == s[t])
                {
                    if (t == j + 1)
                    {
                        j++;
                    }
                    
                    else
                    {
                        word = false;
                        break;
                    }
                }
            }
            
            if (word == false)
            {
                count++;
                word = true;
                break;
            }
        }
    }
    cout << n - count;
}