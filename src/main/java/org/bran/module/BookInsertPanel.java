package org.bran.module;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookInsertPanel extends JPanel {
	//编号，书名，作者，出版社，出版社日期，价格，页码，关键词，登记日期
	private JTextField bookId,bookName,author,publish,pubDate,price,pageNum,keyWord,regDate;
	//书籍类别
	private JComboBox sort;
	//
	public BookInsertPanel(){
		super();
	}
}
