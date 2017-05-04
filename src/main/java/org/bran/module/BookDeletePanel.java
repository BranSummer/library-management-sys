package org.bran.module;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
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
import javax.swing.table.TableColumn;

public class BookDeletePanel extends JPanel {
	//输入文本框
	private JTextField input;
	//按钮
	private JButton submit,delete;
	//表格
	private JTable table;
	private DefaultTableModel model;
	private String[] headers={"勾选","书号","书名","出版社","库存"};
	private Object[][] cellData={{false,"A1011","HTTP权威指南","图灵","20"}};
	//勾选复选框
	private JCheckBox[] checks;
	/**
	 * Create the panel.
	 */
	public BookDeletePanel() {
		super();
		//分割面板
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.add(sp);
		//获取表格行数
		checks=new JCheckBox[cellData.length];
		
		
		//表格
		DefaultTableModel model=new DefaultTableModel(cellData,headers){
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return super.isCellEditable(row, column);
			}
			@Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    default:
                        return String.class;
                }
            }
			
			
		};
		//表格填充复选框
		
		
		table=new JTable(model);
		
		JScrollPane scroll=new JScrollPane();
		scroll.setViewportView(table);
		//输入区
		JPanel panel1=new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.add(new JLabel("输入书号、书名、出版社查询书籍并选中删除书籍",JLabel.CENTER));
		JPanel minPanel1=new JPanel();
		minPanel1.setLayout(new BoxLayout(minPanel1, BoxLayout.X_AXIS));
		minPanel1.add(new JLabel("查询:"));
		input=new JTextField(20);
		minPanel1.add(input);
		delete=new JButton("删除");
		submit=new JButton("查询");
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
		test.getContentPane().add(new BookDeletePanel());
		test.setVisible(true);
	}

}
