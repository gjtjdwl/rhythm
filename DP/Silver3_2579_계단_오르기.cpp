// 문제 번호: 2579
// 문제 제목: 계단 오르기
// 난이도: Silver 3

#include <iostream>
#include <algorithm>
using namespace std;

int stair[301] = { 0, };
int score[301] = { 0, };
int main()
{
    int n;
    cin >> n;
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        cin >> stair[i];
    }
    score[0] = stair[0];
    score[1] = stair[1] + stair[0];
    score[2] = stair[2] + max(stair[0], stair[1]);
    for (int i = 3; i < n; i++)
    {
        score[i] = max(score[i - 2], score[i - 3] + stair[i - 1]) + stair[i];
    }
    cout << score[n - 1];
}