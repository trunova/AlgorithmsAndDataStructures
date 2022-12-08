package com.company;

import com.util.SwingUtils;

import java.util.Locale;

public class Main {

//    21.	Дан список целых чисел. Создать новый список, содержащий неповторяющиеся значения из исходного списка.
//    Первоначальный список не изменять.

    // File f = new File("C:\\путь\\"); должен быть метод, принимающий на вход f и возвращающий список файлов.

    public static class CmdParams {
        public boolean window;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args.length > 0) {
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
        }
        return params;
    }


    public static void winMain() throws Exception {
        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        CmdParams params = parseArgs(args);
        if (params.window) {
            winMain();
        }

        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        SimpleLinkedList<Integer> newList = new SimpleLinkedList<>();
        list.addLast(1);
        list.addLast(3);
        list.addLast(4);
        list.addLast(3);
        list.addLast(7);
        list.func(4);
        //list.toString();
        int v = 3;
         int v2 = (-1)*v;
        System.out.println(v2);
        for (Integer value: list){
            System.out.println(value);
        }
        //newList.secondList(list);
//        int[] arr = {1, 2, 8, 3, 10, 4, 20, 3};
//        sort(arr);
//        for (Integer v: arr){
//            System.out.println(v);
//        }
    }
    public static void sort(int[] data) {
        int size = data.length;
        for (int i = size - 1; i >= 0; i--) {
            int value = data[i];
            // поиск места элемента в готовой последовательности
            int j;
            for (j = i + 1; j < size && compare(data[j], value) > 0; j++) {
                data[j - 1] = data[j];     // сдвигаем элемент направо, пока не дошли
            }
            // место найдено, вставить элемент
            data[j -1] = value;
        }
    }

    private static int compare(int datum, int value) {
        if (datum > value){
            return 1;
        }else return -1;
    }

}
