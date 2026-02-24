# 문제 번호: 2164
# 문제 제목: 카드2
# 난이도: Silver 4

from collections import deque
import sys

cards = deque()
n = int(sys.stdin.readline())
for i in range(n):
    cards.append(i+1)
if len(cards) > 1:
    while len(cards) > 1:
        cards.popleft()
        a = cards.popleft()
        cards.append(a)

card = cards.pop()
print(card)