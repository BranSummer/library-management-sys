package org.bransummer.db_coursedesign_libaray;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
	public Login(){
		super("登录界面");
		this.setSize(300, 150);
		this.setLocationRelativeTo(getOwner());
		Container container=this.getContentPane();
		username=new JTextField(10);
		password=new JTextField(10);
		
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
				new ReaderRegistFrame();
			}
		});
		nameLabel=new JLabel("用户名:",JLabel.CENTER);
		pwdLabel=new JLabel("密 码:",JLabel.CENTER);
		container.setLayout(new GridLayout(3,2));
		container.add(nameLabel);
		container.add(username);
		container.add(pwdLabel);
		container.add(password);
		container.add(submit);
		container.add(regist);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new Login();
	}
}
