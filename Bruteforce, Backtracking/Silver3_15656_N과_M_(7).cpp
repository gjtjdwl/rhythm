// 문제 번호: 15656
// 문제 제목: N과 M (7)
// 난이도: Silver 3

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int arr[8] = { 0, };
vector<int> v;

void combination(int depth, int n, int r, int idx) 
{
    if (depth == r) {
        for (int i = 0; i < r; i++)
        {
            cout << v[i] << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = 0; i < n; i++)
    {
        v.push_back(arr[i]);
        combination(depth + 1, n, r, i);
        v.pop_back();
    }
}

int main(void) {
    int n, r;
    cin >> n >> r;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    sort(arr, arr + n);

    combination(0, n, r, -1);

    return 0;
}