public ListNode reverseList(ListNode head) {
    if (null == head) {
        return head;
    }
    ListNode cur = head;
    ListNode prev = null;
    while (cur != null) {
        ListNode temp = cur.next;
        cur.next = prev;
        prev = cur;
        cur = temp;
    }
    return prev;
}

public ListNode swapPairs(ListNode head) {
    if (null == head) {
        return head;
    }
    ListNode dummy = new ListNode(-1, head);
    ListNode prev = head;
    while (prev.next != null && prev.next.next != null) {
        ListNode a = prev.next;
        ListNode b = a.next;
        ListNode temp = b.next;
        prev.next = b;
        b.next = a;
        a.next = temp;
        prev = a;
    }
    return dummy.next;
}

public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (slow != null && fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            return true;
        }
    }
    return false;
}

public ListNode detectCycle(ListNode head) {
    Set<ListNode> nodes = new HashSet<>();
    while (head != null) {
        if (nodes.contains(head)) {
            return head;
        }
        nodes.add(head);
        head = head.next;
    }
    return null;
}

