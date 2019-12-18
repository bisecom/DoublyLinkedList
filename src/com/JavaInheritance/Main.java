package com.JavaInheritance;

public class Main {

    public static void main(String[] args) {
        /*
        LinkedList<String> list = new LinkedList<>();
        list.addLast("Java");
        list.addLast("Love");
        list.addLast("I");

        list.iterateBackward();
        list.removeAtPosition(1);
        list.iterateBackward();
       */

        CustomStack<String> stack = new CustomStack<>();
        stack.push("JAVA");
        stack.push("LIKE");
        stack.push("I");

        stack.showElements();
        stack.pop();
        stack.push("YOU");
        stack.showElements();
    }
}
