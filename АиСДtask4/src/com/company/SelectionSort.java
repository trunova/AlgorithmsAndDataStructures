package com.company;

public class SelectionSort {
//    29.	Предыдущая задача, но для сортировки выбором:
//     Модифицировать алгоритм пирамидальной (HeapSort) таким образом, чтобы можно было
//     сортировать элементы массива из заданного диапазона элементов (от from до to, где from – индекс первого
//     элемента диапазона, to – индекс элемента, следующего за последним элементом диапазона. Сигнатура метода должна быть:

    public static <T extends Comparable<T> > void sort(T[] data, int form, int to) {
        for (int i = form; i < to; i++) {
            int minIndex = i;
            for (int j = i + 1; j < to; j++) {
                if (data[j].compareTo(data[minIndex]) < 0)
                    minIndex = j;
            }
            if (minIndex != i) {
                T tmp =  data[i];
                data[i] = data[minIndex];
                data[minIndex] = tmp;
            }
        }
    }
}
