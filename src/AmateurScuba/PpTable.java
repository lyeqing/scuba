/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmateurScuba;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Louis
 */
public class PpTable {
     JFrame f;

    PpTable() {
        f = new JFrame();

        String[] column = new String[24];
        column[0] = "Oxygen(%)/Depth(m)";
        double result;
        for (int i = 1; i < column.length; i++) {
            int temp = i * 3;
            column[i] = temp + "";
        }
        String[][] data = new String[33][24];
        DecimalFormat df = new DecimalFormat("0.0");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (j == 0) {
                    data[i][j] = (i + 18) + "";
                } else {
                                
                    result =  (i + 18.0)/100.0* (j*3.0/10.0+1.0);
                    
                    data[i][j] = df.format(result) + "";
                }
            }

        }
        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        Toolkit t = Toolkit.getDefaultToolkit();

        Dimension d = t.getScreenSize();

        int ScreenWidth = d.width;

        int ScreenHeight = d.height;
        f.setSize(ScreenWidth, ScreenHeight);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new PpTable();
    
}
}