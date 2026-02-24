// 문제 번호: 1158
// 문제 제목: 요세푸스 문제
// 난이도: Silver 4

#include <iostream>
#include <queue>
using namespace std;

int main()
{
    int n, k;
    int count = 0;
    cin >> n >> k;
    queue <int> q;
    for (int i = 0; i < n; i++) {
        q.push(i+1);
    }
    cout << "<";
    while (!q.empty())
    {
        count++;
        if (count == k)
        {
            if (q.size() == 1)
            {
                cout << q.front();
            }
            else
            {
                cout << q.front() << ", ";
            }
            q.pop();
            count = 0;
            continue;
        }
        q.push(q.front());
        q.pop();
    }
    cout << ">";
}
