// 문제 번호: 1427
// 문제 제목: 소트인사이드
// 난이도: Silver 5

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
    string s;
    cin >> s;
    int* arr = new int[s.length()];
    for (int i = 0; i < s.length(); i++)
    {
        arr[i] = s[i] - '0';
    }
    sort(arr, arr + s.length(),greater<>());
    for (int i = 0; i < s.length(); i++)
    {
        cout << arr[i];
    }
}