package org.bransummer.db_coursedesign_libaray;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * 
 *<p>Title: Login.java</p>
 *<p>Description: 登录界面</p>
 * @author BranSummer
 * @date 2017年4月27日
 */
public class Login extends JFrame {
	//用户名，密码输入域
	private JTextField username,password;
	//提交，注册按钮
	private JButton submit,regist;
	//文本标签(用户名，密码)
	private JLabel nameLabel,pwdLabel;
	//借阅者，管理员
	private JRadioButton reader,admin;
	//注册界面
	private ReaderRegistFrame registFrame;
	public Login(){
		super("登录界面");
		this.setSize(300, 150);
		this.setLocationRelativeTo(getOwner());
		Container container=this.getContentPane();
		username=new JTextField(10);
		password=new JTextField(10);
		registFrame=new ReaderRegistFrame();
		/**
		 * 
		 */
		submit=new JButton("登录");
		//TODO actionlistener
		regist=new JButton("注册");
		//TODO actionlistener
		regist.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				registFrame.setVisible(true);
			}
		});
		nameLabel=new JLabel("用户名:",JLabel.CENTER);
		pwdLabel=new JLabel("密 码:",JLabel.CENTER);
		//权限
		reader=new JRadioButton("借阅者");
		admin=new JRadioButton("管理员");
		ButtonGroup group=new ButtonGroup();
		group.add(reader);
		group.add(admin);
		container.setLayout(new GridLayout(4,2));
		
		container.add(nameLabel);
		container.add(username);
		container.add(pwdLabel);
		container.add(password);
		container.add(reader);
		container.add(admin);
		container.add(submit);
		container.add(regist);
		
		this.setResizable(false);
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
		new Login();
	}
}
