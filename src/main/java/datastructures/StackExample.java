package datastructures;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Stack extends Vector so this is also thread-safe
        // This should not be used. Use ConccurentLinkedDeque - threadsafe
        Stack<String> stack = new Stack<>();
        stack.add("Tomatoes");
        stack.add("Carrots");
        stack.push("Cucumbers");
        String veggie;
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
