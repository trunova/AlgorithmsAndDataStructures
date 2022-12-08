package ru.vsu.cs.trunova_a_m;

import java.util.*;
import ru.vsu.cs.util.SwingUtils;

    /*
    7. Найти все позиции в массиве/списке целых чисел наибольшего из наиболее часто
встречающихся значений. Алгоритм должен работать за время O(n*log(n)). Использовать
структуру данных Map&lt;Integer, List&lt;Integer&gt;&gt; (ключ – число из массива, значение –
позиции этого числа). Далее пройти по данному словарю для поиска нужного числа и его
позиций.
     */

    public class Main {

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
            Locale.setDefault(Locale.ROOT);
            SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

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

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = { 2, 3, 2, 5, 6, 2, 1, 6, 7, 6, 0, 9};
        list = func(arr);
        System.out.println("Позиции: ");
        for (Integer value: list){
            System.out.print(value + " ");
        }
    }

    public static ArrayList<Integer> func(int[] arr){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); // ключ - значение из массива, значение - список из позиций
        ArrayList<Integer> result = new ArrayList<>();
        int maxSize = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.isEmpty() || map.get(arr[i]) == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            } else
                map.get(arr[i]).add(i);
            if (map.get(arr[i]).size() > maxSize)
                maxSize = map.get(arr[i]).size();
        }
        Integer n = Integer.MIN_VALUE;
        for(Map.Entry<Integer, ArrayList<Integer>> value : map.entrySet()){
            if (value.getValue().size() == maxSize && value.getKey() > n)
                n = value.getKey();
        }
        result = map.get(n);
        return result;
    }
}
