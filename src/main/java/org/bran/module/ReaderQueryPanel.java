package org.bran.module;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

import org.bran.db.DBOperation;
/**
 * 
 *<p>Title: ReaderQueryPanel.java</p>
 *<p>Description: 读者查询界面</p>
 * @author BranSummer
 * @date 2017年6月3日
 */
public class ReaderQueryPanel extends JPanel {
	//文本框  
	private JTextField query;
	//查询按钮
	private JButton queryb;
	//表格
	private JTable table;
	private DefaultTableModel model;
	private String[] headers={"读者号","姓名","性别","读者类型号","注册日期","备注"};
	private Object[][] cellData={{"","","","","",""}};
	/**
	 * constructor
	 */
	public ReaderQueryPanel(final DBOperation db){
		super();
		//创建分割面板
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.add(sp);
		//创建默认表格模型
		final DefaultTableModel model=new DefaultTableModel(cellData,headers){
			@Override
			public boolean isCellEditable(int row, int column) {
				return super.isCellEditable(row, column);
			}
		};
		table=new JTable(model);
		JScrollPane scroll=new JScrollPane();
		scroll.setViewportView(table);
		//创建标签
				JPanel panel1=new JPanel();
				panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
				panel1.add(new JLabel("输入读者号或者姓名查询",JLabel.CENTER));
				//输入区
				JPanel minPanel1=new JPanel();
				minPanel1.setLayout(new BoxLayout(minPanel1, BoxLayout.X_AXIS));
				minPanel1.add(new JLabel("查询内容:"));
				query=new JTextField(20);
				minPanel1.add(query);
				queryb=new JButton("查询");
				/**
				 * 【查询】按钮注册监听器
				 */
				minPanel1.add(queryb);	
				
				queryb.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String bookName=query.getText();
						int bookId=0;
						model.setRowCount(1);
						try{
							bookId=Integer.parseInt(bookName);
						}catch(NumberFormatException e1){
							bookId=0;
						}	
						bookName="%"+bookName+"%";
						ResultSet rs=null;
						PreparedStatement preStmt=null;
						String sql="use library select readerId,readerName,gender,typeid,signInDate,remark from reader where readerId=? or readerName like ?";
						try {
							preStmt=db.getPreparedStatement(sql);
							preStmt.setInt(1, bookId);
							preStmt.setString(2, bookName);
							
							rs=preStmt.executeQuery();
							for(int i=0;rs.next();i++){
								model.setValueAt(rs.getString("readerId"), i, 0);
								model.setValueAt(rs.getString("readerName"), i,1);
								model.setValueAt(rs.getString("gender"), i, 2);
								model.setValueAt(rs.getString("typeId"), i, 3);
								model.setValueAt(rs.getString("signInDate"), i, 4);
								model.setValueAt(rs.getString("remark"), i, 5);
								
								model.addRow(cellData);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				panel1.add(minPanel1);
				
				//加入分割面板
				sp.add(panel1, JSplitPane.TOP);
				sp.add(scroll, JSplitPane.BOTTOM);
	}
	
	
	public static void main(String[] args) {
		JFrame test=new JFrame("test");
		test.setSize(600, 400);
		test.getContentPane().add(new ReaderQueryPanel(new DBOperation()));
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
	}
}
