import java.util.Stack;

public class ImplementQueueUsingStack_232 {
    private static class MyQueue {
        private final Stack<Integer> stack1 = new Stack<>();
        private final Stack<Integer> stack2 = new Stack<>();

        public MyQueue() {
        }

        public void push(int x) {
            if (stack1.empty()) {
                stack1.push(x);
            } else {
                transfer(stack1, stack2);
                stack1.push(x);
                transfer(stack2, stack1);
            }
        }

        public int pop() {
            return stack1.pop();
        }

        public int peek() {
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.empty();
        }

        private void transfer(Stack<Integer> from, Stack<Integer> to) {
            while (!from.empty()) {
                to.push(from.pop());
            }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        int param_2 = obj.pop();
        obj.push(1);
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.printf("%d, %d, %b\n", param_2, param_3, param_4);
    }
}
