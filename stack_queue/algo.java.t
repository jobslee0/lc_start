public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    Map<Character, Character> pMap = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};
    for (char c : s.toCharArray()) {
        if (!pMap.containsKey(c)) {
            stack.push(c);
        } else if (stack.isEmpty() || !(stack.pop().equals((Character)pMap.get(c)))) {
            return false;
        }
    }
    return stack.isEmpty();
}

class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if (!output.isEmpty()) {
            return output.pop();
        } else if (!input.isEmpty()) {
            trans();
            return output.pop();
        }
        return -1;
    }
    
    public int peek() {
        if (!output.isEmpty()) {
            return output.peek();
        } else if (!input.isEmpty()) {
            trans();
            return output.peek();
        }
        return -1;
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void trans() {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
    }
}

// add remove element
// offer poll peek
class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.offer(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

public boolean backspaceCompare(String s, String t) {
    return build(s).equals(build(t));
}

private String build(String str) {
    Stack<Character> stack = new Stack<>();
    for (char c : str.toCharArray()) {
        if ('#' != c) {
            stack.push(c);
        } else if (!stack.isEmpty()) {
            stack.pop();
        }
    }
    return String.valueOf(stack);
}