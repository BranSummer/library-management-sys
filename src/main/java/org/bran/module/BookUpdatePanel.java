package org.bran.module;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
/**
 * 
 *<p>Title: BookUpdatePanel.java</p>
 *<p>Description:图书更新面板 </p>
 * @author BranSummer
 * @date 2017年5月4日
 */
import javax.swing.JTextField;

import org.bran.db.DBOperation;
public class BookUpdatePanel extends JPanel {
	//查询文本框，查询按钮
	private JTextField queryText;
	private JButton queryButton;
	//更新按钮
	private JButton updateButton;
	//修改文本框(书名，出版社，作者，价格，关键词，)
	private JTextField bookName,publishName,author,price,pageNum,keyWord;
	//修改类别
	private JComboBox<String> sort;
	private String[] bookSorts={"小说","文学","传记","艺术","少儿","社会科学","计算机","教辅","历史","医学"};
	private JLabel sortLabel;
	//修改备注
	private JTextArea remarks;
	/**
	 * constructor
	 */
	public BookUpdatePanel(final DBOperation db){
		super();
		//在设置JPanel大小的时候,要用JPanel.setPreferredSize()这个方法才行
		
		//创建分割面板
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.add(sp);
		//top面板，放置按钮及查询文本框
		JPanel topPanel=new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		topPanel.add(new JLabel("输入ISBN修改需要查询的图书"));
		//按钮及查询文本框面板
		JPanel inputPanel=new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		inputPanel.add(new JLabel("请输入ISBN："));
		queryText=new JTextField(30);
		inputPanel.add(queryText);
		queryButton=new JButton("查询");
		queryButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String ISBN=queryText.getText();
				ResultSet rs=null;
				PreparedStatement pStmt=null;
				
				try {
					String sql="select bookname,publishname,author,price,booksort,remarks from book where ISBN=?";
					pStmt=db.getPreparedStatement(sql);
					pStmt.setString(1, ISBN);
					
					rs=pStmt.executeQuery();
					if(rs.next()){
						bookName.setText(rs.getString("bookName"));
						publishName.setText(rs.getString("publishName"));
						author.setText(rs.getString("author"));
						sortLabel.setText(rs.getString("bookSort"));
						price.setText(rs.getString("price"));
						remarks.setText(rs.getString("remarks"));
						JOptionPane.showMessageDialog(null, "查询完成\n点击按钮确认修改","OK", JOptionPane.OK_CANCEL_OPTION);
					}else JOptionPane.showMessageDialog(null, "未查询到信息","failure", JOptionPane.OK_CANCEL_OPTION);
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		inputPanel.add(queryButton);
		updateButton=new JButton("确认修改");
		updateButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String ISBN=queryText.getText();
				String nameText=bookName.getText();
				String publishText=publishName.getText();
				String authorText=author.getText();
				String sortText=sort.getSelectedItem().toString();
				 float priceFloat=Float.parseFloat(price.getText());
				String remarksText=remarks.getText();
				
				String sql="update book set bookname=?,publishName=?,author=?,booksort=?,price=?,remarks=? where ISBN=?";
				
				
				PreparedStatement pStmt=null;
				try {
					pStmt=db.getPreparedStatement(sql);
					pStmt.setString(1,nameText);
					pStmt.setString(2, publishText);
					pStmt.setString(3, authorText);
					pStmt.setString(4, sortText);
					pStmt.setDouble(5, priceFloat);
					pStmt.setString(6, remarksText);
					pStmt.setString(7, ISBN);
					pStmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "修改成功","OK", JOptionPane.OK_CANCEL_OPTION);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		inputPanel.add(updateButton);
		topPanel.add(inputPanel);
		//修改项面板
		JPanel bottomPanel=new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		//书名修改面板
		JPanel panel1=new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		panel1.add(new JLabel("书　名："));
		bookName=new JTextField();
		panel1.add(bookName);
		//出版社修改面板
		JPanel panel2=new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		panel2.add(new JLabel("出版社："));
		publishName=new JTextField();
		panel2.add(publishName);
		//作者修改面板
		JPanel panel3=new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		panel3.add(new JLabel("作　者："));
		author=new JTextField();
		panel3.add(author);
		//价格修改面板
		JPanel panel4=new JPanel();
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
		panel4.add(new JLabel("价　格："));
		price=new JTextField();
		panel4.add(price);
		//类别修改面板
		JPanel panel5=new JPanel();
		panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));
		sortLabel=new JLabel("");
		panel5.add(new JLabel("类　别："));
		sort=new JComboBox<String>();
		for(int i=0;i<bookSorts.length;i++){
			sort.addItem(bookSorts[i]);
		}
		panel5.add(sort);
		panel5.add(sortLabel);
		//备注修改面板
		JPanel panel6=new JPanel();
		panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));
		panel6.add(new JLabel("备　注："));
		remarks=new JTextArea(5,20);
		panel6.add(remarks);
		//各修改项面板加入bottomPanel
		bottomPanel.add(panel1);
		bottomPanel.add(panel2);
		bottomPanel.add(panel3);
		bottomPanel.add(panel4);
		bottomPanel.add(panel5);
		bottomPanel.add(panel6);
		//topPanel,bottomPanel加入分割面板
		sp.add(topPanel, JSplitPane.TOP);
		sp.add(bottomPanel, JSplitPane.BOTTOM);
	}
}
