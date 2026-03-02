// 문제 번호: 1049
// 문제 제목: 기타줄
// 난이도: Silver 4

#include <iostream>
using namespace std;

int main()
{
    int n, m;
    cin >> n >> m;
    int min = 0;
    int cpack = 1000, cpiece = 1000;
    for (int i = 0; i < m; i++)
    {
        int pack, piece;
        cin >> pack >> piece;
        if (pack < cpack)
        {
            cpack = pack;
        }
        if (piece < cpiece)
        {
            cpiece = piece;
        }
    }
    int nt = 1;
    if (n > 6)
    {
        nt = n / 6;
    }
    while (n > 0)
    {
        if (n < 6)
        {
            if (cpiece * n < cpack)
            {
                min = min + cpiece * n;
            }
            else
            {
                min = min + cpack;
            }
            n = 0;
        }
        else
        {
            if (cpiece * 6 < cpack)
            {
                min = min + cpiece * 6;
                n = n - 6;
            }
            else
            {
                min = min + cpack;
                n = n - 6;
            }
        }
    }
    cout << min;
}