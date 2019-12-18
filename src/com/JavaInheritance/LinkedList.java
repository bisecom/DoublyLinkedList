package com.JavaInheritance;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList() {
        length = 0;
    }

    private class Node {
        T element;
        Node next;
        Node prior;

        public Node(T element, Node next, Node prior) {
            this.element = element;
            this.next = next;
            this.prior = prior;
        }
    }

    public int listLength() { return length; }

    public boolean isEmpty() { return length == 0; }

    public void clear() { head = null; tail = null; }

    public void addFirst(T element) {
        Node tmp = new Node(element, head, null);
        if(head != null ) {head.prior = tmp;}
        head = tmp;
        if(tail == null) { tail = tmp;}
        length++;
        System.out.println("adding: "+element);
    }

    public void addLast(T element) {
        Node tmp = new Node(element, null, tail);
        if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) { head = tmp;}
        length++;
        System.out.println("adding: "+element);
    }

    public void iterateForward(){
        System.out.println("iterating from the bottom..");
        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }

    public void iterateBackward(){
        System.out.println("iterating from the top..");
        Node tmp = tail;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.prior;
        }
    }

    public void iterateLeftToRight(){
        System.out.println("iterating Left To Right..");
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.element + " ");
            tmp = tmp.next;
        }
    }

    public void iterateRightToLeft(){
        System.out.print("iterating Right To Left..");
        Node tmp = tail;
        while(tmp != null){
            System.out.print(tmp.element + " ");
            tmp = tmp.prior;
        }
    }

    public T removeFirst() {
        if (length == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prior = null;
        length--;
        System.out.println("popping: "+tmp.element);
        return tmp.element;
    }

    public T removeLast() {
        if (length == 0) throw new NoSuchElementException();
        Node tmp = tail;
        tail = tail.prior;
        tail.next = null;
        length--;
        System.out.println("popping: "+tmp.element);
        return tmp.element;
    }

    public int elementSearch(T element) {
        if (length == 0) throw new NoSuchElementException();
        int index = 0; boolean elementIsAvailable = false;
        System.out.println("Searching for element: " + element);
        Node tmp = head;
        while(tmp != null){
            //System.out.println("element "+ tmp.element);
            if(tmp.element == element){
                System.out.println(index);
                elementIsAvailable = true;
                break;
            }
            index++;
            tmp = tmp.next;
        }
        return elementIsAvailable ? index : -1;
    }
//pick last element
    public T elementPick() {
        if (length == 0) throw new NoSuchElementException();
        return tail.element;
    }

    public boolean insertAtPosition(int index, T element){
        if(index < 0 || index > length - 1) return false;
        int listIndex = 0;
        Node nodeBeforeIndex = head;
        Node nodeAtIndex = head;
        Node insert = new Node(element, null, null);
        if(index == 0){
            insert.next = head;
            if(head != null ) {head.prior = insert;}
            head = insert;
            if(tail == null) { tail = insert;}
        }
        if(index > 0 && index < length - 1){
            while(nodeAtIndex != null){
                System.out.println("element "+ nodeAtIndex.element);
                nodeAtIndex = nodeAtIndex.next;
                listIndex++;
                if(index-1 == listIndex){
                    nodeBeforeIndex = nodeAtIndex;
                }
                if(index == listIndex){
                    break;
                }
            }
            nodeBeforeIndex.next = insert;
            insert.next = nodeAtIndex;
            insert.prior = nodeBeforeIndex;
            nodeAtIndex.prior = insert;
        }
        if(index == length - 1){
            insert.prior = tail;
            if(tail != null) {tail.next = insert;}
            tail = insert;
            if(head == null) { head = insert;}
        }
        length++;
        return true;
    }

    public boolean removeAtPosition(int index){
        if(index < 0 || index > length - 1) return false;
        int listIndex = 0;
        Node nodeBeforeIndex = head;
        Node nodeAtIndex = head;
        Node afterIndex = head;
        if(index == 0){
            head = head.next;
            head.prior = null;
        }
        if(index > 0 && index < length - 1){
            while(afterIndex != null){
                //System.out.println("element "+ nodeAtIndex.element);
                afterIndex = afterIndex.next;
                listIndex++;
                if(index-1 == listIndex){
                    nodeBeforeIndex = afterIndex;
                }
                if(index == listIndex){
                    nodeAtIndex = afterIndex;
                }
                if(index+1 == listIndex){
                    break;
                }
            }
            nodeBeforeIndex.next = afterIndex;
            afterIndex.prior = nodeBeforeIndex;
            nodeAtIndex.next = null;
            nodeAtIndex.prior = null;

        }
        if(index == length - 1){
            tail = tail.prior;
            tail.next = null;
        }
        length--;
        return true;
    }

}