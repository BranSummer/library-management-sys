package org.bran.module;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
 *<p>Title: BookDeletePanel.java</p>
 *<p>Description:图书删除面板 </p>
 * @author BranSummer
 * @date 2017年5月4日
 */
public class BookDeletePanelV1 extends JPanel {
	//输入文本框
	private JTextField input;
	//按钮
	private JButton submit,delete;
	//表格
	private JTable table;
	private DefaultTableModel model;
	private String[] headers={"勾选","书号","ISBN","书名","出版社"};
	private Object[][] cellData={{false,"","","",""}};
	//勾选复选框
	private JCheckBox[] checks;
	/**
	 * Create the panel.
	 */
	public BookDeletePanelV1(final DBOperation db) {
		super();
		//分割面板
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.add(sp);
		//获取表格行数
		checks=new JCheckBox[cellData.length];
		
		
		//表格
		final DefaultTableModel model=new DefaultTableModel(cellData,headers){
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return super.isCellEditable(row, column);
			}
			/**
			 * jtabel内置复选框功能，须重写此方法
			 */
			@Override
            public Class<?> getColumnClass(int column) {
                Object value=getValueAt(0, column);
                if(value!=null){
                	return value.getClass();
                }else return super.getClass();
            }
			
			
		};
			
		table=new JTable(model);
		JScrollPane scroll=new JScrollPane();
		//显示表头
		scroll.setViewportView(table);
		//输入区
		JPanel panel1=new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.add(new JLabel("输入ISBN、书名、出版社查询书籍并选中删除书籍",JLabel.CENTER));
		JPanel minPanel1=new JPanel();
		minPanel1.setLayout(new BoxLayout(minPanel1, BoxLayout.X_AXIS));
		minPanel1.add(new JLabel("查询:"));
		input=new JTextField(20);
		minPanel1.add(input);
		delete=new JButton("删除");
		submit=new JButton("查询");
		/**
		 * 【查询】注册监听器
		 */
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String inputText=input.getText();
				int bookId=0;
				model.setRowCount(1);
				try{
					bookId=Integer.parseInt(inputText);
				}catch(NumberFormatException e1){
					bookId=0;
				}
				inputText="%"+inputText+"%";
				ResultSet rs=null;
				PreparedStatement preStmt=null;
				String sql="select bookid,bookname,ISBN,publishName from book where bookid=? or bookname like ? or ISBN like ?";
				try {
					preStmt=db.getPreparedStatement(sql);
					preStmt.setInt(1, bookId);
					preStmt.setString(2, inputText);
					preStmt.setString(3, inputText);
					
					rs=preStmt.executeQuery();
					for(int i=0;rs.next();i++){
						model.setValueAt(false, i, 0);
						model.setValueAt(rs.getString("bookId"), i,1);
						model.setValueAt(rs.getString("ISBN"), i, 2);
						model.setValueAt(rs.getString("bookName"), i, 3);
						model.setValueAt(rs.getString("publishName"), i, 4);
						
						model.addRow(cellData);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		minPanel1.add(submit);
		minPanel1.add(delete);
		panel1.add(minPanel1);
		//加入splitpane
		sp.add(panel1);
		sp.add(scroll, JSplitPane.BOTTOM);	
	}
	public static void main(String[] args) {
		JFrame test=new JFrame("test");
		test.setSize(600, 400);
		test.getContentPane().add(new BookDeletePanelV1(new DBOperation()));
		test.setVisible(true);
	}

}
