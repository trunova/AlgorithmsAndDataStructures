package com.company;

import java.util.Iterator;
import java.util.function.Consumer;

public class SimpleLinkedList<T> implements Iterable<T> {
    public void setHead(ListNode head) {
        this.head = head;
    }

    private SimpleLinkedList<T>.ListNode head = null;
    private SimpleLinkedList<T>.ListNode tail = null;
    int count = 0;

    public SimpleLinkedList (){ }

    public SimpleLinkedList (SimpleLinkedList<T> list){
        this.head = list.head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(head.value);
        int i = 0;
        Iterator<T> it = this.iterator();
        while (it.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(it.next());
            i++;
        }
        return sb.toString();
    }

    /*
    Необходимо описать метод для списка целых чисел (IntegerSimpleLinkedList),
    который перед каждым элементом со значением v, вставит элемент с противоположным значением (-v).
    Значение v передается в метод в качестве параметра.
    Не забудьте при этом модифицировать (при необходимости) поля head, tail и size класса списка.
     */
    public void func( int v)  {
        int v2 = (-1) * v;
        for (ListNode a = head; a != null; a = a.next){
            if (a != head && a != tail){
                if (a.next.equals(v)){
                    ListNode n = new ListNode(v2, a.next);
                    a.next = n;
                    count++;
                }
            } else if (a == head){
                if (a.equals(v)){
                    ListNode n = new ListNode( v2, head);
                    head = n;
                    count++;
                }
                if (a.next.equals(v)){
                    ListNode n = new ListNode( v2, a.next);
                    a.next = n;
                    count++;
                }
            }
        }
    }

    //    21.	Дан список целых чисел. Создать новый список, содержащий неповторяющиеся значения из исходного списка.
    //          Первоначальный список не изменять.

    public void secondList(SimpleLinkedList<T> list){ //

        for (ListNode a = list.head; a != null; a = a.next){
            if (check(a.value, list) == 1){
                this.addLast(a.value);
            }
        }
    }

    public int check(T a, SimpleLinkedList<T> list){
        int k = 0;
        for (ListNode b = list.head; b != null; b = b.next){
            if (b.value.equals(a)) {
                k++;
            }
        }
        return k;
    }

    public String[] toInt(){
        String[] arr = new String[this.count];
        ListNode a = this.head;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a.value.toString();
            a = a.next;
        }
        return arr;
    }

    public void addFirst(T value) {
        this.head = new SimpleLinkedList.ListNode(value, this.head);
        if (this.count == 0) {
            this.tail = this.head;
        }

        ++this.count;
    }

    public void addLast(T value) {
        SimpleLinkedList<T>.ListNode newNode = new SimpleLinkedList.ListNode(value);
        if (this.count > 0) {
            this.tail.next = newNode;
        } else {
            this.head = newNode;
        }

        this.tail = newNode;
        ++this.count;
    }

    private void emptyError() throws Exception {
        if (this.count == 0) {
            throw new Exception("List is empty");
        }
    }

    public T getFirst() throws Exception {
        this.emptyError();
        return this.head.value;
    }

    public T getLast() throws Exception {
        this.emptyError();
        return this.tail.value;
    }

    private SimpleLinkedList<T>.ListNode getNode(int index) throws Exception {
        if (index >= 0 && index < this.count) {
            SimpleLinkedList<T>.ListNode curr = this.head;

            for(int i = 0; i < index; ++i) {
                curr = curr.next;
            }

            return curr;
        } else {
            throw new Exception("Wrong index");
        }
    }

    public T get(int index) throws Exception {
        return this.getNode(index).value;
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public Iterator<T> iterator() {
        class LinkedListIterator implements Iterator<T> {
            SimpleLinkedList<T>.ListNode curr;

            public LinkedListIterator(SimpleLinkedList<T>.ListNode head) {
                this.curr = head;
            }

            public boolean hasNext() {
                return this.curr != null;
            }

            public T next() {
                T result = this.curr.value;
                this.curr = this.curr.next;
                return result;
            }
        }

        return new LinkedListIterator(this.head);
    }

    private class ListNode {
        public T value;
        public ListNode next;

        public ListNode(T value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(T value) {
            this(value, null);
        }

        public ListNode(int v2, ListNode next) {
            this((T) null);
        }
    }
}
