package org.bransummer.db_coursedesign_libaray;

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

import org.bran.module.BookInsertPanel;
import org.bran.module.BookQueryPanel;
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
	//查询
	private JMenu query;
	private JMenuItem bookQuery;
	private JMenuItem readerQuery;
	private JMenuItem borrowQuery;
	//数据操作
	private JMenu edit;
	private JMenuItem insert;
	private JMenuItem delete;
	private JMenuItem update;
	private JMenuItem readerDelete;
	public MainFrame(){
		super("图书馆");
		this.setSize(600, 400);
		this.setLocationRelativeTo(getOwner());
		this.getContentPane().add(new JPanel());
		//创建系统菜单
		system=new JMenu("系统");
		userManage=new JMenuItem("用户管理");
		exit=new JMenuItem("退出");
		borrow=new JMenuItem("借阅");
		system.add(userManage);
		system.add(exit);
		system.add(borrow);
		//创建查询菜单
		query=new JMenu("查询");
		bookQuery=new JMenuItem("图书查询");
		bookQuery.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().invalidate();
				getContentPane().add(new JScrollPane(new BookQueryPanel()));
				getContentPane().revalidate();
				setVisible(true);
				
			}
		});
		readerQuery=new JMenuItem("读者查询");
		borrowQuery=new JMenuItem("借阅查询");
		query.add(bookQuery);
		query.add(readerQuery);
		query.add(borrowQuery);
		//创建数据操作菜单
		edit=new JMenu("编辑");
		insert=new JMenuItem("添加");
		/**
		 * 【添加】注册监听器
		 */
		this.insert.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().invalidate();
				getContentPane().add(new JScrollPane(new BookInsertPanel()));
				getContentPane().revalidate();
				setVisible(true);
			}
		});
		delete=new JMenuItem("删除");
		/**
		 * 【删除】注册监听器
		 */
		delete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		update=new JMenuItem("更新");
		/**
		 * 【更新注册监听器】
		 */
		update.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
		edit.add(readerDelete);
		
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
				// TODO Auto-generated method stub
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
		new MainFrame();
	}
}
