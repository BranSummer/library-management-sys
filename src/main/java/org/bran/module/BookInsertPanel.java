package org.bran.module;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.bran.db.DBOperation;
/**
 * 
 *<p>Title: BookInsertPanel.java</p>
 *<p>Description:添加图书信息所用的面板 </p>
 * @author BranSummer
 * @date 2017年5月1日
 */
public class BookInsertPanel extends JPanel {
	//编号，书名，作者，出版社，价格，页码，关键词，数量
	private JTextField bookId,bookName,author,publish,price,pageNum,keyWord,num;
	//书籍类别
	private JComboBox<String> sort;
	private String[] bookSorts={"小说","文学","传记","艺术","少儿","社会科学","计算机","教辅","历史","医学"};
	//出版日期手动输入，登记日期由系统录入
	private DatePanel pubDate;
	//备注
	private JTextArea remarks;
	//提交，重置按钮
	private JButton submit,reset;

	public BookInsertPanel(final DBOperation db){
		super();
		//布局
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//输入区表格布局		
		JPanel panel1=new JPanel(new GridLayout(10, 2));
		//创建图书编号，书名,作者,出版社
		bookId=new JTextField(20);
		panel1.add(new JLabel("ISBN：",JLabel.RIGHT));
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
		/**
		 * 【提交】按钮注册监听器,从输入文本域中获取信息，通过封装的DBOperation对象连接数据库，将数据插入到book表中，
		 * 书籍的注册时间有系统获取，
		 * 书籍编号由数据库的自增序列填充
		 * 根据输入数量确定插入次数
		 */
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int bookNum=0;
				float priceFloat=0;	
				int pageNumInt=0;
				Long now=new Date().getTime();
				java.sql.Date dateNow=new java.sql.Date(now);
				String sql="insert into book(ISBN,bookname,author,booksort,publishname,publishdate,price,pagenum,keywords,"
						+ "registerdate,remarks) values(?,?,?,?,?,?,?,?,?,?,?)";
				try{
					//输入域类型转换
					priceFloat=Float.parseFloat(price.getText());
					bookNum=Integer.parseInt(num.getText());
					pageNumInt=Integer.parseInt(pageNum.getText());
					//预编译处理
					PreparedStatement preStmt=db.getPreparedStatement(sql);
					preStmt.setString(1, bookId.getText());
					preStmt.setString(2, bookName.getText());
					preStmt.setString(3, author.getText());
					preStmt.setString(4, sort.getSelectedItem().toString());
					preStmt.setString(5, publish.getText());
					preStmt.setDate(6, pubDate.getDate());
					preStmt.setFloat(7, priceFloat);
					preStmt.setInt(8,pageNumInt);
					preStmt.setString(9, keyWord.getText());
					preStmt.setDate(10, dateNow);
					preStmt.setString(11, remarks.getText());
					
					for(int i=0;i<bookNum;i++){
						preStmt.addBatch();
					}
					int[] rows=preStmt.executeBatch();
					
					if(rows.length==bookNum){
						JOptionPane.showMessageDialog(null, "数据插入成功", "sucess", JOptionPane.OK_OPTION);
					}
				}catch(NumberFormatException e){
					System.out.println("数字输入格式不正确！");
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "请输入正确的数字格式", "error", JOptionPane.CANCEL_OPTION);
				} catch (SQLException e) {
					System.out.println("数据库异常！");
					e.printStackTrace();
				}
				
			}
		});
		reset=new JButton("重置");
		/**
		 * 【重置】按钮清空所有文本域
		 */
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


