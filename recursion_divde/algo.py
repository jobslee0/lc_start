def myPow(self, x, n):
    if not n:
        return 1
    if n < 0:
        return 1 / self.myPow(x, -n)
    if n % 2:
        return x * self.myPow(x, n-1)
    return self.myPow(x*x, n/2)

def myPow(self, x, n):
    if n < 0:
        x = 1/x
        n = -n
    pow = 1
    while n:
        if n&1:
            pow *= x
        x *= x
        n >> 1
    return pow

def majorityElement(self, nums):
    return self.count(nums, 0, len(nums) - 1)
def count(self, nums, left, right):
    if left == right:
        return nums[left]
    mid = (left + right) // 2
    leftM = self.count(nums, left, mid)
    rightM = self.count(nums, mid+1, right)
    if leftM == rightM:
        return leftM
    leftCount = sum(1 for i in range(left, right + 1) if nums[i] == leftM)
    rightCount = sum(1 for i in range(left, right + 1) if nums[i] == rightM)
    return leftM if leftCount > rightCount else rightM
