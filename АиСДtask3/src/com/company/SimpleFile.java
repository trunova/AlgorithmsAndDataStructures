package com.company;

import java.io.File;
import java.util.ArrayList;

public class SimpleFile {
    /*Найти все файлы с заданным расширением в папке и ее подпапках. Для чтения набора файлов и подпапок в папке использовать
класс java.io.File (метод listFiles()). Реализация с использованием очереди. Вначале в очередь помещается папка, в которой ищем файлы.
        Затем, в цикле, пока в очереди есть элементы, выбираем из очереди элемент (папку). Для данной папки находим все вложенные элементы:
если это нужный файл, помещаем его в итоговый список, если это папка, то добавляем ее в очередь. Заменить в реализации очередь на стек, объяснить,
каким образом и почему изменится порядок найденных файлов.*/
    //File f = new File("C:\\путь\\");
    // D:\Java\АиСДtask3\kkkk
    private File f;

    public SimpleFile(){}

    public File getF() {
        return f;
    }

    public void setF(File f) {
        this.f = f;
    }

    public SimpleLinkedListStack2<File> getFiles(String expansion) throws Exception {
        return filesSearch(expansion);
    }

    private SimpleLinkedListQueue2<File> queue = new SimpleLinkedListQueue2<>();


    private SimpleLinkedListStack2<File> filesSearch(String expansion) throws Exception {
        SimpleLinkedListStack2<File> listStack = new SimpleLinkedListStack2();
        queue.add(f);
        File arr[];
        File i;
        while (queue.getCount() > 0){
            i = queue.remove();
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
        }
        return listStack;
    }

    public static String printStack(SimpleLinkedListStack2<File> stack) throws Exception {
        SimpleLinkedListStack2<File> stack2 = stack;
        String answer = " ";
        while (stack2.getCount() > 0){
            answer += " \r\n" + stack2.pop();
        }
        return answer;
    }
}
