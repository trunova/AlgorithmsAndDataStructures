package com.company;

public class SimpleLinkedListStack2<T> implements SimpleStack<T> {

    private class ListNode<T> {
        public T value;
        public ListNode<T> next;

        public ListNode(T value, ListNode<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private ListNode<T> head = null;

    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void push(T value) {
        head = new ListNode<>(value, head);
        count++;
    }

    @Override
    public T pop() throws Exception {
        if (count == 0) {
            throw new Exception("Stack is empty");
        }
        T value = head.value;
        head = head.next;
        count--;
        return value;
    }

    @Override
    public T peek() throws Exception {
        if (count == 0) {
            throw new Exception("Stack is empty");
        }
        return head.value;
    }
//    T i = head.value;
//    public T peekNext() throws Exception {
//        if (count == 0) {
//            throw new Exception("Stack is empty");
//        }
//
//        return head.value;
//    }
}
