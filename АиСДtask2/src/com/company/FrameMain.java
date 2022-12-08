package com.company;

import com.util.ArrayUtils;
import com.util.JTableUtils;
import com.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

public class FrameMain extends JFrame {
    private JButton buttonList;
    private JTable table1;
    private JButton buttonNewList;
    private JTable table2;
    private javax.swing.JPanel JPanel;

    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;
    private JMenuBar menuBarMain;
    private JMenu menuLookAndFeel;

    public FrameMain() {
        this.setTitle("FrameMain");
        this.setContentPane(JPanel);
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        JTableUtils.writeArrayToJTable(table1, new int[][]{
                {0, 1, 2, 3, 4}
        });
        JTableUtils.writeArrayToJTable(table2, new int[][]{
                {0, 1, 2, 3, 4}
        });

        this.pack();

        buttonList.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooserOpen.showOpenDialog(JPanel) == JFileChooser.APPROVE_OPTION) {
                    int[] arr = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                    JTableUtils.writeArrayToJTable(table1, arr);
                }
            }
        });

        buttonNewList.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = JTableUtils.readIntArrayFromJTable(table1);
                    SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
                    for (Integer a : arr) {
                        list.addLast(a);
                    }
                    SimpleLinkedList<Integer> newList = new SimpleLinkedList<>();
                    newList.secondList(list);
                    JTableUtils.writeArrayToJTable(table2, newList.toInt());
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
                }
        });

       /* buttonNewList.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = JTableUtils.readIntArrayFromJTable(table1);
                    SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
                    for (Integer a : arr) {
                        list.addLast(a);
                    }
                    SimpleLinkedList<Integer> newList = new SimpleLinkedList<>();
                    newList.secondList(list);
                    JTableUtils.writeArrayToJTable(table2, newList.toInt());
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        }); */

    }
}
