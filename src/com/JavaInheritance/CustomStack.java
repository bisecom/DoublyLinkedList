package com.JavaInheritance;

interface IMyStack{
    boolean empty();
    Object peek();
    Object pop();
    Object push(Object element);
    int search(Object element);
}

public class CustomStack<T> implements IMyStack{
    private LinkedList <T>list;

    CustomStack(){
        list = new LinkedList<>();
    }

    @Override
    public boolean empty() {
        System.out.println("The stack is clear...");
        list.clear();
        return true;
    }

    @Override
    public Object peek() {
        Object element = list.elementPick();
        System.out.println("The stack's top element is: " + element);
        return element;
    }

    @Override
    public Object pop() {
        return list.removeLast();
    }

    @Override
    public Object push(Object element) {
       list.addLast((T)element);
       return element;
    }

    @Override
    public int search(Object element) {
        int index = list.elementSearch((T)element);
        System.out.println("The element located at position No of stack: " + index);
        return index;
    }

    public void showElements(){
        System.out.println("Data of the stack:");
        list.iterateBackward();
    }
}
