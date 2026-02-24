// 문제 번호: 1018
// 문제 제목: 체스판 다시 칠하기
// 난이도: Silver 3

#include <iostream>
using namespace std;

char black[8][8] = { 
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'} };

char white[8][8] = {
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'} };

char chess[50][50] = { 0, };

int checkB(int a, int b) // a,b는 시작 지점
{
    int count = 0;
    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j < 8; j++)
        {
            if (chess[a + i][b + j] != black[i][j])
            {
                count++;
            }
        }
    }
    return count;
}
int checkW(int a, int b)
{
    int count = 0;
    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j < 8; j++)
        {
            if (chess[a + i][b + j] != white[i][j])
            {
                count++;
            }
        }
    }
    return count;
}

int main()
{
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> chess[i][j];
        }
    }
    int count = 0;
    int countB = 80;
    int countW = 80;
    for (int i = 0; i < n - 7; i++)
    {
        for (int j = 0; j < m - 7; j++)
        {
            count = checkB(i, j);
            if (count < countB)
            {
                countB = count;
            }
            count = checkW(i, j);
            if (count < countW)
            {
                countW = count;
            }
        }
    }
    int min;
    if (countB < countW)
    {
        min = countB;
    }
    else
    {
        min = countW;
    }
    cout << min;
}
