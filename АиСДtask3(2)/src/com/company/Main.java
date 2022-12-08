package com.company;

import com.util.SwingUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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

    public static void printStack(Stack<File> stack) throws Exception {
        Stack<File> stack2 = stack;
        while (stack2.size() > 0){
            System.out.println(stack2.pop());
        }
    }

    public static void main(String[] args) throws Exception {
        CmdParams params = parseArgs(args);
        if (params.window) {
            winMain();
        }
        File f = new File("D:\\Java\\АиСДtask3\\kkkk\\");
        SimpleFile FF = new SimpleFile();
        FF.setF(f);
        Stack<File> stack;
        stack = FF.getFiles("txt");
        printStack(stack);
    }
}

