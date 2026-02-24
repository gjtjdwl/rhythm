// 문제 번호: 10828
// 문제 제목: 스택
// 난이도: Silver 4

#include <iostream>
#include <string>
using namespace std;

class stack {
private:
    int st[10000] = { 0, };
    int t = -1;
public:
    void push(int a);
    void pop();
    void size();
    void empty();
    void top();
};

void stack::push(int a)
{
    st[++t] = a;
}

void stack::pop()
{
    if (t < 0)
    {
        cout << -1 << "\n";
    }
    else
        cout << st[t--] << "\n";
}

void stack::size()
{
    if (t < 0)
    {
        cout << 0 << "\n";
    }
    else
        cout << t + 1 << "\n";
}
void stack::empty()
{
    if (t < 0)
    {
        cout << 1 << "\n";
    }
    else
        cout << 0 << "\n";
}
void stack::top()
{
    if (t < 0)
    {
        cout << -1 << "\n";
    }
    else
        cout << st[t] << "\n";
}
int main()
{
    int n;
    cin >> n;
    cin.ignore();
    string s;
    stack t;
    for (int i = 0; i < n; i++)
    {
        getline(cin, s);
        if (s.find("push") != string::npos)
        {
            string s1 = s.substr(5);
            int a = stoi(s1);
            t.push(a);
        }
        if (s.find("pop") != string::npos)
        {
            t.pop();
        }
        if (s.find("size") != string::npos)
        {
            t.size();
        }
        if (s.find("empty") != string::npos)
        {
            t.empty();
        }
        if (s.find("top") != string::npos)
        {
            t.top();
        }
    }
}