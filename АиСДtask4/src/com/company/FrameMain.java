package com.company;

import com.util.ArrayUtils;
import com.util.JTableUtils;
import com.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

public class FrameMain extends JFrame {
    private JButton buttonArr;
    private JTable table1;
    private JButton buttonNewArr;
    private JTable table2;

    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;
    private JMenuBar menuBarMain;
    private JMenu menuLookAndFeel;
    private javax.swing.JPanel JPanel;
    private JSpinner spinnerFrom;
    private JSpinner spinnerTo;

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

        buttonArr.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooserOpen.showOpenDialog(JPanel) == JFileChooser.APPROVE_OPTION) {
                    int[] arr = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                    JTableUtils.writeArrayToJTable(table1, arr);
                    SpinnerNumberModel model = new SpinnerNumberModel(0, 0, arr.length, 1);
                    spinnerFrom.setModel(model);
                    SpinnerNumberModel model2 = new SpinnerNumberModel(0, 0, arr.length, 1);
                    spinnerTo.setModel(model2);
                }
            }
        });

        buttonNewArr.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arrX = JTableUtils.readIntArrayFromJTable(table1);
                    Integer[] arr = new Integer[arrX.length];
                        for (int i = 0; i < arr.length; i++) {
                            arr[i] = arrX[i];
                        }
                    int from = (int) spinnerFrom.getValue();
                    int to = (int) spinnerTo.getValue();
                    SelectionSort.sort(arr, from, to);
                    JTableUtils.writeArrayToJTable(table2, arr);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}