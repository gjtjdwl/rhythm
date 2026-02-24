// 문제 번호: 2805
// 문제 제목: 나무 자르기
// 난이도: Silver 2

#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    long long n, m;
    long long max;
    int tree[1000001];

    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        cin >> tree[i];
    }
    sort(tree, tree + n + 1);

    long long left = 0;
    long long right = tree[n];

    while (left <= right)
    {
        long long sum = 0;
        long long middle = (left + right) / 2;
        for (int i = 1; i <= n; i++)
        {
            if (tree[i] - middle > 0)
            {
                sum = sum + tree[i] - middle;
            }
        }
        if (sum < m)
        {
            right = middle - 1;
        }
        else if (sum >= m)
        {
            max = middle;
            left = middle + 1;
        }
    }
    cout << max;
}