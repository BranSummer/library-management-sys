package org.bran.module;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * 
 *<p>Title: BookInsertPanel.java</p>
 *<p>Description:添加图书信息所用的面板 </p>
 * @author BranSummer
 * @date 2017年5月1日
 */
public class BookInsertPanel extends JPanel {
	//编号，书名，作者，出版社，价格，页码，关键词，
	private JTextField bookId,bookName,author,publish,price,pageNum,keyWord,num;
	//书籍类别
	private JComboBox sort;
	private String[] bookSorts={"小说","文学","传记","艺术","少儿","社会科学","科技","教辅","历史","医学"};
	//出版日期手动输入，登记日期由系统录入
	private DatePanel pubDate;
	//备注
	private JTextArea remarks;
	//提交，重置按钮
	private JButton submit,reset;

	public BookInsertPanel(){
		super();
		//布局
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//输入区表格布局		
		JPanel panel1=new JPanel(new GridLayout(10, 2));
		//创建图书编号，书名,作者,出版社
		bookId=new JTextField(20);
		panel1.add(new JLabel("图书编号：",JLabel.RIGHT));
		panel1.add(bookId);
		bookName=new JTextField(20);
		panel1.add(new JLabel("图书名称：",JLabel.RIGHT));
		panel1.add(bookName);
		author=new JTextField(20);
		panel1.add(new JLabel("作者：",JLabel.RIGHT));
		panel1.add(author);
		publish=new JTextField(20);
		panel1.add(new JLabel("出版社：",JLabel.RIGHT));
		panel1.add(publish);
		//创建出版日期 
		pubDate=new DatePanel();
		panel1.add(new JLabel("出版日期：",JLabel.RIGHT));
		panel1.add(pubDate);
		//创建类别
		sort=new JComboBox<String>();
		for(int i=0;i<bookSorts.length;i++){
			sort.addItem(bookSorts[i]);
		}
		panel1.add(new JLabel("书籍类别",JLabel.RIGHT));
		panel1.add(sort);
		//创建价格，页数，关键词,数量
		price=new JTextField(20);
		panel1.add(new JLabel("价格：",JLabel.RIGHT));
		panel1.add(price);
		pageNum=new JTextField(20);
		panel1.add(new JLabel("页数：",JLabel.RIGHT));
		panel1.add(pageNum);
		keyWord=new JTextField(20);
		panel1.add(new JLabel("关键词：",JLabel.RIGHT));
		panel1.add(keyWord);
		num=new JTextField(20);
		panel1.add(new JLabel("数量 ：",JLabel.RIGHT));
		panel1.add(num);
		//创建备注
		JPanel panel2=new JPanel(new GridLayout(1, 2));
		remarks=new JTextArea(20,3);
		panel2.add(new JLabel("备注",JLabel.RIGHT));
		panel2.add(new JScrollPane(remarks));
		//创建提交按钮
		JPanel panel3=new JPanel(new GridLayout(1,2));
		submit=new JButton("提交");
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		reset=new JButton("重置");
		reset.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 remarks.setText("");
				
			}
		});
		panel3.add(submit);
		panel3.add(reset);
		//加入主面板
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
	}
/*	public static void main(String[] args) {
		JFrame test=new JFrame("test");
		test.setSize(600, 400);
		test.getContentPane().add(new BookInsertPanel());
		test.setVisible(true);
	}*/
}


