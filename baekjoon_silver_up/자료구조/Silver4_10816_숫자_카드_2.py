# 문제 번호: 10816
# 문제 제목: 숫자 카드 2
# 난이도: Silver 4

import sys


n = int(sys.stdin.readline())
cards = sys.stdin.readline().split()
m = int(sys.stdin.readline())
checks = sys.stdin.readline().split()

result ={}
for card in cards:
    if card not in result:
        result[card] = 1
    else:
        result[card] += 1
    
for check in checks:
    if check in result:
        print(result[check])
    else:
        print(0)