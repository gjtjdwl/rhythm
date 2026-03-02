// 문제 번호: 2751
// 문제 제목: 수 정렬하기 2
// 난이도: Silver 5

#include <iostream>
#include <list>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int r;
    list<int>num;
    list<int> ::iterator it;
    for (int i = 0; i < n; i++)
    {
        int t;
        cin >> t;
        num.emplace_back(t);
    }
    num.sort();

    for (it = num.begin(); it != num.end(); it++)
    {
        cout << *it << "\n";
    }
}