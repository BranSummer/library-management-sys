package org.bran.module;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 * 
 *<p>Title: BorrowPanel.java</p>
 *<p>Description: 图书借阅界面</p>
 * @author BranSummer
 * @date 2017年5月10日
 */
public class BorrowPanel extends JPanel {
	//我呢吧标签 显示已借阅册数，最大借阅数
	private JLabel brrowNum;
	private JLabel maxNum;
	//复选框  书籍类别
	private JComboBox bookSort;
	//文本框 搜索输入
	private JTextField queryText;
	//表格
	private JTable table;
	private DefaultTableModel model;
	private String[] headers={"勾选","书号","书名","出版社","状态"};
	private Object[][] cellData={{false,"","","",""}};
	
}
