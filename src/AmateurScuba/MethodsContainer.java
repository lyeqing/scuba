/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmateurScuba;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

/**
 *
 * @author Louis
 */
public class MethodsContainer {

    public static double calculator(int flag, String text1, String text2) {
        double one = Double.parseDouble(text1);
        double two = Double.parseDouble(text2);
        double result;
        switch (flag) {
            case 1:
                result = (one/two-1.0)*10.0;
            
                break;
            case 2:
                result = one/(two/10.0+1.0);
            
                break;
            case 3:
                    result = one*(two/10.0+1.0);
            
                break;
            case 4:
                    result = ((1.0-one)*(two/10.0+1.0)/0.79-1.0)*10.0;
            
                break;
            case 5:
                         result = (one/two-1.0)*10.0;
                  
                break;
            default:
                result=0.0; 
        }
        return result;
    }
    public static double calculateOxygen(int flag, String text1, String text2){
            double one = Double.parseDouble(text1);
        double two = Double.parseDouble(text2);
        double result;
        
        switch (flag) {
            case 1:
                result = two;
            
                break;
            case 2:
                result = one/(two/10+1);
            
                break;
            case 3:
                    result = one;
            
                break;
            case 4:
                    result = one;
            
                break;
            case 5:
                         result = two;
                  
                break;
            default:
                result=0; 
        }
        return result;
    }
     public static ChartPanel cylinderBuilder(double oDecimal){
         DecimalFormat df = new DecimalFormat("0.00");
         double oPercent = oDecimal*100;
         double nPercent = 100 - oPercent;
         
     final String oxygen = "Oxygen";
      final String nitrogen = "Nitrogen";
      
      final String percentage = "The Percentage of Oxygen "+df.format(oPercent)+"%";
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      dataset.addValue(oPercent, oxygen , percentage );
      dataset.addValue(nPercent , nitrogen , percentage );
      GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
        KeyToGroupMap map = new KeyToGroupMap("G1");
        map.mapKeyToGroup(oxygen, "G1");
        map.mapKeyToGroup(nitrogen, "G1");
        renderer.setSeriesToGroupMap(map); 
               renderer.setItemMargin(0.0);
        Paint p1 = new GradientPaint(
            0.0f, 0.0f, new Color(0x22, 0x22, 0xFF), 0.0f, 0.0f, new Color(0x88, 0x88, 0xFF)
        );
        renderer.setSeriesPaint(0, p1);
        Paint p2 = new GradientPaint(
            0.0f, 0.0f, new Color(0x22, 0xFF, 0x22), 0.0f, 0.0f, new Color(0x88, 0xFF, 0x88)
        );
        renderer.setSeriesPaint(1, p2); 
        renderer.setGradientPaintTransformer(
            new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL)
        );
 JFreeChart myChart = ChartFactory.createBarChart(
         "The Percentage of Oxygen", 
         "the Mixture Oxygen and Nitrogen", "Percentage", 
         dataset,PlotOrientation.VERTICAL, 
         true, true, false);
 CategoryPlot plot = (CategoryPlot) myChart.getPlot();
 plot.setRenderer(renderer);
 
ChartPanel chartPanel = new ChartPanel((JFreeChart) null);
		chartPanel.setChart(myChart);
//chartPanel.setPreferredSize(new Dimension(785, 440)); //size according to my window
chartPanel.setMouseWheelEnabled(true);
return chartPanel;
     
     }
     public static JTable ppTable(){
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
                    if(result>1.6){data[i][j] =  "Danger";
                    }
                    else{
                    data[i][j] = df.format(result) + "";
                    }
                }
            }

        }
        JTable jt = new JTable(data, column);
        return jt;
}
     public static JTable eadTable(){
      String[] column = new String[24];
        column[0] = "Oxygen(%)/Depth(m)";
        double result;
        for (int i = 1; i < column.length; i++) {
            int temp = i * 3;
            column[i] = temp + "";
        }
        String[][] data = new String[33][24];
        DecimalFormat df = new DecimalFormat("0");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (j == 0) {
                    data[i][j] = (i + 18) + "";
                } else {
//result = ((1-one)*(two/10+1)/0.79-1)*10;
                    result = ((1.0 - (i + 18.0) / 100.0) * ((j * 3.0) / 10.0 + 1.0) / 0.79 - 1.0) * 10.0;
                    data[i][j] = df.format(result) + "";
                }
            }

        }
        JTable jt = new JTable(data, column);
     
     
     return jt;
     }
}
