package org.bransummer.db_coursedesign_libaray;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.bran.db.DBOperation;
import org.bran.module.BookDeletePanel;
import org.bran.module.BookInsertPanel;
import org.bran.module.BookQueryPanel;
import org.bran.module.BookUpdatePanel;
import org.bran.module.BorrowPanel;
import org.bran.module.MyChartPanel;
import org.bran.module.ReaderQueryPanel;
import org.bran.valueBean.Reader;
/**
 * 
 *<p>Title: MainFrame.java</p>
 *<p>Description:主界面 </p>
 * @author BranSummer
 * @date 2017年4月30日
 */
public class MainFrame extends JFrame {
	private JMenuBar menuBar;
	
	//系统菜单项
	private JMenu system;
	private JMenuItem userManage;
	private JMenuItem exit;
	private JMenuItem borrow;
	private JMenuItem returnBook;
	//查询
	private JMenu query;
	private JMenuItem bookQuery;
	private JMenuItem readerQuery;
	private JMenuItem borrowQuery;
	private JMenuItem chart;
	//数据操作
	private JMenu edit;
	private JMenuItem insert;
	private JMenuItem delete;
	private JMenuItem update;
	private JMenuItem readerDelete;
	//图书查询界面
	private JScrollPane bookQueryPanel;
	//图书删除界面
	private JScrollPane bookDeletePanel;
	//图书添加界面
	private JScrollPane bookInsertPanel;
	//图书修改界面
	private JScrollPane bookUpdatePanel;
	//图表面板
	private MyChartPanel myChartPanel;
	//读者查询面板
	private JScrollPane readerQueryPanel;
	//借阅面板
	private JScrollPane borrowPanel;
	//数据库连接
	private DBOperation db;
	/**
	 * constructor
	 * @param db
	 * @param reader
	 */
	public MainFrame(final DBOperation db,final Reader reader){
		super("图书馆");
		this.setSize(800, 500);
		this.setLocationRelativeTo(getOwner());
		this.getContentPane().add(new JPanel());
		//创建系统菜单		
		system=new JMenu("系统");
		userManage=new JMenuItem("用户查询");
		userManage.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(readerQueryPanel==null){
					readerQueryPanel=new JScrollPane(new ReaderQueryPanel(db));
				}
				setContentPane(readerQueryPanel);
				invalidate();
				validate();
				
			}
		});
		exit=new JMenuItem("退出");
		/**
		 * 【退出】注册监听器
		 */
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				new Login();
				setVisible(false);
				System.gc();
				
			}
		});
		borrow=new JMenuItem("借阅/还书");
		borrow.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(borrowPanel==null){
					borrowPanel=new JScrollPane(new BorrowPanel(reader,db));
				}
				setContentPane(borrowPanel);
				invalidate();
				validate();
				
			}
		});
		returnBook=new JMenuItem("还书");
		system.add(userManage);
		system.add(exit);
		system.add(borrow);
//		system.add(returnBook);
		//创建查询菜单
		query=new JMenu("查询");
		bookQuery=new JMenuItem("图书查询");
		/**
		 * 【查询】注册监听器
		 */
		bookQuery.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(bookQueryPanel==null){
					bookQueryPanel=new JScrollPane(new BookQueryPanel(db));
				}
				setContentPane(bookQueryPanel);
				invalidate();
				validate();
			}
		});
//		readerQuery=new JMenuItem("读者查询");
		borrowQuery=new JMenuItem("借阅查询");
		chart=new JMenuItem("图表");
		/**
		 * 【图表】注册监听器
		 */
		chart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(myChartPanel==null){
					myChartPanel=new MyChartPanel(db);
				}
				setContentPane(myChartPanel);
				invalidate();
				validate();
				
			}
		});
		query.add(bookQuery);
//		query.add(readerQuery);
		query.add(borrowQuery);
		query.add(chart);
		//创建数据操作菜单
		edit=new JMenu("编辑");
		insert=new JMenuItem("添加");
		/**
		 * 【添加】注册监听器
		 */
		this.insert.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(bookInsertPanel==null){
					bookInsertPanel=new JScrollPane(new BookInsertPanel(db));
				}
				setContentPane(bookInsertPanel);
				invalidate();
				validate();
			}
		});
		delete=new JMenuItem("删除");
		/**
		 * 【删除】注册监听器
		 */
		delete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(bookDeletePanel==null){
					bookDeletePanel=new JScrollPane(new BookDeletePanel(db));
				}
				setContentPane(bookDeletePanel);	
				invalidate();
				validate();
			}
		});
		update=new JMenuItem("更新");
		/**
		 * 【更新注册监听器】
		 */
		update.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(bookUpdatePanel==null){
					bookUpdatePanel=new JScrollPane(new BookUpdatePanel(db));
					bookUpdatePanel.setPreferredSize(new Dimension(600, 400));
				}
				setContentPane(bookUpdatePanel);
				invalidate();
				validate();
			}
		});
		readerDelete=new JMenuItem("读者删除");
		/**
		 * 【读者删除】注册监听器
		 */
		readerDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		edit.add(insert);
		edit.add(delete);
		edit.add(update);
//		edit.add(readerDelete);
		
		menuBar=new JMenuBar();
		menuBar.add(system);
		menuBar.add(query);
		menuBar.add(edit);
		this.setJMenuBar(menuBar);
	
		
		
		//windows监听器
		this.addWindowListener(new WindowListener() {
			
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MainFrame(new DBOperation(),new Reader());
	}
}
