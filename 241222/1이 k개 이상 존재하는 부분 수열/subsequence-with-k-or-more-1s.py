#n : 수열의 길이, # k : 부분 수열 내 1의 개수
n, k = list(map(int, input().split()))
arr = list(map(int, input().split()))

#없으면 -1 출력

count = 0 # count : 포함된 1의 개수
j = 0
ans = n + 1

for i in range(n):

    if arr[i] != 1:
        continue

    while j <= n - 1 and count < k:

        if arr[j] == 1:
            count += 1

        j += 1

    if count == k:
        ans = min(ans, j - i)
        count -= 1

if ans == n + 1:
    print(-1)
else:
    print(ans)