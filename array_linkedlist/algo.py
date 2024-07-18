def reverseList(self, head):
    cur, prev = head, None
    while cur:
        cur.next, prev, cur = prev, cur, cur.next
    return prev

def swapPairs(self, head):
    pre, pre.next = self, head
    while pre.next and pre.next.next:
        a = pre.next
        b = a.next
        pre.next, b.next, a.next = b, a, b.next
        pre = a
    return self.next

def hasCycle(self, head):
    fast = slow = head
    while slow and fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow is fast:
            return True
    return False

def detectCycle(self, head):
    nodes = set()
    while head:
        if head in nodes:
            return head
        nodes.add(head)
        head = head.next
    return None

def reverseKGroup(self, head, k):
    #todo
