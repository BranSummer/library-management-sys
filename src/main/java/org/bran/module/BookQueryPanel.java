package org.bran.module;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 * 
 *<p>Title: BookQueryPanel.java</p>
 *<p>Description:图书查询面板 </p>
 * @author BranSummer
 * @date 2017年5月4日
 */
public class BookQueryPanel extends JPanel {
	//日期
	private DatePanel preDate,nexDate;
	//查询框
	private JTextField query;
	//按钮
	private JButton queryb;
	//表格
	private JTable table;
	private DefaultTableModel model;
	private String[] headers={"书号","书名","书籍类别","作者","出版社","出版日期","价格","页数","关键词","登记日期","是否被借出","备注"};
	private Object[][] cellData={{"","","","","","","","","","","",""}};
	
	public BookQueryPanel(){
		super();
		//创建分割面板
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.add(sp);
		//创建默认表格模型
		DefaultTableModel model=new DefaultTableModel(cellData,headers){
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return super.isCellEditable(row, column);
			}
		};
		table=new JTable(model);
		//JPanel panel2=new JPanel();
		JScrollPane scroll=new JScrollPane();
		scroll.setViewportView(table);
	//	panel2.add(table);
		//创建标签
		JPanel panel1=new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.add(new JLabel("输入书号、书名、出版社或者出版日期查询书籍",JLabel.CENTER));
		//输入区
		JPanel minPanel1=new JPanel();
		minPanel1.setLayout(new BoxLayout(minPanel1, BoxLayout.X_AXIS));
		minPanel1.add(new JLabel("查询内容:"));
		query=new JTextField(20);
		minPanel1.add(query);
		queryb=new JButton("查询");
		minPanel1.add(queryb);		
		panel1.add(minPanel1);
		//日期
		JPanel minPanel2=new JPanel();
		minPanel2.setLayout(new BoxLayout(minPanel2, BoxLayout.X_AXIS));
		preDate=new DatePanel();
		nexDate=new DatePanel();
		minPanel2.add(new JLabel("起始时间："));
		minPanel2.add(Box.createVerticalGlue());
		minPanel2.add(preDate);
		minPanel2.add(new JLabel("至 终止时间："));
		minPanel2.add(nexDate);
		minPanel2.add(Box.createVerticalGlue());
		panel1.add(minPanel2);
		
		//加入分割面板
		sp.add(panel1, JSplitPane.TOP);
		sp.add(scroll, JSplitPane.BOTTOM);
	}
/*	public static void main(String[] args) {
		JFrame test=new JFrame("test");
		test.setSize(600, 400);
		test.getContentPane().add(new BookQueryPanel());
		test.setVisible(true);
	}
*/	
}
