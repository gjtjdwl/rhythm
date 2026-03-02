# 문제 번호: 2343
# 문제 제목: 기타 레슨
# 난이도: Gold 5

n,m = map(int, input().split())
arr = list(map(int,input().split()))


low = max(arr)
high = sum(arr)

while(low <= high):
    mid = (low + high) // 2
    sum = 0
    tape = 1
    for i in range(n):
        if sum + arr[i] > mid:
            tape += 1
            sum = 0
        sum = sum + arr[i]

    if(tape <= m):
        high = mid -1
    else:
        low = mid + 1
    
print(low)