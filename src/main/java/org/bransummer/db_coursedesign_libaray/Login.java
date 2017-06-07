package org.bransummer.db_coursedesign_libaray;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.bran.db.DBOperation;
import org.bran.valueBean.Reader;
/**
 * 
 *<p>Title: Login.java</p>
 *<p>Description: 登录界面</p>
 * @author BranSummer
 * @date 2017年4月27日
 */
public class Login extends JFrame {
	//用户名，密码输入域
	private JTextField username;
	private JPasswordField password;
	//提交，注册按钮
	private JButton submit,regist;
	//文本标签(用户名，密码)
	private JLabel nameLabel,pwdLabel;
	//借阅者，管理员
	private JRadioButton reader,admin;
	private ButtonGroup group;
	//注册界面
	private ReaderRegistFrame registFrame;
	//数据库连接接口
	private DBOperation db;
	//读者
	private Reader user;
	public Login(){
		super("登录界面");
		this.setSize(300, 150);
		this.setLocationRelativeTo(getOwner());
		Container container=this.getContentPane();
		username=new JTextField(10);
		password=new JPasswordField(10);
		db=new DBOperation();
		registFrame=new ReaderRegistFrame(db);
		
		/**
		 * 
		 */
		submit=new JButton("登录");
		/**
		 * 【登录】按钮注册监听器
		 */
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String userStr=username.getText();
				int userId=0;
				try{
					userId=Integer.parseInt(userStr);
				}catch(NumberFormatException e1){
					userId=0;
				}
				@SuppressWarnings("deprecation")
				String pwdStr=password.getText();
				String selesction=group.getSelection().toString();
				
				String sql="use library select * from reader where readerid=? and password=?";
				try {
					PreparedStatement ps=db.getPreparedStatement(sql);
					ps.setInt(1, userId);
					ps.setString(2, pwdStr);
					ResultSet rs=ps.executeQuery();
					if(rs.next()){
						user=new Reader();
						user.setId(rs.getInt("readerId")); //只获取了用户的Id和姓名
						user.setName(rs.getString("readerName"));
						new MainFrame(db,user);
						rs.close();
						setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "账号不存在或者密码不正确！","failure", JOptionPane.OK_CANCEL_OPTION);
						
					}
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "数据库连接异常","error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		regist=new JButton("注册");
		//TODO actionlistener
		regist.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				registFrame.setVisible(true);
			}
		});
		nameLabel=new JLabel("用户名:",JLabel.CENTER);
		pwdLabel=new JLabel("密 码:",JLabel.CENTER);
		//权限
		reader=new JRadioButton("借阅者");
		admin=new JRadioButton("管理员");
		group=new ButtonGroup();
		group.add(reader);
		group.add(admin);
		reader.setSelected(true);
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
