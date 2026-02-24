// 문제 번호: 1181
// 문제 제목: 단어 정렬
// 난이도: Silver 5

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin >> n;
    string word;
    vector<string> wlist;
    vector<string> w;
    for (int i = 0; i < n; i++)
    {
        cin >> word;
        auto it = find(wlist.begin(), wlist.end(), word);
        if (it != wlist.end())
        {
            continue;
        }
        else
        {
            wlist.emplace_back(word);
        }
    }

    sort(wlist.begin(), wlist.end());

    for (int i = 1; i <= 50; i++)
    {
        for (int j = 0; j < wlist.size(); j++)
        {
            if (wlist[j].length() == i)
            {
                w.emplace_back(wlist[j]);
            }
        }
    }
    for (const auto &item : w)
    {
        cout << item << "\n";
    }
}