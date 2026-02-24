// 문제 번호: 11866
// 문제 제목: 요세푸스 문제 0
// 난이도: Silver 4

#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int n, k;
    cin >> n >> k;
    vector<int> v;

    for (int i = 0; i < n; i++)
    {
        v.push_back(i + 1);
    }
    cout << "<";
    while (!v.empty())
    {
        for (int i = 1; i < k; i++)
        {
            v.push_back(v.front());
            v.erase(v.begin());
        }
        if (v.size() != 1)
        {
            cout << v.front() << ", ";
            v.erase(v.begin());
        }
        else
        {
            cout << v.front();
            v.erase(v.begin());
        }
    }
    cout << ">";
}