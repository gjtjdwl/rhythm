// 문제 번호: 11279
// 문제 제목: 최대 힙
// 난이도: Silver 2

#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int main()
{
    priority_queue<int> pq;
    
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int t;
        cin >> t;
        if (t == 0)
        {
            if (!pq.empty())
            {
                cout << pq.top() << "\n";
                pq.pop();
            }
            else
            {
                cout << 0 << "\n";
            }
        }
        else 
        {
            pq.push(t);
        }
    }
}