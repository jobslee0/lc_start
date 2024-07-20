def maxSlidingWindow(self, nums, k):
    res = []
    if not nums:
        return res
    # indexDueue为双端队列，算法主要通过维护这个队列完成
    indexDueue = []
    for i,x in enumerate(nums):
        # 当从k下标开始，对队列头部的坐标进行移出判断
        if i >= k and indexDueue[0] <= i - k:
            indexDueue.pop(0)
        # 对nums数组的遍历过程中，i变量相当于滑动窗口的最右端下标
        # 最右端元素若大于队列尾部对应的元素，则出队列，保证了队列中的最大值下标
        while indexDueue and nums[indexDueue[-1]] <= x:
            indexDueue.pop()
        # 加入当前元素下标
        indexDueue.append(i)
        # 每次从k坐标开始输出当前窗口最大值结果
        if i >= k - 1:
            # 为什么返回是第0个元素？
            # 假设数组有某段递增[1,2,3]，最终队列中保留的是3的索引
            # 数组有某段递减[3,2,1]，最终队列中保留的是[3,2,1]，此时取队列头部为最大值
            res.append(nums[indexDueue[0]])
    return res