package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SimpleFile {
    /*  Найти все файлы с заданным расширением в папке и ее подпапках. Для чтения набора файлов и подпапок в папке использовать
    класс java.io.File (метод listFiles()). Реализация с использованием очереди. Вначале в очередь помещается папка, в которой ищем файлы.
        Затем, в цикле, пока в очереди есть элементы, выбираем из очереди элемент (папку). Для данной папки находим все вложенные элементы:
    если это нужный файл, помещаем его в итоговый список, если это папка, то добавляем ее в очередь. Заменить в реализации очередь на стек, объяснить,
    каким образом и почему изменится порядок найденных файлов.*/
    private File f;

    public SimpleFile(){}

    public File getF() {
        return f;
    }

    public void setF(File f) {
        this.f = f;
    }

    public Stack<File> getFiles(String expansion) throws Exception {
        return filesSearch(expansion);
    }

    private Queue<File> queue = new LinkedList<>();

    private Stack<File> filesSearch(String expansion) throws Exception {
        Stack<File> listStack = new Stack<>();
        queue.add(f);
        File arr[];
        File i;
        while (queue.size() > 0) {
            i = queue.element();
            if (i.isDirectory()){
                arr = i.listFiles();
                for (int j = 0; j < arr.length; j++) {
                    queue.add(arr[j]);
                }
            } else {
                String ext1 = "";
                int j = i.getPath().lastIndexOf('.');
                if (j > 0) {
                    ext1 = i.getPath().substring(j+1);
                }
                if (ext1.equals(expansion)) {
                    listStack.push(i);
                }
            }
            queue.remove();
        }
        return listStack;
    }

    public static String printStack(Stack<File> stack) throws Exception {
        Stack<File> stack2 = stack;
        String answer = " ";
        while (stack2.size() > 0){
            answer += "  " + stack2.pop();
        }
        return answer;
    }
}
