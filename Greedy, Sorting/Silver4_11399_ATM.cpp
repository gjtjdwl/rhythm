// 문제 번호: 11399
// 문제 제목: ATM
// 난이도: Silver 4

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin >> n;
    vector<int> v;
    int sum = 0, wait = 0;
    for (int i = 0; i < n; i++)
    {
        int num;
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    for (int i = 0; i < v.size(); i++)
    {
        wait = wait + v[i];
        sum = sum + wait;
    }
    cout << sum;
}