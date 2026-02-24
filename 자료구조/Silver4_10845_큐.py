# 문제 번호: 10845
# 문제 제목: 큐
# 난이도: Silver 4

from collections import deque
import sys

n = int(sys.stdin.readline())
insts = [sys.stdin.readline().strip() for _ in range(n)]
q = deque()
for inst in insts:
    if inst == 'pop':
        if len(q) == 0:
            print(-1)
        else:
            out = q.popleft()
            print(out)
            
    elif inst == 'size':
        print(len(q))
    
    elif inst == 'empty':
        if len(q) == 0:
            print(1)
        else:
            print(0)
            
    elif inst == 'front':
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])
            
    elif inst == 'back':
        if len(q) == 0:
            print(-1)
        else:
            print(q[-1])
    
    elif inst[0:4] == 'push':
        q.append(int(inst[5:]))