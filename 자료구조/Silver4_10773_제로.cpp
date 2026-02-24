// 문제 번호: 10773
// 문제 제목: 제로
// 난이도: Silver 4

#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int k;
    cin >> k;
    vector<int> v;
    unsigned long long sum = 0;
    for (int i = 0; i < k; i++)
    {
        int num;
        cin >> num;
        if (num == 0)
        {
            v.pop_back();
        }
        else
            v.push_back(num);
    }

    for (int i = 0; i < v.size(); i++)
    {
        sum = sum + v[i];
    }
    cout << sum;
}