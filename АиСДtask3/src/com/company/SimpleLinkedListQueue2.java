package com.company;

public class SimpleLinkedListQueue2<T> implements SimpleQueue<T> {

    private class ListNode<T> {
        public T value;
        public ListNode<T> next;

        public ListNode(T value, ListNode<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private ListNode<T> head = null;
    private ListNode<T> tail = null;

    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void add(T value) {
        ListNode<T> newNode = new ListNode<>(value, null);
        if (count > 0) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        count++;
    }

    @Override
    public T remove() throws Exception {
        if (count == 0) {
            throw new Exception("Queue is empty");
        }
        T value = head.value;
        head = head.next;
        count--;
        if (count == 0) {
            tail = null;
        }
        return value;
    }

    @Override
    public T element() throws Exception {
        if (count == 0) {
            throw new Exception("Queue is empty");
        }
        return head.value;
    }
}
