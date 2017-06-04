package org.bran.module;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
/**
 * 
 *<p>Title: MyChartPanel.java</p>
 *<p>Description:图标显示面板 </p>
 * @author BranSummer
 * @date 2017年6月4日
 */
public class MyChartPanel extends JPanel {
	//ChartPanel
	private ChartPanel chartPanel;
	//列表框
	private JList list;
	String[] elements={"图形类型饼图","读者类型图","借阅条形图"};
	/**
	 * constructor
	 */
	public MyChartPanel(){
		super();
		//分割面板  竖直分割
		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		this.add(sp);
		//创建列表框
		JScrollPane leftPanel=new JScrollPane();	
		list=new JList<String>(elements);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		leftPanel.setViewportView(list);
		
		//创建图表面板
		//创建一个默认的饼图
		DefaultPieDataset pdSet=new DefaultPieDataset();
		pdSet.setValue("计算机", 50);
		pdSet.setValue("小说", 80);
		pdSet.setValue("文学", 30);
		pdSet.setValue("艺术", 20);
		
		JFreeChart chart=ChartFactory.createPieChart("demo", pdSet, true,true,false);
		PiePlot plot=(PiePlot) chart.getPlot();
		 plot.setLabelFont(new Font("黑体", Font.PLAIN, 20));
	        TextTitle textTitle = chart.getTitle();
	        textTitle.setFont(new Font("黑体", Font.PLAIN, 20));
	        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
		chartPanel=new ChartPanel(chart);
		
		//加入分割面板
		sp.add(leftPanel, JSplitPane.LEFT);
		sp.add(chartPanel, JSplitPane.RIGHT);
	}
	public static void main(String[] args) {
		JFrame test=new JFrame("test");
		test.setSize(600, 400);
		test.getContentPane().add(new MyChartPanel());
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
	}
}
