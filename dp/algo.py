def minimumTotal(self, triangle):
    if not triangle: return 0
    res = triangle[-1]
    for i in xrange(len(triangle)-2,-1,-1):
        for j in xrange(len(triangle[i])):
            res[j] = min(res[j], res[j+1]) + triangle[i][j]
    return res[0]

def maxProduct(self, nums):
    if nums is None: return 0
    dp = [[0 for _ in range(2)] for _ in range(2)]
    dp[0][1], dp[0][0], res = nums[0], nums[0], nums[0]
    for i in range(1, len(nums)):
        x, y = i%2, (i-1)%2
        dp[x][0] = max(dp[y][0] * nums[i], dp[y][1] * nums[i], nums[i])
        dp[x][1] = min(dp[y][0] * nums[i], dp[y][1] * nums[i], nums[i])
        res = max(res, dp[x][0])
    return res

def lengthOfLIS(self, nums):
    if not nums: return 0
    res = 1
    dp = [1 for _ in range(len(nums))]
    for i in range(1, len(nums)):
        for j in range(0, i):
            if nums[j] < nums[i]:
                dp[i] = max(dp[i], dp[j] + 1)
        res = max(res, dp[i])
    return res